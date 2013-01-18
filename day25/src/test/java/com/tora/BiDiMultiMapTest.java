package com.tora;

import java.util.*;

import org.junit.*;
import static org.junit.Assert.*;

public final class BiDiMultiMapTest {
	private BiDiMultiMap<String, Integer> map;
	
	@Test
	public void testSize() {
		assertEquals(4, map.size());
	}
	
	@Test
	public void testKeys() {
		assertEquals(Arrays.asList(1, 2) , map.getValues("a"));
		assertEquals(Arrays.asList(1, 2) , map.getValues("b"));
	}
	
	@Test
	public void testValues() {
		assertEquals(Arrays.asList("a", "b"), map.getKeys(1));
		assertEquals(Arrays.asList("a", "b"), map.getKeys(2));
	}
	
	@Test
	public void testNullKeys() {
		map.clear();
		map.put("a", null); map.put("a", 2);
		map.put("b", 1); map.put("b", null);
		
		assertEquals(Arrays.asList(null, 2) , map.getValues("a"));
		assertEquals(Arrays.asList(1, null) , map.getValues("b"));
	}
	
	@Test
	public void testNullValues() {
		map.clear();
		map.put(null, 1); map.put("a", 2);
		map.put("b", 1); map.put(null, 2);
		
		assertEquals(Arrays.asList(null, "b"), map.getKeys(1));
		assertEquals(Arrays.asList("a", null), map.getKeys(2));
	}
	
	private static <T> void testIterator(Iterator<T> it1, Iterator<T> it2) {
		Set<T> keys1 = new HashSet<T>();
		while (it1.hasNext()) { keys1.add(it1.next()); }
		Set<T> keys2 = new HashSet<T>();
		while (it2.hasNext()) { keys2.add(it2.next()); }
		
		assertNotSame(it1, it2);
		assertEquals(keys1, keys2);
	}
	
	@Test
	public void testKeysIterators() {
		testIterator(map.keySet().iterator(), map.keySet().iterator());
	}
	
	@Test
	public void testValuesIterators() {
		testIterator(map.values().iterator(), map.values().iterator());
	}
	
	@Test
	public void testEntriesIterators() {
		testIterator(map.entrySet().iterator(), map.entrySet().iterator());
	}

	@Before
	public void setUp() {
		map = new BiDiMultiMap<String, Integer>();
		map.put("a", 1); map.put("a", 2);
		map.put("b", 1); map.put("b", 2);
	}
}
