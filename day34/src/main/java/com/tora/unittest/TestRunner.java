package com.tora.unittest;

import java.util.*;
import java.lang.reflect.*;

public final class TestRunner {
	private int tests = 0;
	private int succes = 0;
	private int failures = 0;
	private int errors = 0;

	public void run(Class<?> clazz) throws Exception {
	}

	public int getTestsRun() {
		return tests;
	}

	public int getTestsSuccess() {
		return succes;
	}

	public int getTestsFailures() {
		return failures;
	}

	public int getTestsErrors() {
		return errors;
	}

}
