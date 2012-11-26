package com.codingbat;

public final class Array2 {
	/*
	 * http://codingbat.com/prob/p162010
	 * 
	 * Return the number of even ints in the given array. Note: the % "mod"
	 * operator computes the remainder, e.g. 5 % 2 is 1.
	 * 
	 * countEvens({2, 1, 2, 3, 4}) → 3
	 * 
	 * countEvens({2, 2, 0}) → 3
	 * 
	 * countEvens({1, 3, 5}) → 0
	 */
	public int countEvens(int[] nums) {
		int result = 0;
		for (int i : nums) {
			if (i % 2 == 0) {
				result += 1;
			}
		}
		return result;
	}

	/*
	 * http://codingbat.com/prob/p196640
	 * 
	 * Given an array length 1 or more of ints, return the difference between
	 * the largest and smallest values in the array. Note: the built-in
	 * Math.min(v1, v2) and Math.max(v1, v2) methods return the smaller or
	 * larger of two values.
	 * 
	 * bigDiff({10, 3, 5, 6}) → 7
	 * 
	 * bigDiff({7, 2, 10, 9}) → 8
	 * 
	 * bigDiff({2, 10, 7, 2}) → 8
	 */
	public int bigDiff(int[] nums) {
		int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
		for (int i : nums) {
			min = Math.min(min, i);
			max = Math.max(max, i);
		}
		return max - min;
	}

}
