package com.tora;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

public class DoubleLinkedListTest {
	private List<String> list;

	@Test
	public void isEmptyTest() {
		list = new DoubleLinkedList<String>();
		assertEquals(0, list.size());
	}

	@Test
	public void addToIndexTest() {
		list = new DoubleLinkedList<String>();
		list.add(0, "element");
		assertEquals(1, list.size());
		list.add(0, "element");
		assertEquals(2, list.size());
	}

	@Test
	public void addElementTest() {
		list = new DoubleLinkedList<String>();
		list.add("element");
		assertEquals(1, list.size());
	}

	@Test(expected = IndexOutOfBoundsException.class)
	public void addToNonExistingElement() {
		list = new DoubleLinkedList<String>();
		list.add(-1, "test");
		list.add(list.size() + 1, "test");
	}

	@Test(expected = IndexOutOfBoundsException.class)
	public void accessToNonExistingElement() {
		list = new DoubleLinkedList<String>();
		list.get(-1);
		list.get(list.size() + 1);
	}

	@Test
	public void addAllTest() {
		list = new DoubleLinkedList<String>();
		list.add("Test");
		list.add("Test");
		list.add("Test");
		list.add("Test");
		DoubleLinkedList<String> listTest = new DoubleLinkedList<String>();
		listTest.addAll(0, list);
		assertEquals(4, listTest.size());
	}

	@Test
	public void removeElementTest() {
		list = new DoubleLinkedList<String>();
		list.add("test1");
		list.add("test2");
		assertTrue(list.remove("test1"));
		assertEquals(1, list.size());
		assertTrue(list.remove("test2"));
		assertEquals(0, list.size());
	}

}
