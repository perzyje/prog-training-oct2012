package com.tora.koans.level2;

import java.util.*;
import org.junit.*;
import static com.tora.koans.ImplementationStub.*;

public final class AboutAutoboxing {

	@Test
	public void addPrimativesToCollection() {
		List<Integer> list = new ArrayList<Integer>();
		list.add(0, new Integer(42));
		assertEquals(list.get(0), __);
	}

	@Test
	public void addPrimativesToCollectionWithAutoBoxing() {
		List<Integer> list = new ArrayList<Integer>();
		list.add(0, 42);
		assertEquals(list.get(0), __);
	}

	@Test
	public void migrateYourExistingCodeToAutoBoxingWithoutFear() {
		List<Integer> list = new ArrayList<Integer>();
		list.add(0, new Integer(42));
		assertEquals(list.get(0), __);

		list.add(1, 84);
		assertEquals(list.get(1), __);
	}

	@Test
	public void allPrimativesCanBeAutoboxed() {
		List<Double> doubleList = new ArrayList<Double>();
		doubleList.add(0, new Double(42));
		assertEquals(doubleList.get(0), __);

		List<Long> longList = new ArrayList<Long>();
		longList.add(0, new Long(42));
		assertEquals(longList.get(0), __);

		List<Character> characterList = new ArrayList<Character>();
		characterList.add(0, new Character('z'));
		assertEquals(characterList.get(0), __);
	}
}
