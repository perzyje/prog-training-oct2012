package com.tora;

import org.junit.*;
import java.util.*;

import static org.junit.Assert.*;

public final class SimpleTest {
	private List<Integer> list;
	
	@Test
	public void testSize() {
		assertEquals(4, list.size());
	}
	
	@Test
	public void testEmpty() {
		assertFalse(list.isEmpty());
	}
	
	@Test
	public void testGet() {
		assertEquals(1, (int)list.get(0));
		assertEquals(42, (int)list.get(3));
	}
	
	@Test(expected=IndexOutOfBoundsException.class)
	public void testGetOutOfBounds() {
		list.get(4);
	}
	
	@Test(expected=IndexOutOfBoundsException.class)
	public void testGetNegativeIndex() {
		list.get(-2);
	}
	
	@Test
	public void testClear() {
		list.clear();
		assertEquals(0, list.size());
		assertTrue(list.isEmpty());
	}
	
	@Test
	public void testAdd() {
		list.add(10);
		assertEquals(10, (int)list.get(4));
	}
	
	@Test
	public void testAddCollection() {
		list.addAll(Arrays.asList(5,6));
		assertEquals(Arrays.asList(1, 2, 3, 42, 5, 6), list);
	}
	
	@Test
	public void testAddCollectionIndex() {
		list.addAll(2, Arrays.asList(5, 6, 8, 2));
		assertEquals(Arrays.asList(1, 2, 5, 6, 8, 2, 3, 42), list);
	}
	
	@Test(expected=IndexOutOfBoundsException.class)
	public void testAddCollectionOutOfBounds() {
		list.addAll(43, Arrays.asList(2, 5, 6, 7, 8, 9));
	}
	
	@Test
	public void testAddBeginning() {
		list.add(0, 33);
		assertEquals(33, (int)list.get(0));
	}
	
	@Test
	public void testContains() {
		assertTrue(list.contains(42));
		assertFalse(list.contains(45));
	}
	
	@Test
	public void testAddInTheMiddle() {
		list.add(2, 10);
		assertEquals(10, (int)list.get(2));
	}
	
	@Test(expected=IndexOutOfBoundsException.class)
	public void testAddOutOfBounds(){
		list.add(7, 42);
	}
	
	@Test(expected=IndexOutOfBoundsException.class)
	public void testAddNegativeIndex(){
		list.add(-3, 23);
	}
	
	@Test
	public void testSet() {
		list.set(1, 10);
		assertEquals(10, (int)list.get(1));
	}
	
	@Test
	public void testRemove() {
		assertEquals(3, (int)list.remove(2));
		assertEquals(42, (int)list.remove(2));
		assertEquals(1, (int)list.remove(0));
		assertEquals(2, (int)list.remove(0));
		assertEquals(0, list.size());
	}
	
	@Test(expected=IndexOutOfBoundsException.class)
	public void testRemoveOutOfBounds() {
		list.remove(54);
	}
	
	@Test(expected=IndexOutOfBoundsException.class)
	public void testRemoveNegativeIndex() {
		list.remove(-3);
	}
	
	@Test
	public void testIterator() {
		ListIterator<Integer> i = list.listIterator();
		List<Integer> collected = new ArrayList<Integer>();
		List<Integer> inverted = new ArrayList<Integer>();
		while (i.hasNext()) {
			collected.add(i.next());
		}
		while (i.hasPrevious()) {
			inverted.add(i.previous());
		}
		
		assertEquals(Arrays.asList(1, 2, 3, 42), collected);
		assertEquals(Arrays.asList(42, 3, 2, 1), inverted);
	}
	
	@Test(expected=NoSuchElementException.class)
	public void testIteratorNoNext(){
		ListIterator<Integer> i = list.listIterator();
		while (i.hasNext()){
			i.next();
		}
		i.next();
	}
	
	@Test(expected=NoSuchElementException.class)
	public void testIteratorNoPrevious(){
		ListIterator<Integer> i = list.listIterator();
		i.previous();
	}
	
	@Test
	public void testIteratorNextIndex() {
		ListIterator<Integer> i = list.listIterator();
		assertEquals(0, i.nextIndex());
		i.next();i.next();
		assertEquals(2, i.nextIndex());
		i.next();
		assertEquals(3, i.nextIndex());
		i.next();
		assertEquals(list.size(), i.nextIndex());
	}
	
	@Test
	public void testIteratorPreviousIndex() {
		ListIterator<Integer> i = list.listIterator();
		assertEquals(-1, i.previousIndex());
		i.next();i.next();
		assertEquals(1, i.previousIndex());
	}
	
	@Test
	public void testIteratorAdd() {
		ListIterator<Integer> i = list.listIterator();
		i.add(23);
		i.next();
		i.add(5);
		assertEquals(Arrays.asList(23, 1, 5, 2, 3, 42), list);
	}
	
	@Test(expected=IllegalStateException.class)
	public void testIteratorSetBeforeIterating() {
		ListIterator<Integer> i = list.listIterator();
		i.set(23);
	}
	
	@Test(expected=IllegalStateException.class)
	public void testIteratorSetAfterAdd() {
		ListIterator<Integer> i = list.listIterator();
		i.next(); i.add(7);
		i.set(8);
	}
	
	@Test(expected=IllegalStateException.class)
	public void testIteratorSetAfterRemove() {
		ListIterator<Integer> i = list.listIterator();
		i.next(); i.next(); i.remove();
		i.set(25);
	}
	
	@Test
	public void testIteratorSet() {
		ListIterator<Integer> i = list.listIterator();
		i.next(); i.set(24);
		i.next(); i.set(3);
		i.next(); i.next();
		i.previous(); i.set(43);
		assertEquals(Arrays.asList(24, 3, 3, 43), list);
	}
	
	@Test(expected=IllegalStateException.class)
	public void testIteratorRemoveBeforeIterating() {
		ListIterator<Integer> i = list.listIterator();
		i.remove();
	}
	
	@Test(expected=IllegalStateException.class)
	public void testIteratorRemoveAfterAdd() {
		ListIterator<Integer> i = list.listIterator();
		i.next(); i.add(4);
		i.remove();
	}
	
	@Test(expected=IllegalStateException.class)
	public void testIteratorRemoveAfterRemove() {
		ListIterator<Integer> i = list.listIterator();
		i.next(); i.next(); i.remove();
		i.remove();
	}
	
	@Test
	public void testIteratorRemove() {
		ListIterator<Integer> i = list.listIterator();
		i.next(); i.next();
		i.remove();
		i.next();
		i.previous();
		i.remove();
		assertEquals(Arrays.asList(1, 42), list);
	}

	@Before
	public void setUp() {
		list = new ArrayList<Integer>();
		list.addAll(Arrays.asList(1, 2, 3, 42));
	}
}
