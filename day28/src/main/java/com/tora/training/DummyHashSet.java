package com.tora.training;

import java.util.*;

public final class DummyHashSet<T> extends AbstractSet<T> {
	public static <T> DummyHashSet<T> create() {
		return new DummyHashSet<T>();
	}
	
	private static final int BUCKET_COUNT = 10;
	private final List<T>[] buckets;
	
	public DummyHashSet() {
		@SuppressWarnings("unchecked")
		List<T>[] buckets = new List[BUCKET_COUNT];
		for (int i = 0; i < BUCKET_COUNT; ++i) {
			buckets[i] = new ArrayList<T>();
		}
		this.buckets = buckets;
	}
	
	@Override
	public boolean add(T element) {
		List<T> bucket = buckets[Math.abs(element.hashCode()) % BUCKET_COUNT];
		for (T t : bucket) {
			if (element.equals(t)) { return false; }
		}
		bucket.add(element);
		return true;
	}

	@Override
	public Iterator<T> iterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int size() {
		int result = 0;
		for (List<T> bucket : buckets) {
			result += bucket.size();
		}
		return result;
	}
}
