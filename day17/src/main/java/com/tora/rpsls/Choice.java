package com.tora.rpsls;

public enum Choice {
	ROCK, PAPER, SCRISSORS, LIZARD, SPOCK;
	
	private final static Outcome[][] OUTCOME 
		= new Outcome[Choice.values().length][Choice.values().length];
	
	static {
		// 1. Scissors cuts﻿ Paper
		// 6. Scissors decapitates Lizard
		beats(SCRISSORS, PAPER, LIZARD);
		// 2. Paper covers Rock
		// 8. Paper disproves Spock
		beats(PAPER, ROCK, SPOCK);
		// 3. Rock crushes Lizard
		// 10. Rock crushes Scissors	
		beats(ROCK, LIZARD, SCRISSORS);
		// 4. Lizard poisons Spock
		// 7. Lizard eats Paper
		beats(LIZARD, SPOCK, PAPER);
		// 5. Spock smashes Scissors
		// 9. Spock vaporizes Rock
		beats(SPOCK, SCRISSORS, ROCK);
		
		for (Choice c : Choice.values()) {
			setOutcome(c.ordinal(), c.ordinal(), Outcome.TIE);
		}
		
		for (Outcome[] oArray : OUTCOME) {
			for (Outcome o : oArray) {
				if (o != null) { continue; }
				throw new AssertionError();
			}
		}
	}
	private static void beats(Choice who, Choice... whom) {
		for (Choice w : whom) {
			setOutcome(who.ordinal(), w.ordinal(), Outcome.WIN);
			setOutcome(w.ordinal(), who.ordinal(), Outcome.LOOSE);
		}
	}
	private static void setOutcome(int a, int b, Outcome outcome) {
		if (OUTCOME[a][b] != null) {
			throw new AssertionError();
		}
		OUTCOME[a][b] = outcome;
	}
	
	public Outcome getOutcome(Choice choice) {
		return OUTCOME[this.ordinal()][choice.ordinal()];
	}
}
