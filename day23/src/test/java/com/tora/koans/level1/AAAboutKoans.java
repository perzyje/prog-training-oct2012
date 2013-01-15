package com.tora.koans.level1;

import org.junit.*;
import static com.tora.koans.ImplementationStub.*;

public final class AAAboutKoans {

	@Test
	public void findAboutKoansFile() {
		fail("delete this line");
	}

	@Test
	public void definitionOfKoanCompletion() {
		boolean koanIsComplete = false;
		if (!koanIsComplete) {
			fail("what if koanIsComplete was true?");
		}
	}

	@Test(expected = ArrayIndexOutOfBoundsException.class)
	public void howToCachtExpception() {
		throw new IllegalArgumentException("What should we declare in test?");
	}

	@Test
	public void completeAssertions() {
		assertEquals("what should __ be replaced with?", __);
	}
}
