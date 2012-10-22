package com.tora;

public final class SpaceOddity {
	
	//Utility classes should not have a public or default constructor.
	private SpaceOddity(){};
	
	public static boolean isOdd(long value) {
		return value % 2 != 0;
	}
}
