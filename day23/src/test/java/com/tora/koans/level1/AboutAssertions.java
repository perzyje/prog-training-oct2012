package com.tora.koans.level1;

import org.junit.*;
import static com.tora.koans.ImplementationStub.*;

public final class AboutAssertions {
	@Test
	public void assertBooleanTrue() {
		assertTrue(__);
	}

	@Test
	public void assertBooleanFalse() {
		assertFalse(__);
	}

	@Test
	public void assertNullObject() {
		assertNull(__);
	}

	@Test
	public void assertNotNullObject() {
		assertNotNull(__);
	}

	@Test
	public void assertEqualsWithDescriptiveMessage() {
		assertEquals("1 should equal 1", 1, __);
	}

	@Test
	public void assertSameInstance() {
		Integer same = new Integer(1);
		assertSame(same, __);
	}

	@Test
	public void assertNotSameInstance() {
		Integer same = new Integer(1);
		assertNotSame(same, __);
	}
}
