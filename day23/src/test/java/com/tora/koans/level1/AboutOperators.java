package com.tora.koans.level1;

import org.junit.*;
import static com.tora.koans.ImplementationStub.*;

public final class AboutOperators {

	@Test
	public void plusPlusVariablePlusPlus() {
		int i = 1;
		assertEquals(++i, __);
		assertEquals(i, __);
		assertEquals(i++, __);
		assertEquals(i, __);
	}

	@Test
	public void shortCircuit() {
		int i = 1;
		int a = 6; // Why did we use a variable here?
		// What happens if you replace 'a' with '6' below?
		// Try this with an IDE like Eclipse...
		if ((a < 9) || (++i < 8)) {
			i = i + 1;
		}
		assertEquals(i, __);
	}

	@Test
	public void fullAnd() {
		int i = 1;
		if (true & (++i < 8)) {
			i = i + 1;
		}
		assertEquals(i, __);
	}

	@Test
	public void shortCircuitAnd() {
		int i = 1;
		if (true && (i < -28)) {
			i = i + 1;
		}
		assertEquals(i, __);
	}

	@Test
	public void aboutXOR() {
		int i = 1;
		int a = 6;
		if ((a < 9) ^ false) {
			i = i + 1;
		}
		assertEquals(i, __);
	}

	@Test
	public void dontMistakeEqualsForEqualsEquals() {
		int i = 1;
		boolean a = false;
		if (a = true) {
			i++;
		}
		assertEquals(a, __);
		assertEquals(i, __);
		// How could you write the condition 'with a twist' to avoid this trap?
	}

	@Test
	public void aboutBitShiftingRightShift() {
		int rightShift = 8;
		rightShift = rightShift >> 1;
		assertEquals(rightShift, __);
	}

	@Test
	public void aboutBitShiftingLeftShift() {
		int leftShift = 0x80000000; // Is this number positive or negative?
		leftShift = leftShift << 1;
		assertEquals(leftShift, __);
	}

	@Test
	public void aboutBitShiftingRightUnsigned() {
		int rightShiftNegativeStaysNegative = 0x80000000;
		rightShiftNegativeStaysNegative = rightShiftNegativeStaysNegative >> 4;
		assertEquals(rightShiftNegativeStaysNegative, __);
		int unsignedRightShift = 0x80000000; // always fills with 0
		unsignedRightShift >>>= 4; // Just like +=
		assertEquals(unsignedRightShift, __);
	}

	@Test
	public void whenDoesContatenationTransformIntoString() {
		Object first = 1L, second = 1 + 2 + "three", third = "one" + 2 + 3;
		assertEquals(first, __);
		assertEquals(second, __);
		assertEquals(third, __);
	}
}
