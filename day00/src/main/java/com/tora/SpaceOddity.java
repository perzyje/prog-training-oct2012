package com.tora;


public final class SpaceOddity {
	private SpaceOddity() {
		throw new AssertionError("Should not be called!");
	}
	
	public static boolean isOdd(long value) {
		return Math.abs(value) % 2 == 1;
	}
}
