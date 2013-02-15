package com.tora.slablist;

import java.util.*;

public final class SlabList<T> extends AbstractList<T> {

	private static final int DEFAULT_VALUE = 1048064;
	private final int maxDimension, increment, reallocaTreshold;

	public SlabList() {
		this(2, DEFAULT_VALUE, 2);
	}

	public SlabList(int increment, int maxDimension, int reallocaTreshold) {
		this.increment = increment;
		this.maxDimension = maxDimension;
		this.reallocaTreshold = reallocaTreshold;
	}

	@Override
	public void add(int index, T element) {
	}

	@Override
	public T get(int index) {
		return null;
	}

	@Override
	public T set(int index, T value) {
		return null;
	}

	@Override
	public T remove(int index) {
		return null;
	}

	@Override
	public int size() {
		return 0;
	}
}