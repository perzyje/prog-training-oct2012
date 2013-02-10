package com.tora.unittest;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public final class TestRunnerTest {
	private static int counter = 0;
	private TestRunner testRunner;

	static class TestSimpleRun {
		@com.tora.unittest.Test
		public void simpleTest() {
			assertTrue(true);
		}
	};

	@Test
	public void testSimpleRun() throws Exception {
		testRunner.run(TestSimpleRun.class);
		assertEquals(1, testRunner.getTestsRun());
		assertEquals(1, testRunner.getTestsSuccess());
		assertEquals(0, testRunner.getTestsFailures());
		assertEquals(0, testRunner.getTestsErrors());
	}
	
	static class TestAssertionError {
		@com.tora.unittest.Test
		public void simpleTest() {
			assertTrue(false);
		}
	};
	
	@Test
	public void testAssertionError() throws Exception {
		testRunner.run(TestAssertionError.class);
		assertEquals(1, testRunner.getTestsRun());
		assertEquals(0, testRunner.getTestsSuccess());
		assertEquals(1, testRunner.getTestsFailures());
		assertEquals(0, testRunner.getTestsErrors());
	}
	
	static class TestException {
		@com.tora.unittest.Test
		public void simpleTest() {
			throw null;
		}
	};
	
	@Test
	public void testException() throws Exception {
		testRunner.run(TestException.class);
		assertEquals(1, testRunner.getTestsRun());
		assertEquals(0, testRunner.getTestsSuccess());
		assertEquals(0, testRunner.getTestsFailures());
		assertEquals(1, testRunner.getTestsErrors());
	}
	
	static class TestExpectedException {
		@com.tora.unittest.Test(expected=NullPointerException.class)
		public void simpleTest() {
			throw null;
		}
	};
	
	@Test
	public void testExpectedException() throws Exception {
		testRunner.run(TestExpectedException.class);
		assertEquals(1, testRunner.getTestsRun());
		assertEquals(1, testRunner.getTestsSuccess());
		assertEquals(0, testRunner.getTestsFailures());
		assertEquals(0, testRunner.getTestsErrors());
	}
	
	static class TestUnexpectedException {
		@com.tora.unittest.Test(expected=NullPointerException.class)
		public void simpleTest() {
			throw new ArithmeticException();
		}
	};
	
	@Test
	public void testUnexpectedException() throws Exception {
		testRunner.run(TestUnexpectedException.class);
		assertEquals(1, testRunner.getTestsRun());
		assertEquals(0, testRunner.getTestsSuccess());
		assertEquals(1, testRunner.getTestsFailures());
		assertEquals(0, testRunner.getTestsErrors());
	}
	
	static class TestNoExpectedException {
		@com.tora.unittest.Test(expected=NullPointerException.class)
		public void simpleTest() {
		}
	};
	
	@Test
	public void testNoExpectedException() throws Exception {
		testRunner.run(TestNoExpectedException.class);
		assertEquals(1, testRunner.getTestsRun());
		assertEquals(0, testRunner.getTestsSuccess());
		assertEquals(1, testRunner.getTestsFailures());
		assertEquals(0, testRunner.getTestsErrors());
	}
	
	static class TestBeforeExecuted {
		@com.tora.unittest.Before()
		public void setUp() {
			counter += 1;
		}
		
		@com.tora.unittest.Test()
		public void simpleTest() {
			assertTrue(true);
		}
		
		@com.tora.unittest.Test()
		public void simpleTest2() {
			assertTrue(true);
		}
	};
	
	@Test
	public void testBeforeExecuted() throws Exception {
		testRunner.run(TestBeforeExecuted.class);
		assertEquals(2, counter);
	}
	
	static class TestAfterExecuted {
		@com.tora.unittest.After()
		public void tearDown() {
			counter += 1;
		}
		
		@com.tora.unittest.Test()
		public void simpleTest() {
			assertTrue(true);
		}
		
		@com.tora.unittest.Test()
		public void simpleTest2() {
			assertTrue(true);
		}
	};
	
	@Test
	public void testAfterExecuted() throws Exception {
		testRunner.run(TestAfterExecuted.class);
		assertEquals(2, counter);
	}

	static class TestBeforeClassExecuted {
		@com.tora.unittest.BeforeClass()
		public static void setUp() {
			counter += 1;
		}
		
		@com.tora.unittest.Test()
		public void simpleTest() {
			assertTrue(true);
		}
		
		@com.tora.unittest.Test()
		public void simpleTest2() {
			assertTrue(true);
		}
	};
	
	@Test
	public void testBeforeClassExecuted() throws Exception {
		testRunner.run(TestBeforeClassExecuted.class);
		assertEquals(1, counter);
	}
	
	static class TestAfterClassExecuted {
		@com.tora.unittest.AfterClass()
		public static void tearDown() {
			counter += 1;
		}
		
		@com.tora.unittest.Test()
		public void simpleTest() {
			assertTrue(true);
		}
		
		@com.tora.unittest.Test()
		public void simpleTest2() {
			assertTrue(true);
		}
	};
	
	@Test
	public void testAfterClassExecuted() throws Exception {
		testRunner.run(TestAfterClassExecuted.class);
		assertEquals(1, counter);
	}

	static class TestErrorIfNoTestMethods {};
	
	@Test(expected=Exception.class)
	public void testErrorIfNoTestMethods() throws Exception {
		testRunner.run(TestErrorIfNoTestMethods.class);
	}

	static class TestInheritedTestsExecutedParent {
		@com.tora.unittest.Test()
		public void simpleTest() {
			assertTrue(true);
		}
	};

	static class TestInheritedTestsExecutedChild extends TestInheritedTestsExecutedParent {
		@com.tora.unittest.Test()
		public void simpleTest2() {
			assertTrue(true);
		}
	};

	@Test
	public void testInheritedTestsExecuted() throws Exception {
		testRunner.run(TestInheritedTestsExecutedChild.class);
		assertEquals(2, testRunner.getTestsRun());
		assertEquals(2, testRunner.getTestsSuccess());
	}

	static class TestExceptionInBeforeIsFailure {
		@com.tora.unittest.Before()
		public void setUp() {
			throw null;
		}
		
		@com.tora.unittest.Test()
		public void simpleTest() {
			assertTrue(true);
		}
	};
	
	@Test
	public void testExceptionInBeforeIsFailure() throws Exception {
		testRunner.run(TestExceptionInBeforeIsFailure.class);
		assertEquals(1, testRunner.getTestsRun());
		assertEquals(1, testRunner.getTestsFailures());
	}

	static class TestExceptionInAfterIsIgnored {
		@com.tora.unittest.After()
		public void setUp() {
			throw null;
		}
		
		@com.tora.unittest.Test()
		public void simpleTest() {
			assertTrue(true);
		}
	};
	
	@Test
	public void testExceptionInAfterIsIgnored() throws Exception {
		testRunner.run(TestExceptionInAfterIsIgnored.class);
		assertEquals(1, testRunner.getTestsRun());
		assertEquals(1, testRunner.getTestsSuccess());
	}
	
	@Before
	public void setUp() {
		counter = 0;
		testRunner = new TestRunner();
	}
}
