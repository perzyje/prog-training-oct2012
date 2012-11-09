package com.tora;

import static org.junit.Assert.*;

import org.junit.Test;

public class DoubleLinkedListTest<E> {
	private final DoubleLinkedList<E> list = new DoubleLinkedList<E>();
	@Test
	public void isEmptyTest() {
		assertEquals(0,list.size());
	}
	
	@Test 
	public void addToIndexTest(){
		list.add(0,(E) "element");
		assertEquals(1,list.size());
		list.add(0,(E) "element");
		assertEquals(2,list.size());
	}
	
	@Test
	public void addElementTest(){
		list.add((E) "element");
		assertEquals(1,list.size());
	}
	
	@Test(expected=IndexOutOfBoundsException.class)
	public void addToNonExistingElement(){
		list.add(-1,(E) "test");
		list.add(list.size()+1,(E) "test");
	}
	
	@Test(expected=IndexOutOfBoundsException.class)
	public void accessToNonExistingElement(){
		list.get(-1);
		list.get(list.size()+1);
	}
	
	@Test
	public void addAllTest(){
		list.add((E) "Test");
		list.add((E) "Test");
		list.add((E) "Test");
		list.add((E) "Test");
		DoubleLinkedList<E> listTest = new DoubleLinkedList<E>();
		listTest.addAll(0, list);
		assertEquals(4,listTest.size());
	}

}
