package com.tora.koans.level2;

import java.util.regex.*;
import org.junit.*;
import static com.tora.koans.ImplementationStub.*;

public final class AboutRegularExpressions {

	@Test
	public void basicMatching() {
		Pattern p = Pattern.compile("xyz");
		Matcher m = p.matcher("xyzxxxxyz");
		// index 012345678
		assertEquals(m.find(), __);
		assertEquals(m.start(), __);
		assertEquals(m.find(), __);
		assertEquals(m.start(), __);
		assertEquals(m.find(), __);
	}

	@Test
	public void extendedMatching() {
		Pattern p = Pattern.compile("x.z");
		Matcher m = p.matcher("xyz u x z u xfz");
		// index 012345678901234
		assertEquals(m.find(), __);
		assertEquals(m.start(), __);
		assertEquals(m.find(), __);
		assertEquals(m.start(), __);
		assertEquals(m.find(), __);
		assertEquals(m.start(), __);
	}

	@Test
	public void escapingMetaCharacters() {
		Pattern p = Pattern.compile("end\\.");
		Matcher m = p.matcher("begin. end.");
		// index 01234567890
		assertEquals(m.find(), __);
		assertEquals(m.start(), __);
	}

	@Test
	public void splittingStrings() {
		String csvDataLine = "1,name,description";
		String[] data = csvDataLine.split(","); // you can use any regex here
		assertEquals(data[0], __);
		assertEquals(data[1], __);
		assertEquals(data[2], __);
	}

	@Test
	public void splittingStringsByEscapedChars() {
		String dataLine = "1\\nName\\nDescription\n" + "2\\nHello\\nWorld\n";
		assertEquals(dataLine.split("\n").length, __);
		assertEquals(dataLine.split("\\\\n").length, __);
	}

	@Test
	public void replacingStrings() {
		String str = "this.is.a.test";
		assertEquals(str.replaceAll(".", " "), __);
	}

	@Test
	public void replacingStrings2() {
		String str = "this_is_a_test";
		assertEquals(str.replaceAll("_", "\\"), __);
	}
}
