package com.tora;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class DoubleLinkedListTest {
	private List<String> list;

	@Test
	public void isEmptyTest() {
		list = new ArrayList<String>();
		assertEquals(0, list.size());
	}

	@Test
	public void addToIndexTest() {
		list = new ArrayList<String>();
		list.add(0, "element");
		assertEquals(1, list.size());
		list.add(0, "element");
		assertEquals(2, list.size());
	}

	@Test
	public void addElementTest() {
		list = new ArrayList<String>();
		list.add("element");
		assertEquals(1, list.size());
	}

	@Test(expected = IndexOutOfBoundsException.class)
	public void addToNonExistingElement() {
		list = new ArrayList<String>();
		list.add(-1, "test");
		list.add(list.size() + 1, "test");
	}

	@Test(expected = IndexOutOfBoundsException.class)
	public void accessToNonExistingElement() {
		list = new ArrayList<String>();
		list.get(-1);
		list.get(list.size() + 1);
	}

	@Test
	public void addAllTest() {
		List<String> list = new ArrayList<String>();
		list.add("Test1");
		list.add("Test2");
		list.add("Test3");
		list.add("Test4");
		List<String> listTest = new ArrayList<String>();
		listTest.addAll(0, list);
		assertEquals(4, listTest.size());
		assertEquals("Test1", listTest.get(0));
		assertEquals("Test2", listTest.get(1));
		assertEquals("Test3", listTest.get(2));
		assertEquals("Test4", listTest.get(3));
	}

	@Test
	public void removeElementTest() {
		list = new ArrayList<String>();
		list.add("test1");
		list.add("test2");
		
		assertEquals("test1",list.remove(0));
		assertEquals(1, list.size());
		assertEquals("test2",list.remove(0));
		assertEquals(0, list.size());
	}
	
	@Test
	public void testIteratorFirstElement() {
		list = new ArrayList<String>();
		list.add("abc");
		assertEquals("abc", list.iterator().next());
	}

}
