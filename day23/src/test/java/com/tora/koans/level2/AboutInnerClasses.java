package com.tora.koans.level2;

import org.junit.*;
import static com.tora.koans.ImplementationStub.*;

public class AboutInnerClasses {

	interface Ignoreable {
		String ignoreAll();
	}

	class Inner {
		private int inner;

		public String doStuff() {
			return "stuff";
		}

		public int returnOuter() {
			return x;
		}

		public int returnInner() {
			return inner;
		}

		public void setInner(int inner) {
			this.inner = inner;
		}

		public void setOuter(int x) {
			AboutInnerClasses.this.x = x;
		}
	}

	@Test
	public void creatingInnerClassInstance() {
		Inner someObject = new Inner();
		assertEquals(someObject.doStuff(), __);
	}

	@Test
	public void creatingInnerClassInstanceWithOtherSyntax() {
		AboutInnerClasses.Inner someObject = this.new Inner();
		assertEquals(someObject.doStuff(), __);
	}

	private int x;

	@Test
	public void accessingOuterClassMembers() {
		Inner someObject = new Inner();
		assertEquals(someObject.returnOuter(), __);
	}

	@Test
	public void fieldValuesStorage() {
		Inner someObject = new Inner(), someOtherObject = new Inner();

		someObject.setInner(1);
		someObject.setOuter(2);
		someOtherObject.setInner(3);
		someOtherObject.setOuter(4);

		assertEquals(someObject.returnOuter(), __);
		assertEquals(someObject.returnInner(), __);
		assertEquals(someOtherObject.returnOuter(), __);
		assertEquals(someOtherObject.returnInner(), __);
	}

	@Test
	public void innerClassesInMethods() {
		class MethodInnerClass {
			int oneHundred() {
				return 100;
			}
		}
		assertEquals(new MethodInnerClass().oneHundred(), __);
		// Where can you use this class?
	}

	class AnotherInnerClass {
		int thousand() {
			return 1000;
		}

		AnotherInnerClass crazyReturn() {
			class SpecialInnerClass extends AnotherInnerClass {
				int thousand() {
					return 2000;
				}
			}
			;
			return new SpecialInnerClass();
		}
	}

	@Test
	public void innerClassesInMethodsThatEscape() {
		AnotherInnerClass ic = new AnotherInnerClass();
		assertEquals(ic.thousand(), __);
		AnotherInnerClass theCrazyIC = ic.crazyReturn();
		assertEquals(theCrazyIC.thousand(), __);
	}

	int theAnswer() {
		return 42;
	}

	@Test
	public void creatingAnonymousInnerClasses() {
		AboutInnerClasses anonymous = new AboutInnerClasses() {
			int theAnswer() {
				return 23;
			}
		};// <- Why do you need a semicolon here?
		assertEquals(anonymous.theAnswer(), __);
	}

	@Test
	public void creatingAnonymousInnerClassesToImplementInterface() {
		Ignoreable ignoreable = new Ignoreable() {
			public String ignoreAll() {
				return null;
			}
		}; // Complete the code so that the statement below is correct.
			// Look at the koan above for inspiration
		assertEquals(ignoreable.ignoreAll(), "SomeInterestingString");
		// Did you just created an object of an interface type?
		// Or did you create a class that implemented this interface and
		// an object of that type?
	}

	@Test
	public void innerClassAndInheritance() {
		Inner someObject = new Inner();
		// The statement below is obvious...
		// Try to change the 'Inner' below to "AboutInnerClasses'
		// Why do you get an error?
		// What does that imply for inner classes and inheritance?
		assertEquals(someObject instanceof Inner, __);
	}

	class OtherInner extends AboutInnerClasses {
	}

	@Test
	public void innerClassAndInheritanceOther() {
		OtherInner someObject = new OtherInner();
		// What do you expect here?
		// Compare this result with the last koan. What does that mean?
		assertEquals(someObject instanceof AboutInnerClasses, __);
	}

	static class StaticInnerClass {
		public int importantNumber() {
			return 3;
		}
	}

	@Test
	public void staticInnerClass() {
		StaticInnerClass someObject = new StaticInnerClass();
		assertEquals(someObject.importantNumber(), __);
		// What happens if you try to access 'x' or 'theAnswer' from the outer
		// class?
		// What does this mean for static inner classes?
		// Try to create a sub package of this package which is named
		// 'StaticInnerClass'
		// Does it work? Why not?
	}

	@Test
	public void staticInnerClassFullyQualified() {
		AboutInnerClasses.StaticInnerClass someObject = new AboutInnerClasses.StaticInnerClass();
		assertEquals(someObject.importantNumber(), __);
	}

	@Before
	public void setUp() {
		this.x = 10;
	}
}
