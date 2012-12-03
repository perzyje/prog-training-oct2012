package com.tora.rpsls;

import java.io.*;
import java.net.*;

abstract class GameClient {
	private final String address;
	private final int port;
	private final String name;

	GameClient(String address, int port, String name) {
		this.address = address;
		this.port = port;
		this.name = name;
	}

	void run() throws IOException {
		Socket clientSocket = new Socket(address, port);
		DataOutputStream out = new DataOutputStream(clientSocket.getOutputStream());
		BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
		out.writeBytes(name + "\n"); out.flush();
		
		String line;
		while ( (line = in.readLine()) != null ) {
			String[] parts = line.split(" ", 5);
			
			if (parts[0].equals("CHOICE") && parts.length == 2) {
				out.writeBytes(getChoice(parts[1]) + "\n");
				out.flush();				
			} else if (parts[0].equals("OUTCOME") && parts.length == 5) {
				Outcome outcome = Outcome.valueOf(parts[1]);
				Choice opponentsChoice = Choice.valueOf(parts[2]),
					myChoice = Choice.valueOf(parts[3]);
				lastOutcome(parts[4], opponentsChoice, myChoice, outcome);
			} else {
				System.err.println(line);
			}
		}
		
		in.close();
		out.close();
		clientSocket.close();
	}

	abstract Choice getChoice(String opponent);
	
	abstract void lastOutcome(String opponent, Choice opponentsChoice, Choice myChoice, Outcome outcome);
}
