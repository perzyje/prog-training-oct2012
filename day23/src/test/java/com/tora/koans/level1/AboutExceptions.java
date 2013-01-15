package com.tora.koans.level1;

import org.junit.*;
import java.io.IOException;
import static com.tora.koans.ImplementationStub.*;

public final class AboutExceptions {

	private void doSutff() throws IOException {
		throw new IOException();
	}

	@Test
	public void catchCheckedExceptions() {
		String s;
		try {
			doSutff();
			s = "code run normally";
		} catch (IOException e) {
			s = "exception thrown";
		}
		assertEquals(s, __);
	}

	@Test
	public void useFinally() {
		String s = "";
		try {
			doSutff();
			s = "code run normally";
		} catch (IOException e) {
			s = "exception thrown";
		} finally {
			s += " and finally ran as well";
		}
		assertEquals(s, __);
	}

	@Test
	public void finallyWithoutCatch() {
		String s = "";
		try {
			s = "code run normally";
		} finally {
			s += " and finally ran as well";
		}
		assertEquals(s, __);
	}

	private void doUncheckedStuff() {
		throw new RuntimeException();
	}

	@Test
	public void catchUncheckedExceptions() {
		// What do you need to do to catch the unchecked exception?
		doUncheckedStuff();
	}

	@SuppressWarnings("serial")
	static class ParentException extends Exception {
	}

	@SuppressWarnings("serial")
	static class ChildException extends ParentException {
	}

	private void throwIt() throws ParentException {
		throw new ChildException();
	}

	@Test
	public void catchOrder() {
		String s = "";
		try {
			throwIt();
		} catch (ChildException e) {
			s = "ChildException";
		} catch (ParentException e) {
			s = "ParentException";
		}
		assertEquals(s, __);
	}
}
