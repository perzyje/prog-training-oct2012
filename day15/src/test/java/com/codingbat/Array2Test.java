package com.codingbat;

import org.junit.*;
import static org.junit.Assert.*;

public final class Array2Test {
	private Array2 array;

	@Test
	public void testCountEvens() {
		assertEquals(3, array.countEvens(new int[] { 2, 1, 2, 3, 4 }));
		assertEquals(3, array.countEvens(new int[] { 2, 2, 0 }));
		assertEquals(0, array.countEvens(new int[] { 1, 3, 5 }));
		assertEquals(0, array.countEvens(new int[] {}));
		assertEquals(1, array.countEvens(new int[] { 11, 9, 0, 1 }));
		assertEquals(2, array.countEvens(new int[] { 2, 11, 9, 0 }));
		assertEquals(1, array.countEvens(new int[] { 2 }));
		assertEquals(2, array.countEvens(new int[] { 2, 5, 12 }));
	}

	@Test
	public void testBigDiff() {
	assertEquals(7, array.bigDiff(new int[] {10, 3, 5, 6}));
	assertEquals(8, array.bigDiff(new int[] {7, 2, 10, 9}));
	assertEquals(8, array.bigDiff(new int[] {2, 10, 7, 2}));
	assertEquals(8, array.bigDiff(new int[] {2, 10}));
	assertEquals(8, array.bigDiff(new int[] {10, 2}));
	assertEquals(10, array.bigDiff(new int[] {10, 0}));
	assertEquals(1, array.bigDiff(new int[] {2, 3}));
	assertEquals(0, array.bigDiff(new int[] {2, 2}));
	assertEquals(0, array.bigDiff(new int[] {2}));
	assertEquals(8, array.bigDiff(new int[] {5, 1, 6, 1, 9, 9}));
	assertEquals(3, array.bigDiff(new int[] {7, 6, 8, 5}));
	assertEquals(3, array.bigDiff(new int[] {7, 7, 6, 8, 5, 5, 6}));
	}

	@Before
	public void setUp() {
		array = new Array2();
	}
}
