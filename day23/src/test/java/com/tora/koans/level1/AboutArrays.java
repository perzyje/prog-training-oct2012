package com.tora.koans.level1;

import org.junit.*;
import java.util.*;
import static com.tora.koans.ImplementationStub.*;

public final class AboutArrays {
	@Test
	public void areArrayContentsConsideredInEquals() {
		// arr1 and arr2 contain the same things
		int[] arr1 = { 1 }, arr2 = { 1 };
		boolean eq = arr1.equals(arr2);
		assertEquals(__, eq);
	}

	@Test
	public void areClonedArrayEqual() {
		int[] arr1 = { 1 };
		int[] arr2 = arr1.clone();
		boolean eq = arr1.equals(arr2);
		assertEquals(__, eq);
	}

	@Test
	public void doesArraysHashCodeMethodDoesConsiderElements() {
		int[] array0 = new int[] { 1 };
		int[] array1 = new int[] { 1 };
		boolean eq = array0.hashCode() == array1.hashCode();
		assertEquals(__, eq);
	}

	@Test
	public void arraysHelperClassEqualsMethodConsidersElementsWhenDeterminingEquality() {
		int[] array0 = new int[] { 1 };
		int[] array1 = new int[] { 1 };
		boolean eq = Arrays.equals(array0, array1);
		assertEquals(__, eq);
	}

	@Test
	public void arraysHelperClassHashCodeMethodConsidersElementsWhenDeterminingHashCode() {
		int[] array0 = new int[] { 0 };
		int[] array1 = new int[] { 0 };
		boolean eq = Arrays.hashCode(array0) == Arrays.hashCode(array1);
		assertEquals(__, eq);
	}

	@Test
	public void areFinalArraysMutable() {
		final boolean[] oneBoolean = new boolean[] { false };
		oneBoolean[0] = true;
		assertEquals(__, oneBoolean[0]);
	}

	@Test
	public void arrayIndexing() {
		int[] integers = new int[] { 1, 2 };
		assertEquals(integers[0], __);
		assertEquals(integers[1], __);
	}

	@Test
	public void whatHappensWhenNonExistingElementIsAccessed() {
		int[] array = new int[] { 1 };
		array[1] = 42;
	}

	@Test
	public void whatIsTheArrayLength() {
		assertEquals(new int[2].length, __);
	}

}
