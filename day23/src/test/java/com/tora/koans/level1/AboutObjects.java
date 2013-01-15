package com.tora.koans.level1;

import org.junit.*;
import static com.tora.koans.ImplementationStub.*;

public final class AboutObjects {

	@Test
	public void objectEqualsNull() {
		// does a new object instance equal the null keyword?
		assertEquals(new Object().equals(null), __);
	}

	@Test
	public void objectEqualsSelf() {
		Object obj = new Object();
		// does a new object equal itself?
		assertEquals(obj.equals(obj), __);
	}

	@Test
	public void objectIdentityEqualityIsTrueWhenReferringToSameObject() {
		Object objectReference = new Object();
		Object referenceToSameObject = objectReference;
		// does a new object == itself?
		assertEquals(objectReference == referenceToSameObject, __);
	}

	@Test
	public void subclassesEqualsMethodIsLooserThanDoubleEquals() {
		Integer integer0 = new Integer(0);
		Integer integer1 = new Integer(0);
		assertEquals(integer0.equals(integer1), __);
	}

	@Test
	public void doubleEqualsOperatorEvalutesToTrueOnlyWithSameInstance() {
		Integer integer0 = new Integer(0);
		Integer integer1 = integer0; // <- assigning same instance to different
										// reference
		assertEquals(integer0 == integer1, __);
	}

	@Test
	public void doubleEqualsOperatorEvalutesToFalseWithDifferentInstances() {
		Integer integer0 = new Integer(0);
		Integer integer1 = new Integer(0); // <- new keyword is generating new
											// object instance
		assertEquals(integer0 == integer1, __);
	}

	@Test
	public void objectToString() {
		Object object = new Object();
		// TODO: Why is it best practice to ALWAYS override toString?
		assertEquals((new StringBuilder()).append(Object.class.getName())
				.append('@').append(Integer.toHexString(object.hashCode()))
				.toString(), __); // object.toString()
	}

	@Test
	public void toStringConcatenates() {
		final String string = "ha";
		Object object = new Object() {
			@Override
			public String toString() {
				return string;
			}
		};
		assertEquals(string + object, __);
	}

	@Test
	public void toStringIsTestedForNullWhenInvokedImplicitly() {
		String string = "string";
		assertEquals(string + null, __);
	}

}
