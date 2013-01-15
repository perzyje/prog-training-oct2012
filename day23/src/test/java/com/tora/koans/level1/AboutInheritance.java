package com.tora.koans.level1;

import org.junit.*;
import java.util.*;
import static com.tora.koans.ImplementationStub.*;

public final class AboutInheritance {

	class Parent {
		public String doStuff() {
			return "parent";
		}
	}

	class Child extends Parent {
		public String doStuff() {
			return "child";
		}

		public String doStuff(String s) {
			return s;
		}
	}

	@Test
	public void differenceBetweenOverloadingAndOverriding() {
		assertEquals(new Parent().doStuff(), __);
		assertEquals(new Child().doStuff(), __);
		assertEquals(new Child().doStuff("oh no"), __);
	}

	abstract class ParentTwo {
		abstract public Collection<?> doStuff();
	}

	class ChildTwo extends ParentTwo {
		public Collection<?> doStuff() {
			return Collections.emptyList();
		};
	}

	@Test
	public void overridenMethodsMayReturnSubtype() {
		// What do you need to change in order to get rid of the type cast?
		// Why does this work?
		List<?> list = (List<?>) new ChildTwo().doStuff();
		assertEquals(list instanceof List, __);
	}
}
