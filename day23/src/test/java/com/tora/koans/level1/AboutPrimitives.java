package com.tora.koans.level1;

import org.junit.*;
import static com.tora.koans.ImplementationStub.*;

public final class AboutPrimitives {

	@Test
	public void byteSize() {
		assertEquals(Byte.SIZE, __);
	}

	@Test
	public void shortSize() {
		assertEquals(Short.SIZE, __);
	}

	@Test
	public void integerSize() {
		assertEquals(Integer.SIZE, __);
	}

	@Test
	public void longSize() {
		assertEquals(Long.SIZE, __);
	}

	@Test
	public void charSizeAndValue() {
		// a char basically is an unsigned int
		assertEquals(Character.SIZE, __);
		assertEquals(Character.MIN_VALUE, __);
		assertEquals(Character.MAX_VALUE, __);
	}

	// Floating Points
	@Test
	public void floatSize() {
		assertEquals(Float.SIZE, __);
	}

	@Test
	public void doubleSize() {
		assertEquals(Double.SIZE, __);
	}
}
