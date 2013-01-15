package com.tora.koans;

import org.junit.Assert;

public final class ImplementationStub {
	public static final Object __ = new Object();

	public static void assertTrue(String message, Object condition) {
		if (condition == __) {
			throw new Error("Unimplemented test!");
		}
		try {
			Assert.assertTrue(message, (Boolean) condition);
		} catch (AssertionError e) {
			throw new AssertionError();
		}
	}

	public static void assertTrue(Object condition) {
		if (condition == __) {
			throw new Error("Unimplemented test!");
		}
		try {
			Assert.assertTrue((Boolean) condition);
		} catch (AssertionError e) {
			throw new AssertionError();
		}
	}

	public static void assertFalse(String message, Object condition) {
		if (condition == __) {
			throw new Error("Unimplemented test!");
		}
		try {
			Assert.assertFalse(message, (Boolean) condition);
		} catch (AssertionError e) {
			throw new AssertionError();
		}
	}

	public static void assertFalse(Object condition) {
		if (condition == __) {
			throw new Error("Unimplemented test!");
		}
		try {
			Assert.assertFalse((Boolean) condition);
		} catch (AssertionError e) {
			throw new AssertionError();
		}
	}

	public static void assertEquals(String message, Object expected,
			Object actual) {
		if (actual == __) {
			throw new Error("Unimplemented test!");
		}
		try {
			Assert.assertEquals(message, expected, actual);
		} catch (AssertionError e) {
			throw new AssertionError();
		}
	}

	public static void assertEquals(Object expected, Object actual) {
		if (actual == __) {
			throw new Error("Unimplemented test!");
		}
		try {
			Assert.assertEquals(expected, actual);
		} catch (AssertionError e) {
			throw new AssertionError();
		}
	}

	public static void assertEquals(String message, double expected,
			Object actual, double delta) {
		if (actual == __) {
			throw new Error("Unimplemented test!");
		}
		try {
			Assert.assertEquals(message, expected,
					((Number) actual).doubleValue(), delta);
		} catch (AssertionError e) {
			throw new AssertionError();
		}
	}

	public static void assertEquals(long expected, long actual) {
		try {
			Assert.assertEquals(expected, ((Number) actual).longValue());
		} catch (AssertionError e) {
			throw new AssertionError();
		}
	}

	public static void assertEquals(String message, long expected, long actual) {
		try {
			Assert.assertEquals(message, expected,
					((Number) actual).longValue());
		} catch (AssertionError e) {
			throw new AssertionError();
		}
	}

	@Deprecated
	public static void assertEquals(double expected, double actual) {
		try {
			Assert.assertEquals(expected, ((Number) actual).doubleValue());
		} catch (AssertionError e) {
			throw new AssertionError();
		}
	}

	@Deprecated
	public static void assertEquals(String message, double expected, double actual) {
		try {
			Assert.assertEquals(message, expected,
					((Number) actual).doubleValue());
		} catch (AssertionError e) {
			throw new AssertionError();
		}
	}

	public static void assertEquals(double expected, Object actual, double delta) {
		if (actual == __) {
			throw new Error("Unimplemented test!");
		}
		try {
			Assert.assertEquals(expected, ((Number) actual).doubleValue(),
					delta);
		} catch (AssertionError e) {
			throw new AssertionError();
		}
	}

	public static void assertNotNull(String message, Object object) {
		if (object == __) {
			throw new Error("Unimplemented test!");
		}
		try {
			Assert.assertNotNull(message, object);
		} catch (AssertionError e) {
			throw new AssertionError();
		}
	}

	public static void assertNotNull(Object object) {
		if (object == __) {
			throw new Error("Unimplemented test!");
		}
		try {
			Assert.assertNotNull(object);
		} catch (AssertionError e) {
			throw new AssertionError();
		}
	}

	public static void assertNull(String message, Object object) {
		if (object == __) {
			throw new Error("Unimplemented test!");
		}
		try {
			Assert.assertNull(message, object);
		} catch (AssertionError e) {
			throw new AssertionError();
		}
	}

	public static void assertNull(Object object) {
		if (object == __) {
			throw new Error("Unimplemented test!");
		}
		try {
			Assert.assertNull(object);
		} catch (AssertionError e) {
			throw new AssertionError();
		}
	}

	public static void assertSame(String message, Object expected, Object actual) {
		if (actual == __) {
			throw new Error("Unimplemented test!");
		}
		try {
			Assert.assertSame(message, expected, actual);
		} catch (AssertionError e) {
			throw new AssertionError();
		}
	}

	public static void assertSame(Object expected, Object actual) {
		if (actual == __) {
			throw new Error("Unimplemented test!");
		}
		try {
			Assert.assertSame(expected, actual);
		} catch (AssertionError e) {
			throw new AssertionError();
		}
	}

	public static void assertNotSame(String message, Object unexpected,
			Object actual) {
		if (actual == __) {
			throw new Error("Unimplemented test!");
		}
		try {
			Assert.assertNotSame(message, unexpected, actual);
		} catch (AssertionError e) {
			throw new AssertionError();
		}
	}

	public static void assertNotSame(Object unexpected, Object actual) {
		if (actual == __) {
			throw new Error("Unimplemented test!");
		}
		try {
			Assert.assertNotSame(unexpected, actual);
		} catch (AssertionError e) {
			throw new AssertionError();
		}
	}

	public static void fail(String message) {
		Assert.fail(message);
	}

	public static void fail() {
		Assert.fail();
	}
}
