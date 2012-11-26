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
		assertEquals(7, array.bigDiff(new int[] { 10, 3, 5, 6 }));
		assertEquals(8, array.bigDiff(new int[] { 7, 2, 10, 9 }));
		assertEquals(8, array.bigDiff(new int[] { 2, 10, 7, 2 }));
		assertEquals(8, array.bigDiff(new int[] { 2, 10 }));
		assertEquals(8, array.bigDiff(new int[] { 10, 2 }));
		assertEquals(10, array.bigDiff(new int[] { 10, 0 }));
		assertEquals(1, array.bigDiff(new int[] { 2, 3 }));
		assertEquals(0, array.bigDiff(new int[] { 2, 2 }));
		assertEquals(0, array.bigDiff(new int[] { 2 }));
		assertEquals(8, array.bigDiff(new int[] { 5, 1, 6, 1, 9, 9 }));
		assertEquals(3, array.bigDiff(new int[] { 7, 6, 8, 5 }));
		assertEquals(3, array.bigDiff(new int[] { 7, 7, 6, 8, 5, 5, 6 }));
	}

	@Test
	public void testCenteredAverage() {
		assertEquals(3, array.centeredAverage(new int[] { 1, 2, 3, 4, 100 }));
		assertEquals(5,
				array.centeredAverage(new int[] { 1, 1, 5, 5, 10, 8, 7 }));
		assertEquals(-3,
				array.centeredAverage(new int[] { -10, -4, -2, -4, -2, 0 }));
		assertEquals(4, array.centeredAverage(new int[] { 5, 3, 4, 6, 2 }));
		assertEquals(4, array.centeredAverage(new int[] { 5, 3, 4, 0, 100 }));
		assertEquals(4, array.centeredAverage(new int[] { 100, 0, 5, 3, 4 }));
		assertEquals(4, array.centeredAverage(new int[] { 4, 0, 100 }));
		assertEquals(3, array.centeredAverage(new int[] { 0, 2, 3, 4, 100 }));
		assertEquals(1, array.centeredAverage(new int[] { 1, 1, 100 }));
		assertEquals(7, array.centeredAverage(new int[] { 7, 7, 7 }));
		assertEquals(7, array.centeredAverage(new int[] { 1, 7, 8 }));
		assertEquals(50, array.centeredAverage(new int[] { 1, 1, 99, 99 }));
		assertEquals(50, array.centeredAverage(new int[] { 1000, 0, 1, 99 }));
		assertEquals(4, array.centeredAverage(new int[] { 4, 4, 4, 4, 5 }));
		assertEquals(4, array.centeredAverage(new int[] { 4, 4, 4, 1, 5 }));
		assertEquals(6, array.centeredAverage(new int[] { 6, 4, 8, 12, 3 }));
	}

	@Test
	public void testSum13() {
		assertEquals(6, array.sum13(new int[] { 1, 2, 2, 1 }));
		assertEquals(2, array.sum13(new int[] { 1, 1 }));
		assertEquals(6, array.sum13(new int[] { 1, 2, 2, 1, 13 }));
		assertEquals(4, array.sum13(new int[] { 1, 2, 13, 2, 1, 13 }));
		assertEquals(3, array.sum13(new int[] { 13, 1, 2, 13, 2, 1, 13 }));
		assertEquals(0, array.sum13(new int[] {}));
		assertEquals(0, array.sum13(new int[] { 13 }));
		assertEquals(0, array.sum13(new int[] { 13, 13 }));
		assertEquals(0, array.sum13(new int[] { 13, 0, 13 }));
		assertEquals(0, array.sum13(new int[] { 13, 1, 13 }));
		assertEquals(14, array.sum13(new int[] { 5, 7, 2 }));
		assertEquals(5, array.sum13(new int[] { 5, 13, 2 }));
		assertEquals(0, array.sum13(new int[] { 0 }));
		assertEquals(0, array.sum13(new int[] { 13, 0 }));
	}

	@Test
	public void testSum67() {
		assertEquals(5, array.sum67(new int[] { 1, 2, 2 }));
		assertEquals(5, array.sum67(new int[] { 1, 2, 2, 6, 99, 99, 7 }));
		assertEquals(4, array.sum67(new int[] { 1, 1, 6, 7, 2 }));
		assertEquals(2,
				array.sum67(new int[] { 1, 6, 2, 2, 7, 1, 6, 99, 99, 7 }));
		assertEquals(2,
				array.sum67(new int[] { 1, 6, 2, 6, 2, 7, 1, 6, 99, 99, 7 }));
		assertEquals(18, array.sum67(new int[] { 2, 7, 6, 2, 6, 7, 2, 7 }));
		assertEquals(9, array.sum67(new int[] { 2, 7, 6, 2, 6, 2, 7 }));
		assertEquals(8, array.sum67(new int[] { 1, 6, 7, 7 }));
		assertEquals(8, array.sum67(new int[] { 6, 7, 1, 6, 7, 7 }));
		assertEquals(0, array.sum67(new int[] { 6, 8, 1, 6, 7 }));
		assertEquals(0, array.sum67(new int[] {}));
		assertEquals(11, array.sum67(new int[] { 6, 7, 11 }));
		assertEquals(22, array.sum67(new int[] { 11, 6, 7, 11 }));
		assertEquals(11, array.sum67(new int[] { 2, 2, 6, 7, 7 }));
	}

	@Test
	public void testHas22() {
		assertTrue(array.has22(new int[] { 1, 2, 2 }));
		assertFalse(array.has22(new int[] { 1, 2, 1, 2 }));
		assertFalse(array.has22(new int[] { 2, 1, 2 }));
		assertTrue(array.has22(new int[] { 2, 2, 1, 2 }));
		assertFalse(array.has22(new int[] { 1, 3, 2 }));
		assertTrue(array.has22(new int[] { 1, 3, 2, 2 }));
		assertTrue(array.has22(new int[] { 2, 3, 2, 2 }));
		assertTrue(array.has22(new int[] { 4, 2, 4, 2, 2, 5 }));
		assertFalse(array.has22(new int[] { 1, 2 }));
		assertTrue(array.has22(new int[] { 2, 2 }));
		assertFalse(array.has22(new int[] { 2 }));
		assertFalse(array.has22(new int[] {}));
		assertTrue(array.has22(new int[] { 3, 3, 2, 2 }));
		assertFalse(array.has22(new int[] { 5, 2, 5, 2 }));
	}

	@Test
	public void testLucky13() {
		assertTrue(array.lucky13(new int[] { 0, 2, 4 }));
		assertFalse(array.lucky13(new int[] { 1, 2, 3 }));
		assertFalse(array.lucky13(new int[] { 1, 2, 4 }));
		assertTrue(array.lucky13(new int[] { 2, 7, 2, 8 }));
		assertFalse(array.lucky13(new int[] { 2, 7, 1, 8 }));
		assertFalse(array.lucky13(new int[] { 3, 7, 2, 8 }));
		assertFalse(array.lucky13(new int[] { 2, 7, 2, 1 }));
		assertFalse(array.lucky13(new int[] { 1, 2 }));
		assertTrue(array.lucky13(new int[] { 2, 2 }));
		assertTrue(array.lucky13(new int[] { 2 }));
		assertFalse(array.lucky13(new int[] { 3 }));
		assertTrue(array.lucky13(new int[] {}));
	}

	@Test
	public void testSum28() {
		assertTrue(array.sum28(new int[] { 2, 3, 2, 2, 4, 2 }));
		assertFalse(array.sum28(new int[] { 2, 3, 2, 2, 4, 2, 2 }));
		assertFalse(array.sum28(new int[] { 1, 2, 3, 4 }));
		assertTrue(array.sum28(new int[] { 2, 2, 2, 2 }));
		assertTrue(array.sum28(new int[] { 1, 2, 2, 2, 2, 4 }));
		assertFalse(array.sum28(new int[] {}));
		assertFalse(array.sum28(new int[] { 2 }));
		assertFalse(array.sum28(new int[] { 8 }));
		assertFalse(array.sum28(new int[] { 2, 2, 2 }));
		assertFalse(array.sum28(new int[] { 2, 2, 2, 2, 2 }));
		assertTrue(array.sum28(new int[] { 1, 2, 2, 1, 2, 2 }));
		assertTrue(array.sum28(new int[] { 5, 2, 2, 2, 4, 2 }));
	}

	@Test
	public void testMore14() {
		assertTrue(array.more14(new int[] { 1, 4, 1 }));
		assertFalse(array.more14(new int[] { 1, 4, 1, 4 }));
		assertTrue(array.more14(new int[] { 1, 1 }));
		assertTrue(array.more14(new int[] { 1, 6, 6 }));
		assertTrue(array.more14(new int[] { 1 }));
		assertFalse(array.more14(new int[] { 1, 4 }));
		assertTrue(array.more14(new int[] { 6, 1, 1 }));
		assertFalse(array.more14(new int[] { 1, 6, 4 }));
		assertTrue(array.more14(new int[] { 1, 1, 4, 4, 1 }));
		assertTrue(array.more14(new int[] { 1, 1, 6, 4, 4, 1 }));
		assertFalse(array.more14(new int[] {}));
		assertFalse(array.more14(new int[] { 4, 1, 4, 6 }));
		assertFalse(array.more14(new int[] { 4, 1, 4, 6, 1 }));
		assertTrue(array.more14(new int[] { 1, 4, 1, 4, 1, 6 }));
	}

	@Test
	public void testOnly14() {
		assertTrue(array.only14(new int[] { 1, 4, 1, 4 }));
		assertFalse(array.only14(new int[] { 1, 4, 2, 4 }));
		assertTrue(array.only14(new int[] { 1, 1 }));
		assertTrue(array.only14(new int[] { 4, 1 }));
		assertFalse(array.only14(new int[] { 2 }));
		assertTrue(array.only14(new int[] {}));
		assertFalse(array.only14(new int[] { 1, 4, 1, 3 }));
		assertFalse(array.only14(new int[] { 3, 1, 3 }));
		assertTrue(array.only14(new int[] { 1 }));
		assertTrue(array.only14(new int[] { 4 }));
		assertFalse(array.only14(new int[] { 3, 4 }));
		assertFalse(array.only14(new int[] { 1, 3, 4 }));
		assertTrue(array.only14(new int[] { 1, 1, 1 }));
		assertFalse(array.only14(new int[] { 1, 1, 1, 5 }));
		assertTrue(array.only14(new int[] { 4, 1, 4, 1 }));
	}

	@Test
	public void testNo14() {
		assertTrue(array.no14(new int[] { 1, 2, 3 }));
		assertFalse(array.no14(new int[] { 1, 2, 3, 4 }));
		assertTrue(array.no14(new int[] { 2, 3, 4 }));
		assertFalse(array.no14(new int[] { 1, 1, 4, 4 }));
		assertTrue(array.no14(new int[] { 2, 2, 4, 4 }));
		assertFalse(array.no14(new int[] { 2, 3, 4, 1 }));
		assertTrue(array.no14(new int[] { 2, 1, 1 }));
		assertFalse(array.no14(new int[] { 1, 4 }));
		assertTrue(array.no14(new int[] { 2 }));
		assertTrue(array.no14(new int[] { 2, 1 }));
		assertTrue(array.no14(new int[] { 1 }));
		assertTrue(array.no14(new int[] { 4 }));
		assertTrue(array.no14(new int[] {}));
		assertTrue(array.no14(new int[] { 1, 1, 1, 1 }));
		assertFalse(array.no14(new int[] { 9, 4, 4, 1 }));
		assertFalse(array.no14(new int[] { 4, 2, 3, 1 }));
		assertTrue(array.no14(new int[] { 4, 2, 3, 5 }));
		assertTrue(array.no14(new int[] { 4, 4, 2 }));
		assertFalse(array.no14(new int[] { 1, 4, 4 }));
	}

	@Test
	public void testIsEverywhere() {
		assertTrue(array.isEverywhere(new int[] { 1, 2, 1, 3 }, 1));
		assertFalse(array.isEverywhere(new int[] { 1, 2, 1, 3 }, 2));
		assertFalse(array.isEverywhere(new int[] { 1, 2, 1, 3, 4 }, 1));
		assertTrue(array.isEverywhere(new int[] { 2, 1, 2, 1 }, 1));
		assertTrue(array.isEverywhere(new int[] { 2, 1, 2, 1 }, 2));
		assertFalse(array.isEverywhere(new int[] { 2, 1, 2, 3, 1 }, 2));
		assertTrue(array.isEverywhere(new int[] { 3, 1 }, 3));
		assertFalse(array.isEverywhere(new int[] { 3, 1 }, 2));
		assertTrue(array.isEverywhere(new int[] { 3 }, 1));
		assertTrue(array.isEverywhere(new int[] {}, 1));
		assertTrue(array.isEverywhere(new int[] { 1, 2, 1, 2, 3, 2, 5 }, 2));
		assertFalse(array.isEverywhere(new int[] { 1, 2, 1, 1, 1, 2 }, 2));
		assertFalse(array.isEverywhere(new int[] { 2, 1, 2, 1, 1, 2 }, 2));
		assertFalse(array.isEverywhere(new int[] { 2, 1, 2, 2, 2, 1, 1, 2 }, 2));
		assertTrue(array.isEverywhere(new int[] { 2, 1, 2, 2, 2, 1, 2, 1 }, 2));
		assertTrue(array.isEverywhere(new int[] { 2, 1, 2, 1, 2 }, 2));
	}

	@Test
	public void testEither24() {
		assertTrue(array.either24(new int[] { 1, 2, 2 }));
		assertTrue(array.either24(new int[] { 4, 4, 1 }));
		assertFalse(array.either24(new int[] { 4, 4, 1, 2, 2 }));
		assertFalse(array.either24(new int[] { 1, 2, 3, 4 }));
		assertFalse(array.either24(new int[] { 3, 5, 9 }));
		assertTrue(array.either24(new int[] { 1, 2, 3, 4, 4 }));
		assertTrue(array.either24(new int[] { 2, 2, 3, 4 }));
		assertTrue(array.either24(new int[] { 1, 2, 3, 2, 2, 4 }));
		assertFalse(array.either24(new int[] { 1, 2, 3, 2, 2, 4, 4 }));
		assertFalse(array.either24(new int[] { 1, 2 }));
		assertTrue(array.either24(new int[] { 2, 2 }));
		assertTrue(array.either24(new int[] { 4, 4 }));
		assertFalse(array.either24(new int[] { 2 }));
		assertFalse(array.either24(new int[] {}));
	}

	@Test
	public void testMatchUp() {
		assertEquals(2,
				array.matchUp(new int[] { 1, 2, 3 }, new int[] { 2, 3, 10 }));
		assertEquals(3,
				array.matchUp(new int[] { 1, 2, 3 }, new int[] { 2, 3, 5 }));
		assertEquals(2,
				array.matchUp(new int[] { 1, 2, 3 }, new int[] { 2, 3, 3 }));
		assertEquals(1, array.matchUp(new int[] { 5, 3 }, new int[] { 5, 5 }));
		assertEquals(2, array.matchUp(new int[] { 5, 3 }, new int[] { 4, 4 }));
		assertEquals(1, array.matchUp(new int[] { 5, 3 }, new int[] { 3, 3 }));
		assertEquals(1, array.matchUp(new int[] { 5, 3 }, new int[] { 2, 2 }));
		assertEquals(1, array.matchUp(new int[] { 5, 3 }, new int[] { 1, 1 }));
		assertEquals(0, array.matchUp(new int[] { 5, 3 }, new int[] { 0, 0 }));
		assertEquals(0, array.matchUp(new int[] { 4 }, new int[] { 4 }));
		assertEquals(1, array.matchUp(new int[] { 4 }, new int[] { 5 }));
	}

	@Test
	public void testHas77() {
		assertTrue(array.has77(new int[] { 1, 7, 7 }));
		assertTrue(array.has77(new int[] { 1, 7, 1, 7 }));
		assertFalse(array.has77(new int[] { 1, 7, 1, 1, 7 }));
		assertTrue(array.has77(new int[] { 7, 7, 1, 1, 7 }));
		assertFalse(array.has77(new int[] { 2, 7, 2, 2, 7, 2 }));
		assertTrue(array.has77(new int[] { 2, 7, 2, 2, 7, 7 }));
		assertTrue(array.has77(new int[] { 7, 2, 7, 2, 2, 7 }));
		assertFalse(array.has77(new int[] { 7, 2, 6, 2, 2, 7 }));
		assertTrue(array.has77(new int[] { 7, 7, 7 }));
		assertTrue(array.has77(new int[] { 7, 1, 7 }));
		assertFalse(array.has77(new int[] { 7, 1, 1 }));
		assertFalse(array.has77(new int[] { 1, 2 }));
		assertFalse(array.has77(new int[] { 1, 7 }));
		assertFalse(array.has77(new int[] { 7 }));
	}

	@Test
	public void testHas12() {
		assertTrue(array.has12(new int[] { 1, 3, 2 }));
		assertTrue(array.has12(new int[] { 3, 1, 2 }));
		assertTrue(array.has12(new int[] { 3, 1, 4, 5, 2 }));
		assertFalse(array.has12(new int[] { 3, 1, 4, 5, 6 }));
		assertTrue(array.has12(new int[] { 3, 1, 4, 1, 6, 2 }));
		assertTrue(array.has12(new int[] { 2, 1, 4, 1, 6, 2 }));
		assertFalse(array.has12(new int[] { 2, 1, 4, 1, 6 }));
		assertFalse(array.has12(new int[] { 3, 5, 9 }));
		assertFalse(array.has12(new int[] { 3, 5, 1 }));
		assertFalse(array.has12(new int[] { 3, 2, 1 }));
		assertTrue(array.has12(new int[] { 1, 2 }));
		assertFalse(array.has12(new int[] { 1, 1 }));
		assertFalse(array.has12(new int[] { 1 }));
		assertFalse(array.has12(new int[] {}));
	}

	@Test
	public void testModThree() {
		assertTrue(array.modThree(new int[] { 2, 1, 3, 5 }));
		assertFalse(array.modThree(new int[] { 2, 1, 2, 5 }));
		assertTrue(array.modThree(new int[] { 2, 4, 2, 5 }));
		assertFalse(array.modThree(new int[] { 1, 2, 1, 2, 1 }));
		assertTrue(array.modThree(new int[] { 9, 9, 9 }));
		assertFalse(array.modThree(new int[] { 1, 2, 1 }));
		assertFalse(array.modThree(new int[] { 1, 2 }));
		assertFalse(array.modThree(new int[] { 1 }));
		assertFalse(array.modThree(new int[] {}));
		assertFalse(array.modThree(new int[] { 9, 7, 2, 9 }));
		assertFalse(array.modThree(new int[] { 9, 7, 2, 9, 2, 2 }));
		assertTrue(array.modThree(new int[] { 9, 7, 2, 9, 2, 2, 6 }));
	}

	@Test
	public void testHaveThree() {
		assertTrue(array.haveThree(new int[] { 3, 1, 3, 1, 3 }));
		assertFalse(array.haveThree(new int[] { 3, 1, 3, 3 }));
		assertFalse(array.haveThree(new int[] { 3, 4, 3, 3, 4 }));
		assertFalse(array.haveThree(new int[] { 1, 3, 1, 3, 1, 2 }));
		assertTrue(array.haveThree(new int[] { 1, 3, 1, 3, 1, 3 }));
		assertFalse(array.haveThree(new int[] { 1, 3, 3, 1, 3 }));
		assertFalse(array.haveThree(new int[] { 1, 3, 1, 3, 1, 3, 4, 3 }));
		assertTrue(array.haveThree(new int[] { 3, 4, 3, 4, 3, 4, 4 }));
		assertFalse(array.haveThree(new int[] { 3, 3, 3 }));
		assertFalse(array.haveThree(new int[] { 1, 3 }));
		assertFalse(array.haveThree(new int[] { 3 }));
		assertFalse(array.haveThree(new int[] { 1 }));
	}

	@Test
	public void testTwoTwo() {
		assertTrue(array.twoTwo(new int[] { 4, 2, 2, 3 }));
		assertTrue(array.twoTwo(new int[] { 2, 2, 4 }));
		assertFalse(array.twoTwo(new int[] { 2, 2, 4, 2 }));
		assertTrue(array.twoTwo(new int[] { 1, 3, 4 }));
		assertTrue(array.twoTwo(new int[] { 1, 2, 2, 3, 4 }));
		assertFalse(array.twoTwo(new int[] { 1, 2, 3, 4 }));
		assertTrue(array.twoTwo(new int[] { 2, 2 }));
		assertTrue(array.twoTwo(new int[] { 2, 2, 7 }));
		assertFalse(array.twoTwo(new int[] { 2, 2, 7, 2, 1 }));
		assertTrue(array.twoTwo(new int[] { 4, 2, 2, 2 }));
		assertTrue(array.twoTwo(new int[] { 2, 2, 2 }));
		assertFalse(array.twoTwo(new int[] { 1, 2 }));
		assertFalse(array.twoTwo(new int[] { 2 }));
		assertTrue(array.twoTwo(new int[] { 1 }));
		assertTrue(array.twoTwo(new int[] {}));
		assertTrue(array.twoTwo(new int[] { 5, 2, 2, 3 }));
		assertFalse(array.twoTwo(new int[] { 2, 2, 5, 2 }));
	}

	@Test
	public void testSameEnds() {
		assertFalse(array.sameEnds(new int[] { 5, 6, 45, 99, 13, 5, 6 }, 1));
		assertTrue(array.sameEnds(new int[] { 5, 6, 45, 99, 13, 5, 6 }, 2));
		assertFalse(array.sameEnds(new int[] { 5, 6, 45, 99, 13, 5, 6 }, 3));
		assertTrue(array.sameEnds(new int[] { 1, 2, 5, 2, 1 }, 1));
		assertFalse(array.sameEnds(new int[] { 1, 2, 5, 2, 1 }, 2));
		assertTrue(array.sameEnds(new int[] { 1, 2, 5, 2, 1 }, 0));
		assertTrue(array.sameEnds(new int[] { 1, 2, 5, 2, 1 }, 5));
		assertTrue(array.sameEnds(new int[] { 1, 1, 1 }, 0));
		assertTrue(array.sameEnds(new int[] { 1, 1, 1 }, 1));
		assertTrue(array.sameEnds(new int[] { 1, 1, 1 }, 2));
		assertTrue(array.sameEnds(new int[] { 1, 1, 1 }, 3));
		assertTrue(array.sameEnds(new int[] { 1 }, 1));
		assertTrue(array.sameEnds(new int[] {}, 0));
		assertFalse(array.sameEnds(new int[] { 4, 2, 4, 5 }, 1));
	}

	@Test
	public void testTripleUp() {
		assertTrue(array.tripleUp(new int[] { 1, 4, 5, 6, 2 }));
		assertTrue(array.tripleUp(new int[] { 1, 2, 3 }));
		assertFalse(array.tripleUp(new int[] { 1, 2, 4 }));
		assertTrue(array.tripleUp(new int[] { 1, 2, 4, 5, 7, 6, 5, 6, 7, 6 }));
		assertFalse(array.tripleUp(new int[] { 1, 2, 4, 5, 7, 6, 5, 7, 7, 6 }));
		assertFalse(array.tripleUp(new int[] { 1, 2 }));
		assertFalse(array.tripleUp(new int[] { 1 }));
		assertFalse(array.tripleUp(new int[] {}));
		assertTrue(array.tripleUp(new int[] { 10, 9, 8, -100, -99, -98, 100 }));
		assertFalse(array.tripleUp(new int[] { 10, 9, 8, -100, -99, 99, 100 }));
		assertTrue(array.tripleUp(new int[] { -100, -99, -99, 100, 101, 102 }));
		assertFalse(array.tripleUp(new int[] { 2, 3, 5, 6, 8, 9, 2, 3 }));
	}

	@Test
	public void testShiftLeft() {
		assertArrayEquals(new int[] { 2, 5, 3, 6 },
				array.shiftLeft(new int[] { 6, 2, 5, 3 }));
		assertArrayEquals(new int[] { 2, 1 },
				array.shiftLeft(new int[] { 1, 2 }));
		assertArrayEquals(new int[] { 1 }, array.shiftLeft(new int[] { 1 }));
		assertArrayEquals(new int[] {}, array.shiftLeft(new int[] {}));
		assertArrayEquals(new int[] { 1, 2, 2, 4, 1 },
				array.shiftLeft(new int[] { 1, 1, 2, 2, 4 }));
		assertArrayEquals(new int[] { 1, 1, 1 },
				array.shiftLeft(new int[] { 1, 1, 1 }));
		assertArrayEquals(new int[] { 2, 3, 1 },
				array.shiftLeft(new int[] { 1, 2, 3 }));
	}

	@Test
	public void testTenRun() {
		assertArrayEquals(new int[] { 2, 10, 10, 10, 20, 20 },
				array.tenRun(new int[] { 2, 10, 3, 4, 20, 5 }));
		assertArrayEquals(new int[] { 10, 10, 20, 20 },
				array.tenRun(new int[] { 10, 1, 20, 2 }));
		assertArrayEquals(new int[] { 10, 10, 10, 20 },
				array.tenRun(new int[] { 10, 1, 9, 20 }));
		assertArrayEquals(new int[] { 1, 2, 50, 50 },
				array.tenRun(new int[] { 1, 2, 50, 1 }));
		assertArrayEquals(new int[] { 1, 20, 50, 50 },
				array.tenRun(new int[] { 1, 20, 50, 1 }));
		assertArrayEquals(new int[] { 10, 10 },
				array.tenRun(new int[] { 10, 10 }));
		assertArrayEquals(new int[] { 10, 10 },
				array.tenRun(new int[] { 10, 2 }));
		assertArrayEquals(new int[] { 0, 0 }, array.tenRun(new int[] { 0, 2 }));
		assertArrayEquals(new int[] { 1, 2 }, array.tenRun(new int[] { 1, 2 }));
		assertArrayEquals(new int[] { 1 }, array.tenRun(new int[] { 1 }));
		assertArrayEquals(new int[] {}, array.tenRun(new int[] {}));
	}

	@Test
	public void testPre4() {
		assertArrayEquals(new int[] { 1, 2 },
				array.pre4(new int[] { 1, 2, 4, 1 }));
		assertArrayEquals(new int[] { 3, 1 }, array.pre4(new int[] { 3, 1, 4 }));
		assertArrayEquals(new int[] { 1 }, array.pre4(new int[] { 1, 4, 4 }));
		assertArrayEquals(new int[] { 1 }, array.pre4(new int[] { 1, 4, 4, 2 }));
		assertArrayEquals(new int[] { 1, 3 },
				array.pre4(new int[] { 1, 3, 4, 2, 4 }));
		assertArrayEquals(new int[] {}, array.pre4(new int[] { 4, 4 }));
		assertArrayEquals(new int[] { 3, 3 }, array.pre4(new int[] { 3, 3, 4 }));
		assertArrayEquals(new int[] { 1, 2, 1 },
				array.pre4(new int[] { 1, 2, 1, 4 }));
		assertArrayEquals(new int[] { 2, 1 },
				array.pre4(new int[] { 2, 1, 4, 2 }));
		assertArrayEquals(new int[] { 2, 1, 2, 1 },
				array.pre4(new int[] { 2, 1, 2, 1, 4, 2 }));
	}

	@Test
	public void testPost4() {
		assertArrayEquals(new int[] { 1, 2 },
				array.post4(new int[] { 2, 4, 1, 2 }));
		assertArrayEquals(new int[] { 2 },
				array.post4(new int[] { 4, 1, 4, 2 }));
		assertArrayEquals(new int[] { 1, 2, 3 },
				array.post4(new int[] { 4, 4, 1, 2, 3 }));
		assertArrayEquals(new int[] { 2 }, array.post4(new int[] { 4, 2 }));
		assertArrayEquals(new int[] { 3 }, array.post4(new int[] { 4, 4, 3 }));
		assertArrayEquals(new int[] {}, array.post4(new int[] { 4, 4 }));
		assertArrayEquals(new int[] {}, array.post4(new int[] { 4 }));
		assertArrayEquals(new int[] { 3, 2 },
				array.post4(new int[] { 2, 4, 1, 4, 3, 2 }));
		assertArrayEquals(new int[] { 2, 2, 2 },
				array.post4(new int[] { 4, 1, 4, 2, 2, 2 }));
		assertArrayEquals(new int[] { 3, 2 },
				array.post4(new int[] { 3, 4, 3, 2 }));
	}

	@Test
	public void testNotAlone() {
		assertArrayEquals(new int[] { 1, 3, 3 },
				array.notAlone(new int[] { 1, 2, 3 }, 2));
		assertArrayEquals(new int[] { 1, 3, 3, 5, 5, 2 },
				array.notAlone(new int[] { 1, 2, 3, 2, 5, 2 }, 2));
		assertArrayEquals(new int[] { 3, 4 },
				array.notAlone(new int[] { 3, 4 }, 3));
		assertArrayEquals(new int[] { 3, 3 },
				array.notAlone(new int[] { 3, 3 }, 3));
		assertArrayEquals(new int[] { 1, 3, 3, 2 },
				array.notAlone(new int[] { 1, 3, 1, 2 }, 1));
		assertArrayEquals(new int[] { 3 }, array.notAlone(new int[] { 3 }, 3));
		assertArrayEquals(new int[] {}, array.notAlone(new int[] {}, 3));
		assertArrayEquals(new int[] { 7, 7, 6 },
				array.notAlone(new int[] { 7, 1, 6 }, 1));
		assertArrayEquals(new int[] { 1, 1, 1 },
				array.notAlone(new int[] { 1, 1, 1 }, 1));
		assertArrayEquals(new int[] { 1, 1, 1, 2 },
				array.notAlone(new int[] { 1, 1, 1, 2 }, 1));
	}

	@Test
	public void testZeroFront() {
		assertArrayEquals(new int[] { 0, 0, 1, 1 },
				array.zeroFront(new int[] { 1, 0, 0, 1 }));
		assertArrayEquals(new int[] { 0, 0, 1, 1, 1 },
				array.zeroFront(new int[] { 0, 1, 1, 0, 1 }));
		assertArrayEquals(new int[] { 0, 1 },
				array.zeroFront(new int[] { 1, 0 }));
		assertArrayEquals(new int[] { 0, 1 },
				array.zeroFront(new int[] { 0, 1 }));
		assertArrayEquals(new int[] { 0, 1, 1, 1 },
				array.zeroFront(new int[] { 1, 1, 1, 0 }));
		assertArrayEquals(new int[] { 2, 2, 2, 2 },
				array.zeroFront(new int[] { 2, 2, 2, 2 }));
		assertArrayEquals(new int[] { 0, 0, 0, 1 },
				array.zeroFront(new int[] { 0, 0, 1, 0 }));
		assertArrayEquals(new int[] { 0, 0, 0, -1, -1 },
				array.zeroFront(new int[] { -1, 0, 0, -1, 0 }));
		assertArrayEquals(new int[] { 0, 0, -3, -3 },
				array.zeroFront(new int[] { 0, -3, 0, -3 }));
		assertArrayEquals(new int[] {}, array.zeroFront(new int[] {}));
		assertArrayEquals(new int[] { 0, 0, 9, 9, 9, 9 },
				array.zeroFront(new int[] { 9, 9, 0, 9, 0, 9 }));
	}

	@Test
	public void testWithoutTen() {
		assertArrayEquals(new int[] { 1, 2, 0, 0 },
				array.withoutTen(new int[] { 1, 10, 10, 2 }));
		assertArrayEquals(new int[] { 2, 0, 0 },
				array.withoutTen(new int[] { 10, 2, 10 }));
		assertArrayEquals(new int[] { 1, 99, 0 },
				array.withoutTen(new int[] { 1, 99, 10 }));
		assertArrayEquals(new int[] { 13, 14, 0, 0 },
				array.withoutTen(new int[] { 10, 13, 10, 14 }));
		assertArrayEquals(new int[] { 13, 14, 0, 0, 0 },
				array.withoutTen(new int[] { 10, 13, 10, 14, 10 }));
		assertArrayEquals(new int[] { 3, 0, 0 },
				array.withoutTen(new int[] { 10, 10, 3 }));
		assertArrayEquals(new int[] { 1 }, array.withoutTen(new int[] { 1 }));
		assertArrayEquals(new int[] { 13, 1 },
				array.withoutTen(new int[] { 13, 1 }));
		assertArrayEquals(new int[] { 0 }, array.withoutTen(new int[] { 10 }));
		assertArrayEquals(new int[] {}, array.withoutTen(new int[] {}));
	}

	@Test
	public void testZeroMax() {
		assertArrayEquals(new int[] { 5, 5, 3, 3 },
				array.zeroMax(new int[] { 0, 5, 0, 3 }));
		assertArrayEquals(new int[] { 3, 4, 3, 3 },
				array.zeroMax(new int[] { 0, 4, 0, 3 }));
		assertArrayEquals(new int[] { 1, 1, 0 },
				array.zeroMax(new int[] { 0, 1, 0 }));
		assertArrayEquals(new int[] { 5, 1, 5 },
				array.zeroMax(new int[] { 0, 1, 5 }));
		assertArrayEquals(new int[] { 0, 2, 0 },
				array.zeroMax(new int[] { 0, 2, 0 }));
		assertArrayEquals(new int[] { 1 }, array.zeroMax(new int[] { 1 }));
		assertArrayEquals(new int[] { 0 }, array.zeroMax(new int[] { 0 }));
		assertArrayEquals(new int[] {}, array.zeroMax(new int[] {}));
		assertArrayEquals(new int[] { 7, 3, 4, 3, 0, 2 },
				array.zeroMax(new int[] { 7, 0, 4, 3, 0, 2 }));
		assertArrayEquals(new int[] { 7, 3, 4, 3, 1, 1 },
				array.zeroMax(new int[] { 7, 0, 4, 3, 0, 1 }));
		assertArrayEquals(new int[] { 7, 3, 4, 3, 0, 0 },
				array.zeroMax(new int[] { 7, 0, 4, 3, 0, 0 }));
		assertArrayEquals(new int[] { 7, 7, 1, 7, 7, 7 },
				array.zeroMax(new int[] { 7, 0, 1, 0, 0, 7 }));
	}

	@Test
	public void testEvenOdd() {
		assertArrayEquals(new int[] { 0, 0, 0, 1, 1, 1, 1 },
				array.evenOdd(new int[] { 1, 0, 1, 0, 0, 1, 1 }));
		assertArrayEquals(new int[] { 2, 3, 3 },
				array.evenOdd(new int[] { 3, 3, 2 }));
		assertArrayEquals(new int[] { 2, 2, 2 },
				array.evenOdd(new int[] { 2, 2, 2 }));
		assertArrayEquals(new int[] { 2, 2, 3 },
				array.evenOdd(new int[] { 3, 2, 2 }));
		assertArrayEquals(new int[] { 0, 0, 1, 1, 1 },
				array.evenOdd(new int[] { 1, 1, 0, 1, 0 }));
		assertArrayEquals(new int[] { 1 }, array.evenOdd(new int[] { 1 }));
		assertArrayEquals(new int[] { 2, 1 }, array.evenOdd(new int[] { 1, 2 }));
		assertArrayEquals(new int[] { 2, 1 }, array.evenOdd(new int[] { 2, 1 }));
		assertArrayEquals(new int[] {}, array.evenOdd(new int[] {}));
	}

	@Before
	public void setUp() {
		array = new Array2();
	}
}
