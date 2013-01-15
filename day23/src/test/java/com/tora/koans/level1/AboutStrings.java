package com.tora.koans.level1;

import org.junit.*;
import static com.tora.koans.ImplementationStub.*;

public final class AboutStrings {

	@Test
	public void implicitStrings() {
		Class<?> c = "just a plain ole string".getClass();
		assertEquals(c, __);
	}

	@Test
	public void newString() {
		// very rarely if ever should Strings be created via new String() in
		// practice - generally it is redundant, and done repetitively can be
		// slow
		String string = new String();
		String empty = "";
		assertEquals(string.equals(empty), __);
	}

	@Test
	public void newStringIsRedundant() {
		String stringInstance = "zero";
		String stringReference = new String(stringInstance);
		assertEquals(stringInstance.equals(stringReference), __);
	}

	@Test
	public void newStringIsNotIdentitical() {
		String stringInstance = "zero";
		String stringReference = new String(stringInstance);
		assertEquals(stringInstance == stringReference, __);
	}

	@Test
	public void stringConcatination() {
		String one = "one";
		String space = " ";
		String two = "two";
		assertEquals(one + space + two, __);
	}

	@Test
	public void efficientStringConcatenation() {
		// the above implicit string concatenation looks nice - but, it is
		// expensive.
		// it creates a new string instance on each concatenation. here's a
		// better alternative:
		assertEquals(new StringBuilder("one").append(" ").append("two")
				.toString(), __);
	}

	@Test
	public void stringEscapeCharacters() {
		String str = "\t\\n\n\r";
		assertEquals(str.length(), __);
		assertEquals(str.charAt(1), __);
		assertEquals(str.charAt(2), __);
		assertEquals(str.charAt(3), __);
	}

}
