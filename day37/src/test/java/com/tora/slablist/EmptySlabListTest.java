package com.tora.slablist;

import java.util.*;
import org.junit.*;
import static org.junit.Assert.*;

public class EmptySlabListTest {
	private SlabList<Integer> lst;

	@Test
	public void testState() {
		assertEquals(0, lst.size());
		assertTrue(lst.isEmpty());
		assertFalse(lst.removeAll(Collections.emptyList()));
	}

	@Test(expected = IndexOutOfBoundsException.class)
	public void testGet() {
		System.out.println(lst.toString());
		lst.get(0);
	}

	@Test(expected = IndexOutOfBoundsException.class)
	public void testSet() {
		lst.set(0, Integer.MAX_VALUE);
	}

	@Test(expected = IndexOutOfBoundsException.class)
	public void testAddAll() {
		lst.addAll(1, Collections.<Integer> emptyList());
	}

	@Test(expected = IndexOutOfBoundsException.class)
	public void testRemove() {
		lst.remove(0);
	}

	@Test(expected = IndexOutOfBoundsException.class)
	public void testListIterator() {
		lst.listIterator(1);
	}

	@Test
	public void testListIteratorNextPrev() {
		ListIterator<Integer> it = lst.listIterator();
		assertFalse(it.hasNext());
		assertFalse(it.hasPrevious());
	}

	@Test
	public void testIterator() {
		assertFalse(lst.iterator().hasNext());
	}

	@Before
	public void setUp() {
		lst = new SlabList<Integer>();
	}
}
