package com.tora.koans.level1;

import org.junit.*;
import static com.tora.koans.ImplementationStub.*;

public final class AboutMethodPreference {

	class A {
		public String doStuff(int i) {
			return "int";
		}

		public String doStuff(Integer i) {
			return "Integer";
		}

		public String doStuff(Object i) {
			return "Object";
		}

		public String doStuff(int... i) {
			return "int vararg";
		}
	}

	@Test
	public void methodPreferenceInt() {
		assertEquals(new A().doStuff(1), __);
	}

	@Test
	public void methodPreferenceInteger() {
		assertEquals(new A().doStuff(Integer.valueOf(1)), __);
	}

	@Test
	public void methodPreferenceUsingReference() {
		Number ref = Integer.valueOf(1);
		assertEquals(new A().doStuff(ref), __);
	}

	@Test
	public void methodPreferenceLong() {
		long l = 1;
		assertEquals(new A().doStuff(l), __);
	}

	@Test
	public void methodPreferenceBoxedLong() {
		Long l = Long.valueOf(1);
		assertEquals(new A().doStuff(l), __);
	}

	@Test
	public void methodPreferenceDouble() {
		Double l = Double.valueOf(1);
		assertEquals(new A().doStuff(l), __);
	}

	@Test
	public void methodPreferenceMore() {
		// What happens if you change 'Integer' to 'Double'
		// Does this explain 'methodPreferenceDouble'?
		// Think about why this happens?
		assertEquals(new A().doStuff(1, Integer.valueOf(2)), __);
	}
}
