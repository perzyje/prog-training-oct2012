package com.codingbat;

import org.junit.*;
import static org.junit.Assert.*;

public class WarmUp2Test {
	private WarmUp2 warmup;

	@Test
	public void testDoubleX() {
		assertTrue(warmup.doubleX("axxbb"));
		assertFalse(warmup.doubleX("axaxax"));
		assertTrue(warmup.doubleX("xxxxx"));
		assertFalse(warmup.doubleX("xaxxx"));
		assertFalse(warmup.doubleX("aaaax"));
		assertFalse(warmup.doubleX(""));
		assertFalse(warmup.doubleX("abc"));
		assertFalse(warmup.doubleX("x"));
		assertTrue(warmup.doubleX("xx"));
		assertFalse(warmup.doubleX("xax"));
		assertFalse(warmup.doubleX("xaxx"));
	}

	@Test
	public void testCountXX() {
		assertEquals(1, warmup.countXX("abcxx"));
		assertEquals(2, warmup.countXX("xxx"));
		assertEquals(3, warmup.countXX("xxxx"));
		assertEquals(0, warmup.countXX("abc"));
		assertEquals(0, warmup.countXX("Hello there"));
		assertEquals(2, warmup.countXX("Hexxo thxxe"));
		assertEquals(0, warmup.countXX(""));
		assertEquals(0, warmup.countXX("Kittens"));
		assertEquals(2, warmup.countXX("Kittensxxx"));
	}

	@Before
	public void setUp() {
		warmup = new WarmUp2();
	}
}
