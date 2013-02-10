package com.tora.unittest;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target({ ElementType.METHOD })
public @interface Test {
	static class None extends Throwable {
		private static final long serialVersionUID = 1L;

		private None() {
		}
	}

	Class<? extends Throwable> expected() default None.class;
}
