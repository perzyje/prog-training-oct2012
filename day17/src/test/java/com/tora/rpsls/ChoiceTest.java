package com.tora.rpsls;

import org.junit.*;
import static org.junit.Assert.*;
import static com.tora.rpsls.Choice.*;

public final class ChoiceTest {
	@Test
	public void testRules() {
		//1. Scissors cuts﻿ Paper
		assertEquals(Outcome.WIN, SCRISSORS.getOutcome(PAPER));
		//2. Paper covers Rock
		assertEquals(Outcome.WIN, PAPER.getOutcome(ROCK));
		//3. Rock crushes Lizard
		assertEquals(Outcome.WIN, ROCK.getOutcome(LIZARD));
		//4. Lizard poisons Spock
		assertEquals(Outcome.WIN, LIZARD.getOutcome(SPOCK));
		//5. Spock smashes Scissors
		assertEquals(Outcome.WIN, SPOCK.getOutcome(SCRISSORS));
		//6. Scissors decapitates Lizard
		assertEquals(Outcome.WIN, SPOCK.getOutcome(SCRISSORS));
		//7. Lizard eats Paper
		assertEquals(Outcome.WIN, LIZARD.getOutcome(PAPER));
		//8. Paper disproves Spock
		assertEquals(Outcome.WIN, PAPER.getOutcome(SPOCK));
		//9. Spock vaporizes Rock
		assertEquals(Outcome.WIN, SPOCK.getOutcome(ROCK));
		//10. Rock crushes Scissors		
		assertEquals(Outcome.WIN, ROCK.getOutcome(SCRISSORS));
	}
	
	@Test
	public void testTies() {
		for (Choice c : Choice.values()) {
			assertEquals(Outcome.TIE, c.getOutcome(c));
		}
	}
}
