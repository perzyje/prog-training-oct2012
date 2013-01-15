package com.tora.koans.level1;

import org.junit.*;
import static com.tora.koans.ImplementationStub.*;

public final class AboutCasting {
	@Test
	public void longPlusInt() {
		int a = 6;
		long b = 10;
		Object c = a + b;
		assertEquals(c, __);
		assertEquals(c instanceof Integer, __);
		assertEquals(c instanceof Long, __);
	}

	@Test
	public void forceIntTypecast() {
		long a = 2147483648L;
		// What happens if we force a long value into an int?
		int b = (int) a;
		assertEquals(b, __);
	}

	@Test
	public void implicitTypecast() {
		int a = 1;
		int b = Integer.MAX_VALUE;
		long c = a + b;
		assertEquals(c, __);
	}

	interface Sleepable {
		String sleep();
	}

	class Child implements Sleepable {
		public String sleep() {
			return "zzzz";
		}
	}

	class Parent extends Child {
		public String complain() {
			return "TPS reports don't even have a cover letter!";
		}
	}

	class GrandParent extends Parent {
		public String complain() {
			return "Get your feet off the davenport!";
		}
	}

	@Test
	public void downCastWithInerhitance() {
		GrandParent grandParent = new GrandParent();
		Parent parentReference = grandParent; // Why isn't there an explicit
												// cast?
		assertEquals(grandParent instanceof GrandParent, __);
		assertEquals(parentReference instanceof GrandParent, __);
		assertEquals(parentReference instanceof Parent, __);
		assertEquals(parentReference instanceof Child, __);
	}

	@Test
	public void downCastAndPolymophism() {
		GrandParent grandParent = new GrandParent();
		Parent parentReference = grandParent;
		// If the result is unexpected, consider the difference between an
		// instance and its reference
		assertEquals(parentReference.complain(), __);
	}

	@Test
	public void upCastWithInheritance() {
		Child grandParent = new GrandParent();
		Parent parentReference = (Parent) grandParent; // Why do we need an
														// explicit cast here?
		GrandParent grandParentReference = (GrandParent) parentReference; // Or
																			// here?
		assertEquals(grandParentReference instanceof GrandParent, __);
		assertEquals(grandParentReference instanceof Parent, __);
		assertEquals(grandParentReference instanceof Child, __);
	}

	@Test
	public void upCastAndPolymophism() {
		Child grandParent = new GrandParent();
		Parent parent = (GrandParent) grandParent;
		// Think about the result. Did you expect that? Why?
		// How is that different from above?
		assertEquals(parent.complain(), __);
	}

	@Test
	public void classCasting() {
		Object o = new Object();
		((Sleepable) o).sleep();
	}

	@Test
	public void complicatedCast() {
		@SuppressWarnings("unused")
		Child parent = new Parent();
		// How can we access the parent's ability to "complain" - if the
		// reference is held as a superclass?
		// replace __ below with parent.<something>
		assertEquals(new Parent().complain(), __);
	}
}
