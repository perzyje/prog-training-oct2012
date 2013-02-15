package com.tora.slablist;

import static org.junit.Assert.*;

import java.util.Iterator;

import org.junit.Before;
import org.junit.Test;

public class SlabListTest {

	private SlabList<Integer> list;

	@Before
	public void setUp() throws Exception {
		list = new SlabList<Integer>(0, 2, 0);
	}

	@Test
	public void firstTest() {
		assertTrue(list.isEmpty());
		assertEquals(0, list.size());
	}

	@Test
	public void simpleAddTest() {
		list.add(new Integer(10));
		assertFalse(list.isEmpty());
	}

	@Test
	public void multipleAddTest() {
		list.add(0, new Integer(10));
		list.add(1, new Integer(20));
		list.add(2, new Integer(30));
		list.add(3, new Integer(40));
		list.add(4, new Integer(50));

		assertEquals(Integer.valueOf(10), list.get(0));
		assertEquals(Integer.valueOf(30), list.get(2));
		assertEquals(Integer.valueOf(50), list.get(4));
	}

	@Test
	public void addNullElementTest() {
		list.add(10);
		list.add(null);
		list.add(20);

		assertEquals(null, list.get(1));
	}

	@Test(expected = IndexOutOfBoundsException.class)
	public void addAtNegativeIndexTest() {
		list.add(-3, new Integer(70));
	}

	@Test
	public void addingAtLastPositionTest() {
		list.add(10);
		list.add(1, 20);

		assertEquals(Integer.valueOf(20), list.get(1));
	}

	@Test
	public void complexMultipleAddTest() {
		list.add(0, new Integer(10));
		list.add(1, new Integer(20));
		list.add(0, new Integer(30));
		list.add(2, new Integer(40));
		list.add(1, new Integer(50));

		assertEquals(Integer.valueOf(30), list.get(0));
		assertEquals(Integer.valueOf(10), list.get(2));
		assertEquals(Integer.valueOf(20), list.get(4));
	}

	@Test
	public void simpleRemoveTest() {
		list.add(0, new Integer(10));
		list.add(1, new Integer(20));

		list.remove(0);

		assertEquals(Integer.valueOf(20), list.get(0));
	}

	@Test(expected = IndexOutOfBoundsException.class)
	public void removeFromInvalidPositionTest() {
		list.add(10);
		list.remove(2);
	}

	@Test
	public void complexMultipleRemoveTest() {
		list.add(0, new Integer(10));
		list.add(1, new Integer(20));
		list.add(0, new Integer(30));
		list.add(2, new Integer(40));
		list.add(1, new Integer(50));

		list.remove(2);
		list.remove(3);

		assertEquals(Integer.valueOf(30), list.get(0));
		assertEquals(Integer.valueOf(40), list.get(2));
	}

	@Test(expected = IndexOutOfBoundsException.class)
	public void removeAtEmptySlabListTest() {
		list.remove(0);
	}

	@Test(expected = IndexOutOfBoundsException.class)
	public void removeNegativeIndexTest() {
		list.remove(-1);
	}

	@Test
	public void removeFirstAndOnlyTest() {
		list.add(10);

		assertEquals(Integer.valueOf(10), list.remove(0));
		assertTrue(list.isEmpty());
	}

	@Test
	public void simpleSetTest() {
		list.add(0, new Integer(10));
		list.add(1, new Integer(20));

		list.set(0, 30);

		assertEquals(Integer.valueOf(30), list.get(0));
	}

	@Test
	public void doubleTestWithAddAndGet() {
		list.add(0, new Integer(10));
		list.add(1, new Integer(20));

		assertEquals(Integer.valueOf(10), list.get(0));
		assertEquals(Integer.valueOf(20), list.get(1));
	}

	@Test
	public void iteratorTest() {
		list.add(0, new Integer(10));
		list.add(1, new Integer(20));
		list.add(2, new Integer(30));
		list.add(3, new Integer(40));

		Iterator<Integer> it = list.listIterator();

		assertEquals(Integer.valueOf(10), it.next());
		assertEquals(Integer.valueOf(20), it.next());
		assertEquals(Integer.valueOf(30), it.next());
		assertEquals(Integer.valueOf(40), it.next());
	}

	@Test
	public void removeByIndexTest() {
		list.add(0, new Integer(10));
		list.add(1, new Integer(20));

		list.remove(0);

		assertEquals(Integer.valueOf(20), list.get(0));
	}

	@Test
	public void twoListsEqualityTest() {
		list.add(10);
		list.add(20);

		SlabList<Integer> listForEquality = new SlabList<Integer>();
		listForEquality.add(10);
		listForEquality.add(20);

		assertTrue(list.equals(listForEquality));
	}

	@Test
	public void removeFromIteratorTest() {
		list.add(10);
		list.add(20);
		list.add(30);
		list.add(40);
		list.add(50);
		list.add(60);

		Iterator<Integer> it = list.iterator();
		it.next();
		it.next();
		it.remove();

		assertEquals(5, list.size());
		assertEquals(Integer.valueOf(40), list.get(2));
	}

	@Test
	public void twoIteratorsTest() {
		list.add(10);
		list.add(20);
		list.add(30);
		list.add(40);
		list.add(50);

		Iterator<Integer> it1 = list.iterator();
		Iterator<Integer> it2 = list.iterator();

		it1.next();
		it2.next();

		assertEquals(it1.next(), it2.next());
	}

	@Test
	public void addAndContainsTest() {
		list.add(10);
		list.add(20);
		list.add(30);
		list.add(40);
		list.add(50);

		assertTrue(list.contains(20));
		assertFalse(list.contains(0));
	}

	@Test
	public void indexOfTest() {
		list.add(10);
		list.add(20);

		list.remove(0);

		assertEquals(0, list.indexOf(new Integer(20)));
	}

	@Test
	public void lastIndexOfIndex() {
		list.add(10);
		list.add(null);
		list.add(20);

		assertEquals(2, list.lastIndexOf(new Integer(20)));
	}

	@Test
	public void insertAndRemoveMaxElementAtDefaultSlabListTest() {
		for (int i = 0; i < 1024; i++) {
			list.add(i);
		}
		assertEquals(1024, list.size());

		for (int i = 0; i < 1024; i++)
			list.remove(0);
		assertTrue(list.isEmpty());
	}
}