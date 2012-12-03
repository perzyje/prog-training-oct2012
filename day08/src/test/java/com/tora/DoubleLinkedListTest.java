package com.tora;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.junit.*;

public final class DoubleLinkedListTest {

	private List<String> list;

	public DoubleLinkedListTest() {
		list = new DoubleLinkedList<String>();

	}

	@Test
	public void isSetCorrect() {
		assertEquals(0, list.size());
	}

	@Test
	public void isInsertedCorrect() {
		list.add("abc");
		assertEquals(1, list.size());
		assertEquals("abc", list.get(0));
	}

	@Test(expected = IndexOutOfBoundsException.class)
	public void indexGreaterThanSize() {
		list.add(3, "xc");
	}

	@Test
	public void insertCollection() {
		Collection<String> cs = new ArrayList<String>();
		cs.add("a1");
		cs.add("a2");
		list.addAll(0, cs);
		assertEquals(2, list.size());
		assertEquals("a1", list.get(0));
		assertEquals("a2", list.get(1));
	}

	@Test
	public void removeIndex() {
		Collection<String> cs = new ArrayList<String>();
		cs.add("a1");
		cs.add("a2");
		cs.add("a3");
		list.addAll(0, cs);
		assertEquals("a1", list.remove(0));
		assertEquals(2, list.size());
		assertEquals("a2", list.get(0));
		assertEquals("a3", list.get(1));
	}

	@Test
	public void removeElement() {
		Collection<String> cs = new ArrayList<String>();
		cs.add("a1");
		cs.add("a2");
		cs.add("a3");
		list.addAll(0, cs);
		assertTrue(list.remove("a2"));
		assertEquals(2, list.size());
		assertEquals("a1", list.get(0));
		assertEquals("a3", list.get(1));
	}
	
	
	
	

}
