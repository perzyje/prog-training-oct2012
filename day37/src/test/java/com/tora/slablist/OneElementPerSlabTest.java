package com.tora.slablist;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class OneElementPerSlabTest {

	private SlabList<Integer> list;

	@Before
	public void setUp() throws Exception {
		list = new SlabList<Integer>(0, 1, 0);
	}

	@Test
	public void AddTest() {
		list.add(new Integer(42));
		list.add(new Integer(68));

		assertFalse(list.isEmpty());
	}

	@Test
	public void AddAndGetTest() {
		list.add(new Integer(42));
		list.add(new Integer(68));
		list.add(new Integer(58));
		list.add(new Integer(100));

		assertEquals(new Integer(42), list.get(0));
		assertEquals(new Integer(68), list.get(1));
		assertEquals(new Integer(58), list.get(2));
		assertEquals(new Integer(100), list.get(3));
	}
}