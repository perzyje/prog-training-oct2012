package com.tora.rpsls;

import java.io.*;
import java.net.*;
import java.nio.charset.Charset;
import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicLong;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class Server {
	public final static int GAME_PORT = 9998;
	private final static int MAX_HISTORY_ELEMENT = 100;

	private static final Logger logger = LoggerFactory.getLogger(Server.class
			.getCanonicalName());

	private Server() {

	}

	static final class Client {
		private final BufferedReader in;
		private final DataOutputStream out;
		private final String identity;
		private final Socket connectionSocket;

		private Client(Socket connectionSocket) throws IOException {
			this.connectionSocket = connectionSocket;
			in = new BufferedReader(
					new InputStreamReader(connectionSocket.getInputStream(),
							Charset.forName("UTF-8")));
			out = new DataOutputStream(connectionSocket.getOutputStream());

			String clientId = in.readLine();
			identity = getSocketIP(connectionSocket) + "/" + clientId;
		}

		private void tryClose() {
			clients.remove(this);
			try {
				out.flush();
			} catch (IOException ex) {
			}
			try {
				out.close();
			} catch (IOException ex) {
			}
			try {
				in.close();
			} catch (IOException ex) {
			}
			try {
				connectionSocket.close();
			} catch (IOException ex) {
			}
		}

		private Choice tryRead(String opponent) {
			try {
				out.writeBytes("CHOICE " + opponent + "\n");
				out.flush();
				return Choice.valueOf(in.readLine());
			} catch (IOException ex) {
				tryClose();
				throw new IllegalStateException(ex);
			}
		}

		private void sendOutcome(Outcome outcome, String opponent,
				Choice opponentsChoice, Choice myChoice) {
			try {
				out.writeBytes(String.format("OUTCOME %s %s %s %s%n", outcome,
						opponentsChoice, myChoice, opponent));
				out.flush();
			} catch (IOException ex) {
				tryClose();
				throw new IllegalStateException(ex);
			}
		}
	}

	static class Counter implements Comparable<Counter> {
		private final AtomicLong wins, plays;
		private final String identity;

		Counter(String identity) {
			this.identity = identity;
			this.wins = new AtomicLong();
			this.plays = new AtomicLong();
		}

		void win() {
			plays.incrementAndGet();
			wins.incrementAndGet();
		}

		void loose() {
			plays.incrementAndGet();
		}

		@Override
		public int compareTo(Counter that) {
			return Double.compare(this.getRatio(), that.getRatio());
		}

		private double getRatio() {
			return 1.0 * wins.get() / plays.get();
		}
	}

	private final static List<Client> clients = new CopyOnWriteArrayList<Client>();
	private final static ConcurrentMap<String, Counter> scores = new ConcurrentHashMap<String, Counter>();

	private static String getSocketIP(Socket socket) {
		return ((InetSocketAddress) socket.getRemoteSocketAddress())
				.getAddress().getHostAddress();
	}

	private static Counter getCounter(String identity) {
		Counter counter = scores.get(identity);
		if (counter == null) {
			counter = new Counter(identity);
			Counter prev = scores.putIfAbsent(identity, counter);
			if (prev != null) {
				counter = prev;
			}
		}
		return counter;
	}

	private final static class Acceptor implements Runnable {
		@Override
		public void run() {
			ServerSocket serverSocket = null;
			try {
				serverSocket = new ServerSocket(GAME_PORT);
			} catch (IOException ex) {
				logger.error("Error while listening with acceptor", ex);
				System.exit(1);
			}

			logger.info("Acceptor up");
			while (true) {
				try {
					Socket connectionSocket = serverSocket.accept();
					Client c = new Client(connectionSocket);
					clients.add(c);
					logger.info("Accepted from " + c.identity);
				} catch (IOException ex) {
					logger.error("Error while accepting client", ex);
				}
			}
		}
	}

	private final static class GameEngine implements Runnable {
		@SuppressWarnings("deprecation")
		@Override
		public void run() {
			while (true) {
				for (final Client ci : clients) {
					for (final Client cj : clients) {
						if (ci == cj) {
							continue;
						}
						if (ci.identity.equals(cj.identity)) {
							continue;
						}
						if (getSocketIP(ci.connectionSocket).equals(
								getSocketIP(cj.connectionSocket))) {
							continue;
						}
						logger.info("Facing of " + ci.identity + " and "
								+ cj.identity);

						final Outcome[] resultHolder = new Outcome[1];
						final Exception[] exceptionHolder = new Exception[1];
						Thread t = new Thread(new Runnable() {
							@Override
							public void run() {
								try {
									Choice a = ci.tryRead(cj.identity), b = cj.tryRead(ci.identity);
									Outcome result = a.getOutcome(b);
									ci.sendOutcome(result, cj.identity, b, a);
									cj.sendOutcome(result.getNegation(),
											ci.identity, a, b);
									resultHolder[0] = result;
								} catch (Exception ex) {
									exceptionHolder[0] = ex;
								}
							}
						}, ci.identity + " vs " + cj.identity);

						try {
							t.start();
							t.join(1000);

							if (t.isAlive()) {
								logger.error("Timeout");
								t.interrupt();
								t.stop();
								continue;
							}

							if (exceptionHolder[0] != null) {
								logger.error("Error", exceptionHolder[0]);
								continue;
							}

							Outcome outcome = resultHolder[0];
							logger.info("Faced of " + ci.identity + " and "
									+ cj.identity + ". Outcome: " + outcome);
							switch (outcome) {
							case WIN:
								getCounter(ci.identity).win();
								getCounter(cj.identity).loose();
								break;
							case LOOSE:
								getCounter(ci.identity).loose();
								getCounter(cj.identity).win();
								break;
							case TIE:
								getCounter(ci.identity).loose();
								getCounter(cj.identity).loose();
								break;
							}
						} catch (InterruptedException e) {
							logger.error("Error", e);
						}
					}
				}

				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					break;
				}
			}
		}
	}

	private static final class ResultsPage implements Runnable {
		@Override
		public void run() {
			ServerSocket serverSocket = null;
			try {
				serverSocket = new ServerSocket(8082);
			} catch (IOException ex) {
				logger.error("Error while listening with results page", ex);
				System.exit(1);
			}

			Map<String, List<Double>> previousScores = new HashMap<String, List<Double>>();

			logger.info("Results page up");
			while (true) {
				try {
					Socket connectionSocket = serverSocket.accept();
					Client client = new Client(connectionSocket);
					logger.info("Sending result to "
							+ connectionSocket.getRemoteSocketAddress());

					List<Counter> counters = new ArrayList<Counter>(
							scores.values());
					Collections.sort(counters);
					Collections.reverse(counters);

					for (Counter c : counters) {
						List<Double> scores = previousScores.get(c.identity);
						if (scores == null) {
							scores = new ArrayList<Double>();
							previousScores.put(c.identity, scores);
						}

						scores.add(c.getRatio());
						while (scores.size() > MAX_HISTORY_ELEMENT) {
							scores.remove(0);
						}
					}

					StringBuilder result = new StringBuilder(
							"<html><head>"
									+ "<meta http-equiv='refresh' content='5'>"
									+ "<script type='text/javascript' src='https://www.google.com/jsapi'></script>"
									+ "</head><body><h1>Results</h1><ol>");
					for (Counter c : counters) {
						result.append("<li>")
								.append(c.identity)
								.append(": ")
								.append(String.format("%.2f%%",
										c.getRatio() * 100.0))
								.append(String.format(" (out of %d)",
										c.plays.get())).append("</li>\n");
					}
					result.append("<div id='chart_div' style='width: 900px; height: 500px; float: right; position: absolute;'></div>");
					result.append("</ol>");

					result.append(
							"<script>google.load(\"visualization\", \"1\", {packages:[\"corechart\"]});")
							.append("google.setOnLoadCallback(drawChart);\n")
							.append("function drawChart() { var data = google.visualization.arrayToDataTable([\n");

					result.append("['x', ");
					for (Counter c : counters) {
						result.append("'").append(c.identity).append("', ");
					}
					result.append("],\n");

					for (int i = 0; i < MAX_HISTORY_ELEMENT; ++i) {
						if (i % 4 != 0) {
							continue;
						}
						result.append("['" + (-MAX_HISTORY_ELEMENT + i) + "', ");
						for (Counter c : counters) {
							List<Double> scores = previousScores
									.get(c.identity);
							if (i >= scores.size()) {
								result.append("null, ");
							} else {
								result.append(scores.get(i) * 100).append(", ");
							}
						}
						result.append("],\n");
					}

					result.append("]);\n");
					result.append("new google.visualization.LineChart(document.getElementById('chart_div')).draw(data, {curveType: 'function'}); }</script>");
					result.append("</body></html>");

					client.out.writeBytes("HTTP/1.0 200 OK\n\r"
							+ "Content-Length: " + result.length() + "\n\r"
							+ "Content-Type: text/html\n\r\n\r" + result);
					client.tryClose();
				} catch (IOException ex) {
					logger.error("Error while accepting client", ex);
				}
			}
		}
	}

	private final static class RandomClient extends GameClient implements
			Runnable {
		RandomClient() {
			super("127.1.2.3", GAME_PORT, "ServerDefaultRandom");
		}

		private final Random r = new Random();
		private final Choice[] values = Choice.values();

		@Override
		public void run() {
			while (true) {
				try {
					GameClient randomClient = new RandomClient();
					randomClient.run();
				} catch (IOException ex) {
					logger.error("Error in random client, restarting", ex);
				}
			}
		}

		@Override
		Choice getChoice(String opponent) {
			return values[r.nextInt(values.length)];
		}

		@Override
		void lastOutcome(String opponent, Choice opponentsChoice,
				Choice myChoice, Outcome outcome) {
			logger.debug("Last outcome: " + outcome);
		}
	}

	public static void main(String[] args) throws Exception {
		// acceptor
		new Thread(new Acceptor(), "acceptor").start();

		// game engine
		new Thread(new GameEngine(), "game engine").start();

		// results page
		new Thread(new ResultsPage(), "results page").start();

		// random client
		new Thread(new RandomClient(), "random client").start();
	}
}
