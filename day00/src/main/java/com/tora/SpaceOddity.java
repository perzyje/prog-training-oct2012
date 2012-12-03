package com.tora;

public final class SpaceOddity {
	private SpaceOddity() {
		throw new AssertionError("This should not be call!");
	}

	public static boolean isOdd(long value) {
		return value % 2 != 0;
	}

	public static void main(String[] args) {
	}
}
