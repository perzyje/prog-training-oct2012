package com.codingbat;

import org.junit.*;
import static org.junit.Assert.*;

public final class Array1Test {
	private Array1 array;

	@Test
	public void testFirstLast6() {
		assertTrue(array.firstLast6(new int[] { 1, 2, 6 }));
		assertTrue(array.firstLast6(new int[] { 6, 1, 2, 3 }));
		assertFalse(array.firstLast6(new int[] { 13, 6, 1, 2, 3 }));
		assertTrue(array.firstLast6(new int[] { 13, 6, 1, 2, 6 }));
		assertFalse(array.firstLast6(new int[] { 3, 2, 1 }));
		assertFalse(array.firstLast6(new int[] { 3, 6, 1 }));
		assertTrue(array.firstLast6(new int[] { 3, 6 }));
		assertTrue(array.firstLast6(new int[] { 6 }));
		assertFalse(array.firstLast6(new int[] { 3 }));
		assertTrue(array.firstLast6(new int[] { 5, 6 }));
		assertFalse(array.firstLast6(new int[] { 5, 5 }));
		assertTrue(array.firstLast6(new int[] { 1, 2, 3, 4, 6 }));
		assertFalse(array.firstLast6(new int[] { 1, 2, 3, 4 }));
	}

	@Test
	public void testSameFirstLast() {
		assertFalse(array.sameFirstLast(new int[] { 1, 2, 3 }));
		assertTrue(array.sameFirstLast(new int[] { 1, 2, 3, 1 }));
		assertTrue(array.sameFirstLast(new int[] { 1, 2, 1 }));
		assertTrue(array.sameFirstLast(new int[] { 7 }));
		assertFalse(array.sameFirstLast(new int[] {}));
		assertTrue(array.sameFirstLast(new int[] { 1, 2, 3, 4, 5, 1 }));
		assertFalse(array.sameFirstLast(new int[] { 1, 2, 3, 4, 5, 13 }));
		assertTrue(array.sameFirstLast(new int[] { 13, 2, 3, 4, 5, 13 }));
		assertTrue(array.sameFirstLast(new int[] { 7, 7 }));
	}

	@Test
	public void testCommonEnd() {
		assertTrue(array.commonEnd(new int[] { 1, 2, 3 }, new int[] { 7, 3 }));
		assertFalse(array.commonEnd(new int[] { 1, 2, 3 },
				new int[] { 7, 3, 2 }));
		assertTrue(array.commonEnd(new int[] { 1, 2, 3 }, new int[] { 1, 3 }));
		assertTrue(array.commonEnd(new int[] { 1, 2, 3 }, new int[] { 1 }));
		assertFalse(array.commonEnd(new int[] { 1, 2, 3 }, new int[] { 2 }));
	}

	@Test
	public void testMakePi() {
		assertArrayEquals(new int[] { 3, 1, 4 }, array.makePi());
	}

	@Test
	public void testSum3() {
		assertEquals(6, array.sum3(new int[] { 1, 2, 3 }));
		assertEquals(18, array.sum3(new int[] { 5, 11, 2 }));
		assertEquals(7, array.sum3(new int[] { 7, 0, 0 }));
		assertEquals(4, array.sum3(new int[] { 1, 2, 1 }));
		assertEquals(3, array.sum3(new int[] { 1, 1, 1 }));
		assertEquals(11, array.sum3(new int[] { 2, 7, 2 }));
	}

	@Test
	public void testRotateLeft3() {
		assertArrayEquals(new int[] { 2, 3, 1 },
				array.rotateLeft3(new int[] { 1, 2, 3 }));
		assertArrayEquals(new int[] { 11, 9, 5 },
				array.rotateLeft3(new int[] { 5, 11, 9 }));
		assertArrayEquals(new int[] { 0, 0, 7 },
				array.rotateLeft3(new int[] { 7, 0, 0 }));
		assertArrayEquals(new int[] { 2, 1, 1 },
				array.rotateLeft3(new int[] { 1, 2, 1 }));
		assertArrayEquals(new int[] { 0, 1, 0 },
				array.rotateLeft3(new int[] { 0, 0, 1 }));
	}

	@Test
	public void testReverse3() {
		assertArrayEquals(new int[] { 3, 2, 1 },
				array.reverse3(new int[] { 1, 2, 3 }));
		assertArrayEquals(new int[] { 9, 11, 5 },
				array.reverse3(new int[] { 5, 11, 9 }));
		assertArrayEquals(new int[] { 0, 0, 7 },
				array.reverse3(new int[] { 7, 0, 0 }));
		assertArrayEquals(new int[] { 2, 1, 2 },
				array.reverse3(new int[] { 2, 1, 2 }));
		assertArrayEquals(new int[] { 1, 2, 1 },
				array.reverse3(new int[] { 1, 2, 1 }));
		assertArrayEquals(new int[] { 3, 11, 2 },
				array.reverse3(new int[] { 2, 11, 3 }));
		assertArrayEquals(new int[] { 5, 6, 0 },
				array.reverse3(new int[] { 0, 6, 5 }));
		assertArrayEquals(new int[] { 3, 2, 7 },
				array.reverse3(new int[] { 7, 2, 3 }));
	}

	@Test
	public void testMaxEnd3() {
		assertArrayEquals(new int[] { 3, 3, 3 },
				array.maxEnd3(new int[] { 1, 2, 3 }));
		assertArrayEquals(new int[] { 11, 11, 11 },
				array.maxEnd3(new int[] { 11, 5, 9 }));
		assertArrayEquals(new int[] { 3, 3, 3 },
				array.maxEnd3(new int[] { 2, 11, 3 }));
		assertArrayEquals(new int[] { 11, 11, 11 },
				array.maxEnd3(new int[] { 11, 3, 3 }));
		assertArrayEquals(new int[] { 11, 11, 11 },
				array.maxEnd3(new int[] { 3, 11, 11 }));
		assertArrayEquals(new int[] { 2, 2, 2 },
				array.maxEnd3(new int[] { 2, 2, 2 }));
		assertArrayEquals(new int[] { 2, 2, 2 },
				array.maxEnd3(new int[] { 2, 11, 2 }));
		assertArrayEquals(new int[] { 1, 1, 1 },
				array.maxEnd3(new int[] { 0, 0, 1 }));
	}

	@Test
	public void testSum2() {
		assertEquals(3, array.sum2(new int[] { 1, 2, 3 }));
		assertEquals(2, array.sum2(new int[] { 1, 1 }));
		assertEquals(2, array.sum2(new int[] { 1, 1, 1, 1 }));
		assertEquals(3, array.sum2(new int[] { 1, 2 }));
		assertEquals(1, array.sum2(new int[] { 1 }));
		assertEquals(0, array.sum2(new int[] {}));
		assertEquals(9, array.sum2(new int[] { 4, 5, 6 }));
		assertEquals(4, array.sum2(new int[] { 4 }));
	}

	@Test
	public void testMiddleWay() {
		assertArrayEquals(new int[] { 2, 5 },
				array.middleWay(new int[] { 1, 2, 3 }, new int[] { 4, 5, 6 }));
		assertArrayEquals(new int[] { 7, 8 },
				array.middleWay(new int[] { 7, 7, 7 }, new int[] { 3, 8, 0 }));
		assertArrayEquals(new int[] { 2, 4 },
				array.middleWay(new int[] { 5, 2, 9 }, new int[] { 1, 4, 5 }));
		assertArrayEquals(new int[] { 9, 8 },
				array.middleWay(new int[] { 1, 9, 7 }, new int[] { 4, 8, 8 }));
		assertArrayEquals(new int[] { 2, 1 },
				array.middleWay(new int[] { 1, 2, 3 }, new int[] { 3, 1, 4 }));
		assertArrayEquals(new int[] { 2, 1 },
				array.middleWay(new int[] { 1, 2, 3 }, new int[] { 4, 1, 1 }));
	}

	@Test
	public void testMakeEnds() {
		assertArrayEquals(new int[] { 1, 3 },
				array.makeEnds(new int[] { 1, 2, 3 }));
		assertArrayEquals(new int[] { 1, 4 },
				array.makeEnds(new int[] { 1, 2, 3, 4 }));
		assertArrayEquals(new int[] { 7, 2 },
				array.makeEnds(new int[] { 7, 4, 6, 2 }));
		assertArrayEquals(new int[] { 1, 3 },
				array.makeEnds(new int[] { 1, 2, 2, 2, 2, 2, 2, 3 }));
		assertArrayEquals(new int[] { 7, 4 },
				array.makeEnds(new int[] { 7, 4 }));
		assertArrayEquals(new int[] { 7, 7 }, array.makeEnds(new int[] { 7 }));
		assertArrayEquals(new int[] { 5, 9 },
				array.makeEnds(new int[] { 5, 2, 9 }));
		assertArrayEquals(new int[] { 2, 1 },
				array.makeEnds(new int[] { 2, 3, 4, 1 }));
	}

	@Test
	public void testHas23() {
		assertTrue(array.has23(new int[] { 2, 5 }));
		assertTrue(array.has23(new int[] { 4, 3 }));
		assertFalse(array.has23(new int[] { 4, 5 }));
		assertTrue(array.has23(new int[] { 2, 2 }));
		assertTrue(array.has23(new int[] { 3, 2 }));
		assertTrue(array.has23(new int[] { 3, 3 }));
		assertFalse(array.has23(new int[] { 7, 7 }));
		assertTrue(array.has23(new int[] { 3, 9 }));
		assertFalse(array.has23(new int[] { 9, 5 }));
	}

	@Test
	public void testNo23() {
		assertTrue(array.no23(new int[] { 4, 5 }));
		assertFalse(array.no23(new int[] { 4, 2 }));
		assertFalse(array.no23(new int[] { 3, 5 }));
		assertTrue(array.no23(new int[] { 1, 9 }));
		assertFalse(array.no23(new int[] { 2, 9 }));
		assertFalse(array.no23(new int[] { 1, 3 }));
		assertTrue(array.no23(new int[] { 1, 1 }));
		assertFalse(array.no23(new int[] { 2, 2 }));
		assertFalse(array.no23(new int[] { 3, 3 }));
		assertTrue(array.no23(new int[] { 7, 8 }));
		assertTrue(array.no23(new int[] { 8, 7 }));
	}

	@Test
	public void testMakeLast() {
		assertArrayEquals(new int[] { 0, 0, 0, 0, 0, 6 },
				array.makeLast(new int[] { 4, 5, 6 }));
		assertArrayEquals(new int[] { 0, 0, 0, 2 },
				array.makeLast(new int[] { 1, 2 }));
		assertArrayEquals(new int[] { 0, 3 }, array.makeLast(new int[] { 3 }));
		assertArrayEquals(new int[] { 0, 0 }, array.makeLast(new int[] { 0 }));
		assertArrayEquals(new int[] { 0, 0, 0, 0, 0, 7 },
				array.makeLast(new int[] { 7, 7, 7 }));
		assertArrayEquals(new int[] { 0, 0, 0, 0, 0, 4 },
				array.makeLast(new int[] { 3, 1, 4 }));
		assertArrayEquals(new int[] { 0, 0, 0, 0, 0, 0, 0, 4 },
				array.makeLast(new int[] { 1, 2, 3, 4 }));
		assertArrayEquals(new int[] { 0, 0, 0, 0, 0, 0, 0, 0 },
				array.makeLast(new int[] { 1, 2, 3, 0 }));
		assertArrayEquals(new int[] { 0, 0, 0, 4 },
				array.makeLast(new int[] { 2, 4 }));
	}

	@Test
	public void testDouble23() {
		assertTrue(array.double23(new int[] { 2, 2 }));
		assertTrue(array.double23(new int[] { 3, 3 }));
		assertFalse(array.double23(new int[] { 2, 3 }));
		assertFalse(array.double23(new int[] { 3, 2 }));
		assertFalse(array.double23(new int[] { 4, 5 }));
		assertFalse(array.double23(new int[] { 2 }));
		assertFalse(array.double23(new int[] { 3 }));
		assertFalse(array.double23(new int[] {}));
		assertFalse(array.double23(new int[] { 3, 4 }));
	}

	@Test
	public void testFix23() {
		assertArrayEquals(new int[] { 1, 2, 0 },
				array.fix23(new int[] { 1, 2, 3 }));
		assertArrayEquals(new int[] { 2, 0, 5 },
				array.fix23(new int[] { 2, 3, 5 }));
		assertArrayEquals(new int[] { 1, 2, 1 },
				array.fix23(new int[] { 1, 2, 1 }));
		assertArrayEquals(new int[] { 3, 2, 1 },
				array.fix23(new int[] { 3, 2, 1 }));
		assertArrayEquals(new int[] { 2, 2, 0 },
				array.fix23(new int[] { 2, 2, 3 }));
		assertArrayEquals(new int[] { 2, 0, 3 },
				array.fix23(new int[] { 2, 3, 3 }));
	}

	@Test
	public void testStart1() {
		assertEquals(2, array.start1(new int[] { 1, 2, 3 }, new int[] { 1, 3 }));
		assertEquals(1, array.start1(new int[] { 7, 2, 3 }, new int[] { 1 }));
		assertEquals(1, array.start1(new int[] { 1, 2 }, new int[] {}));
		assertEquals(1, array.start1(new int[] {}, new int[] { 1, 2 }));
		assertEquals(0, array.start1(new int[] { 7 }, new int[] {}));
		assertEquals(1, array.start1(new int[] { 7 }, new int[] { 1 }));
		assertEquals(2, array.start1(new int[] { 1 }, new int[] { 1 }));
		assertEquals(0, array.start1(new int[] { 7 }, new int[] { 8 }));
		assertEquals(0, array.start1(new int[] {}, new int[] {}));
		assertEquals(2, array.start1(new int[] { 1, 3 }, new int[] { 1 }));
	}

	public void testBiggerTwo() {
		assertArrayEquals(new int[] { 3, 4 },
				array.biggerTwo(new int[] { 1, 2 }, new int[] { 3, 4 }));
		assertArrayEquals(new int[] { 3, 4 },
				array.biggerTwo(new int[] { 3, 4 }, new int[] { 1, 2 }));
		assertArrayEquals(new int[] { 1, 2 },
				array.biggerTwo(new int[] { 1, 1 }, new int[] { 1, 2 }));
		assertArrayEquals(new int[] { 2, 1 },
				array.biggerTwo(new int[] { 2, 1 }, new int[] { 1, 1 }));
		assertArrayEquals(new int[] { 2, 2 },
				array.biggerTwo(new int[] { 2, 2 }, new int[] { 1, 3 }));
		assertArrayEquals(new int[] { 1, 3 },
				array.biggerTwo(new int[] { 1, 3 }, new int[] { 2, 2 }));
		assertArrayEquals(new int[] { 6, 7 },
				array.biggerTwo(new int[] { 6, 7 }, new int[] { 3, 1 }));
	}

	@Test
	public void testMakeMiddle() {
		assertArrayEquals(new int[] { 2, 3 },
				array.makeMiddle(new int[] { 1, 2, 3, 4 }));
		assertArrayEquals(new int[] { 2, 3 },
				array.makeMiddle(new int[] { 7, 1, 2, 3, 4, 9 }));
		assertArrayEquals(new int[] { 1, 2 },
				array.makeMiddle(new int[] { 1, 2 }));
		assertArrayEquals(new int[] { 2, 4 },
				array.makeMiddle(new int[] { 5, 2, 4, 7 }));
		assertArrayEquals(new int[] { 4, 3 },
				array.makeMiddle(new int[] { 9, 0, 4, 3, 9, 1 }));
	}

	@Test
	public void testPlusTwo() {
		assertArrayEquals(new int[] { 1, 2, 3, 4 },
				array.plusTwo(new int[] { 1, 2 }, new int[] { 3, 4 }));
		assertArrayEquals(new int[] { 4, 4, 2, 2 },
				array.plusTwo(new int[] { 4, 4 }, new int[] { 2, 2 }));
		assertArrayEquals(new int[] { 9, 2, 3, 4 },
				array.plusTwo(new int[] { 9, 2 }, new int[] { 3, 4 }));
	}

	@Test
	public void testSwapEnds() {
		assertArrayEquals(new int[] { 4, 2, 3, 1 },
				array.swapEnds(new int[] { 1, 2, 3, 4 }));
		assertArrayEquals(new int[] { 3, 2, 1 },
				array.swapEnds(new int[] { 1, 2, 3 }));
		assertArrayEquals(new int[] { 5, 6, 7, 9, 8 },
				array.swapEnds(new int[] { 8, 6, 7, 9, 5 }));
		assertArrayEquals(new int[] { 9, 1, 4, 1, 5, 3 },
				array.swapEnds(new int[] { 3, 1, 4, 1, 5, 9 }));
		assertArrayEquals(new int[] { 2, 1 },
				array.swapEnds(new int[] { 1, 2 }));
		assertArrayEquals(new int[] { 1 }, array.swapEnds(new int[] { 1 }));
	}

	@Test
	public void testMidThree() {
		assertArrayEquals(new int[] { 2, 3, 4 },
				array.midThree(new int[] { 1, 2, 3, 4, 5 }));
		assertArrayEquals(new int[] { 7, 5, 3 },
				array.midThree(new int[] { 8, 6, 7, 5, 3, 0, 9 }));
		assertArrayEquals(new int[] { 1, 2, 3 },
				array.midThree(new int[] { 1, 2, 3 }));
	}

	@Test
	public void testFrontPiece() {
		assertArrayEquals(new int[] { 1, 2 },
				array.frontPiece(new int[] { 1, 2, 3 }));
		assertArrayEquals(new int[] { 1, 2 },
				array.frontPiece(new int[] { 1, 2 }));
		assertArrayEquals(new int[] { 1 }, array.frontPiece(new int[] { 1 }));
		assertArrayEquals(new int[] {}, array.frontPiece(new int[] {}));
		assertArrayEquals(new int[] { 6, 5 },
				array.frontPiece(new int[] { 6, 5, 0 }));
		assertArrayEquals(new int[] { 6, 5 },
				array.frontPiece(new int[] { 6, 5 }));
		assertArrayEquals(new int[] { 3, 1 },
				array.frontPiece(new int[] { 3, 1, 4, 1, 5 }));
		assertArrayEquals(new int[] { 6 }, array.frontPiece(new int[] { 6 }));
	}

	@Test
	public void testUnlucky1() {
		assertTrue(array.unlucky1(new int[] { 1, 3, 4, 5 }));
		assertTrue(array.unlucky1(new int[] { 2, 1, 3, 4, 5 }));
		assertFalse(array.unlucky1(new int[] { 1, 1, 1 }));
		assertTrue(array.unlucky1(new int[] { 1, 3, 1 }));
		assertTrue(array.unlucky1(new int[] { 1, 1, 3 }));
		assertFalse(array.unlucky1(new int[] { 1, 2, 3 }));
		assertFalse(array.unlucky1(new int[] { 3, 3, 3 }));
		assertTrue(array.unlucky1(new int[] { 1, 3 }));
		assertFalse(array.unlucky1(new int[] { 1, 4 }));
		assertFalse(array.unlucky1(new int[] { 1 }));
		assertFalse(array.unlucky1(new int[] {}));
		assertFalse(array.unlucky1(new int[] { 1, 1, 1, 3, 1 }));
		assertTrue(array.unlucky1(new int[] { 1, 1, 3, 1, 1 }));
		assertTrue(array.unlucky1(new int[] { 1, 1, 1, 1, 3 }));
		assertFalse(array.unlucky1(new int[] { 1, 4, 1, 5 }));
		assertFalse(array.unlucky1(new int[] { 1, 1, 2, 3 }));
		assertFalse(array.unlucky1(new int[] { 2, 3, 2, 1 }));
		assertTrue(array.unlucky1(new int[] { 2, 3, 1, 3 }));
		assertTrue(array.unlucky1(new int[] { 1, 2, 3, 4, 1, 3 }));
	}

	@Test
	public void testMake2() {
		assertArrayEquals(new int[] { 4, 5 },
				array.make2(new int[] { 4, 5 }, new int[] { 1, 2, 3 }));
		assertArrayEquals(new int[] { 4, 1 },
				array.make2(new int[] { 4 }, new int[] { 1, 2, 3 }));
		assertArrayEquals(new int[] { 1, 2 },
				array.make2(new int[] {}, new int[] { 1, 2 }));
		assertArrayEquals(new int[] { 1, 2 },
				array.make2(new int[] { 1, 2 }, new int[] {}));
		assertArrayEquals(new int[] { 3, 1 },
				array.make2(new int[] { 3 }, new int[] { 1, 2, 3 }));
		assertArrayEquals(new int[] { 3, 1 },
				array.make2(new int[] { 3 }, new int[] { 1 }));
		assertArrayEquals(new int[] { 3, 1 },
				array.make2(new int[] { 3, 1, 4 }, new int[] {}));
		assertArrayEquals(new int[] { 1, 1 },
				array.make2(new int[] { 1 }, new int[] { 1 }));
		assertArrayEquals(new int[] { 1, 2 },
				array.make2(new int[] { 1, 2, 3 }, new int[] { 7, 8 }));
		assertArrayEquals(new int[] { 7, 8 },
				array.make2(new int[] { 7, 8 }, new int[] { 1, 2, 3 }));
		assertArrayEquals(new int[] { 7, 1 },
				array.make2(new int[] { 7 }, new int[] { 1, 2, 3 }));
		assertArrayEquals(new int[] { 5, 4 },
				array.make2(new int[] { 5, 4 }, new int[] { 2, 3, 7 }));
	}

	@Test
	public void testRont11() {
		assertArrayEquals(new int[] { 1, 7 },
				array.front11(new int[] { 1, 2, 3 }, new int[] { 7, 9, 8 }));
		assertArrayEquals(new int[] { 1, 2 },
				array.front11(new int[] { 1 }, new int[] { 2 }));
		assertArrayEquals(new int[] { 1 },
				array.front11(new int[] { 1, 7 }, new int[] {}));
		assertArrayEquals(new int[] { 2 },
				array.front11(new int[] {}, new int[] { 2, 8 }));
		assertArrayEquals(new int[] {},
				array.front11(new int[] {}, new int[] {}));
		assertArrayEquals(new int[] { 3, 1 },
				array.front11(new int[] { 3 }, new int[] { 1, 4, 1, 9 }));
		assertArrayEquals(new int[] { 1 },
				array.front11(new int[] { 1, 4, 1, 9 }, new int[] {}));
	}

	@Before
	public void setUp() {
		array = new Array1();
	}
}
