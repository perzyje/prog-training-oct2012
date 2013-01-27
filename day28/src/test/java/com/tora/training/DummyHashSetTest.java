package com.tora.training;

import java.util.*;
import org.junit.*;
import java.math.BigDecimal;
import static org.junit.Assert.*;

public final class DummyHashSetTest {
	private Set<BigDecimal> set;

	@Test
	public void testSizeAfterAdd() {
		set.add(BigDecimal.TEN);
		assertEquals(1, set.size());
	}
	
	@Test
	@SuppressWarnings("serial")
	public void testAddWithFunkyHashcode() {
		set.add(new BigDecimal("10") {
			@Override
			public int hashCode() {
				return Integer.MIN_VALUE;
			}
		});
		assertEquals(1, set.size());
	}
	
	@Before
	public void setUp() {
		set = DummyHashSet.create();
	}
}
