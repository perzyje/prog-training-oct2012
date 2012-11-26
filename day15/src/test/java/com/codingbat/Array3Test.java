package com.codingbat;

import org.junit.*;
import static org.junit.Assert.*;

public final class Array3Test {
	private Array3 array;

	@Test
	public void testMaxSpan() {
		assertEquals(4, array.maxSpan(new int[] { 1, 2, 1, 1, 3 }));
		assertEquals(6, array.maxSpan(new int[] { 1, 4, 2, 1, 4, 1, 4 }));
		assertEquals(6, array.maxSpan(new int[] { 1, 4, 2, 1, 4, 4, 4 }));
		assertEquals(3, array.maxSpan(new int[] { 3, 3, 3 }));
		assertEquals(3, array.maxSpan(new int[] { 3, 9, 3 }));
		assertEquals(2, array.maxSpan(new int[] { 3, 9, 9 }));
		assertEquals(1, array.maxSpan(new int[] { 3, 9 }));
		assertEquals(2, array.maxSpan(new int[] { 3, 3 }));
		assertEquals(0, array.maxSpan(new int[] {}));
		assertEquals(1, array.maxSpan(new int[] { 1 }));
	}

	@Test
	public void testFix34() {
		assertArrayEquals(new int[] { 1, 3, 4, 1 },
				array.fix34(new int[] { 1, 3, 1, 4 }));
		assertArrayEquals(new int[] { 1, 3, 4, 1, 1, 3, 4 },
				array.fix34(new int[] { 1, 3, 1, 4, 4, 3, 1 }));
		assertArrayEquals(new int[] { 3, 4, 2, 2 },
				array.fix34(new int[] { 3, 2, 2, 4 }));
		assertArrayEquals(new int[] { 3, 4, 3, 4, 2, 2 },
				array.fix34(new int[] { 3, 2, 3, 2, 4, 4 }));
		assertArrayEquals(new int[] { 2, 3, 4, 3, 4, 2, 2 },
				array.fix34(new int[] { 2, 3, 2, 3, 2, 4, 4 }));
		assertArrayEquals(new int[] { 3, 4, 1 },
				array.fix34(new int[] { 3, 1, 4 }));
		assertArrayEquals(new int[] { 3, 4, 1 },
				array.fix34(new int[] { 3, 4, 1 }));
		assertArrayEquals(new int[] { 1, 1, 1 },
				array.fix34(new int[] { 1, 1, 1 }));
		assertArrayEquals(new int[] { 1 }, array.fix34(new int[] { 1 }));
		assertArrayEquals(new int[] {}, array.fix34(new int[] {}));
		assertArrayEquals(new int[] { 7, 3, 4, 7, 7 },
				array.fix34(new int[] { 7, 3, 7, 7, 4 }));
		assertArrayEquals(new int[] { 3, 4, 1, 3, 4, 1 },
				array.fix34(new int[] { 3, 1, 4, 3, 1, 4 }));
		assertArrayEquals(new int[] { 3, 4, 1, 3, 4, 1 },
				array.fix34(new int[] { 3, 1, 1, 3, 4, 4 }));
	}

	@Test
	public void testFix45() {
		assertArrayEquals(new int[] { 9, 4, 5, 4, 5, 9 },
				array.fix45(new int[] { 5, 4, 9, 4, 9, 5 }));
		assertArrayEquals(new int[] { 1, 4, 5, 1 },
				array.fix45(new int[] { 1, 4, 1, 5 }));
		assertArrayEquals(new int[] { 1, 4, 5, 1, 1, 4, 5 },
				array.fix45(new int[] { 1, 4, 1, 5, 5, 4, 1 }));
		assertArrayEquals(new int[] { 4, 5, 4, 5, 9, 9, 4, 5, 9 },
				array.fix45(new int[] { 4, 9, 4, 9, 5, 5, 4, 9, 5 }));
		assertArrayEquals(new int[] { 1, 1, 4, 5, 4, 5 },
				array.fix45(new int[] { 5, 5, 4, 1, 4, 1 }));
		assertArrayEquals(new int[] { 4, 5, 2, 2 },
				array.fix45(new int[] { 4, 2, 2, 5 }));
		assertArrayEquals(new int[] { 4, 5, 4, 5, 2, 2 },
				array.fix45(new int[] { 4, 2, 4, 2, 5, 5 }));
		assertArrayEquals(new int[] { 4, 5, 4, 5, 2 },
				array.fix45(new int[] { 4, 2, 4, 5, 5 }));
		assertArrayEquals(new int[] { 1, 1, 1 },
				array.fix45(new int[] { 1, 1, 1 }));
		assertArrayEquals(new int[] { 4, 5 }, array.fix45(new int[] { 4, 5 }));
		assertArrayEquals(new int[] { 1, 4, 5 },
				array.fix45(new int[] { 5, 4, 1 }));
		assertArrayEquals(new int[] {}, array.fix45(new int[] {}));
		assertArrayEquals(new int[] { 1, 4, 5, 4, 5 },
				array.fix45(new int[] { 5, 4, 5, 4, 1 }));
		assertArrayEquals(new int[] { 4, 5, 4, 5, 1 },
				array.fix45(new int[] { 4, 5, 4, 1, 5 }));
		assertArrayEquals(new int[] { 3, 4, 5 },
				array.fix45(new int[] { 3, 4, 5 }));
		assertArrayEquals(new int[] { 4, 5, 1 },
				array.fix45(new int[] { 4, 1, 5 }));
		assertArrayEquals(new int[] { 1, 4, 5 },
				array.fix45(new int[] { 5, 4, 1 }));
		assertArrayEquals(new int[] { 2, 4, 5, 2 },
				array.fix45(new int[] { 2, 4, 2, 5 }));
	}

	@Test
	public void testCanBalance() {
		assertTrue(array.canBalance(new int[] { 1, 1, 1, 2, 1 }));
		assertFalse(array.canBalance(new int[] { 2, 1, 1, 2, 1 }));
		assertTrue(array.canBalance(new int[] { 10, 10 }));
		assertTrue(array.canBalance(new int[] { 10, 0, 1, -1, 10 }));
		assertTrue(array.canBalance(new int[] { 1, 1, 1, 1, 4 }));
		assertFalse(array.canBalance(new int[] { 2, 1, 1, 1, 4 }));
		assertFalse(array.canBalance(new int[] { 2, 3, 4, 1, 2 }));
		assertTrue(array.canBalance(new int[] { 1, 2, 3, 1, 0, 2, 3 }));
		assertFalse(array.canBalance(new int[] { 1, 2, 3, 1, 0, 1, 3 }));
		assertFalse(array.canBalance(new int[] { 1 }));
		assertTrue(array.canBalance(new int[] { 1, 1, 1, 2, 1 }));
	}

	@Test
	public void testLinearIn() {
		assertTrue(array.linearIn(new int[] { 1, 2, 4, 6 }, new int[] { 2, 4 }));
		assertFalse(array.linearIn(new int[] { 1, 2, 4, 6 }, new int[] { 2, 3,
				4 }));
		assertTrue(array.linearIn(new int[] { 1, 2, 4, 4, 6 },
				new int[] { 2, 4 }));
		assertTrue(array.linearIn(new int[] { 2, 2, 4, 4, 6, 6 }, new int[] {
				2, 4 }));
		assertTrue(array.linearIn(new int[] { 2, 2, 2, 2, 2 },
				new int[] { 2, 2 }));
		assertFalse(array.linearIn(new int[] { 2, 2, 2, 2, 2 }, new int[] { 2,
				4 }));
		assertTrue(array.linearIn(new int[] { 2, 2, 2, 2, 4 },
				new int[] { 2, 4 }));
		assertTrue(array.linearIn(new int[] { 1, 2, 3 }, new int[] { 2 }));
		assertFalse(array.linearIn(new int[] { 1, 2, 3 }, new int[] { -1 }));
		assertTrue(array.linearIn(new int[] { 1, 2, 3 }, new int[] {}));
		assertTrue(array.linearIn(new int[] { -1, 0, 3, 3, 3, 10, 12 },
				new int[] { -1, 0, 3, 12 }));
		assertFalse(array.linearIn(new int[] { -1, 0, 3, 3, 3, 10, 12 },
				new int[] { 0, 3, 12, 14 }));
		assertFalse(array.linearIn(new int[] { -1, 0, 3, 3, 3, 10, 12 },
				new int[] { -1, 10, 11 }));
	}

	@Test
	public void testSquareUp() {
		assertArrayEquals(new int[] { 0, 0, 1, 0, 2, 1, 3, 2, 1 },
				array.squareUp(3));
		assertArrayEquals(new int[] { 0, 1, 2, 1 }, array.squareUp(2));
		assertArrayEquals(new int[] { 0, 0, 0, 1, 0, 0, 2, 1, 0, 3, 2, 1, 4, 3,
				2, 1 }, array.squareUp(4));
		assertArrayEquals(new int[] { 1 }, array.squareUp(1));
		assertArrayEquals(new int[] {}, array.squareUp(0));
		assertArrayEquals(new int[] { 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 2, 1, 0, 0,
				0, 3, 2, 1, 0, 0, 4, 3, 2, 1, 0, 5, 4, 3, 2, 1, 6, 5, 4, 3, 2,
				1 }, array.squareUp(6));
	}

	@Test
	public void testSeriesUp() {
		assertArrayEquals(new int[] { 1, 1, 2, 1, 2, 3 }, array.seriesUp(3));
		assertArrayEquals(new int[] { 1, 1, 2, 1, 2, 3, 1, 2, 3, 4 },
				array.seriesUp(4));
		assertArrayEquals(new int[] { 1, 1, 2 }, array.seriesUp(2));
		assertArrayEquals(new int[] { 1 }, array.seriesUp(1));
		assertArrayEquals(new int[] {}, array.seriesUp(0));
		assertArrayEquals(new int[] { 1, 1, 2, 1, 2, 3, 1, 2, 3, 4, 1, 2, 3, 4,
				5, 1, 2, 3, 4, 5, 6 }, array.seriesUp(6));
	}

	@Test
	public void testCountClumps() {
		assertEquals(2, array.countClumps(new int[] { 1, 2, 2, 3, 4, 4 }));
		assertEquals(2, array.countClumps(new int[] { 1, 1, 2, 1, 1 }));
		assertEquals(1, array.countClumps(new int[] { 1, 1, 1, 1, 1 }));
		assertEquals(0, array.countClumps(new int[] { 1, 2, 3 }));
		assertEquals(4,
				array.countClumps(new int[] { 2, 2, 1, 1, 1, 2, 1, 1, 2, 2 }));
		assertEquals(4, array.countClumps(new int[] { 0, 2, 2, 1, 1, 1, 2, 1,
				1, 2, 2 }));
		assertEquals(
				5,
				array.countClumps(new int[] { 0, 0, 2, 2, 1, 1, 1, 2, 1, 1, 2,
						2 }));
		assertEquals(
				5,
				array.countClumps(new int[] { 0, 0, 0, 2, 2, 1, 1, 1, 2, 1, 1,
						2, 2 }));
		assertEquals(0, array.countClumps(new int[] {}));
	}

	@Before
	public void setUp() {
		array = new Array3();
	}

	@Test
	public void testMaxMirror() {
		assertEquals(3, array.maxMirror(new int[] { 1, 2, 3, 8, 9, 3, 2, 1 }));
		assertEquals(3, array.maxMirror(new int[] { 1, 2, 1, 4 }));
		assertEquals(2, array.maxMirror(new int[] { 7, 1, 2, 9, 7, 2, 1 }));
		assertEquals(
				4,
				array.maxMirror(new int[] { 21, 22, 9, 8, 7, 6, 23, 24, 6, 7,
						8, 9, 25, 7, 8, 9 }));
		assertEquals(
				4,
				array.maxMirror(new int[] { 1, 2, 1, 20, 21, 1, 2, 1, 2, 23,
						24, 2, 1, 2, 1, 25 }));
		assertEquals(5, array.maxMirror(new int[] { 1, 2, 3, 2, 1 }));
		assertEquals(2, array.maxMirror(new int[] { 1, 2, 3, 3, 8 }));
		assertEquals(2, array.maxMirror(new int[] { 1, 2, 7, 8, 1, 7, 2 }));
		assertEquals(3, array.maxMirror(new int[] { 1, 1, 1 }));
		assertEquals(1, array.maxMirror(new int[] { 1 }));
		assertEquals(0, array.maxMirror(new int[] {}));
		assertEquals(3, array.maxMirror(new int[] { 9, 1, 1, 4, 2, 1, 1, 1 }));
		assertEquals(7,
				array.maxMirror(new int[] { 5, 9, 9, 4, 5, 4, 9, 9, 2 }));
		assertEquals(2,
				array.maxMirror(new int[] { 5, 9, 9, 6, 5, 4, 9, 9, 2 }));
		assertEquals(3,
				array.maxMirror(new int[] { 5, 9, 1, 6, 5, 4, 1, 9, 5 }));
	}

}
