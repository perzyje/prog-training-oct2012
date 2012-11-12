package com.codingbat;

public final class WarmUp2 {
	/*
	 * http://codingbat.com/prob/p186759
	 * 
	 * Given a string, return true if the first instance of "x" in the string is
	 * immediately followed by another "x".
	 * 
	 * doubleX("axxbb") → true
	 * 
	 * doubleX("axaxax") → false
	 * 
	 * doubleX("xxxxx") → true
	 */
	boolean doubleX(String str) {
		int start = str.indexOf("x");
		if (start < 0) {
			return false;
		}
		return start == str.indexOf("xx");
	}

	/*
	 * http://codingbat.com/prob/p194667
	 * 
	 * Count the number of "xx" in the given string. We'll say that overlapping
	 * is allowed, so "xxx" contains 2 "xx".
	 * 
	 * countXX("abcxx") → 1
	 * 
	 * countXX("xxx") → 2
	 * 
	 * countXX("xxxx") → 3
	 */
	int countXX(String str) {
		int i = 0, result = 0;
		while (i < str.length()) {
			int j = str.indexOf("xx", i);
			if (j < 0) {
				break;
			}
			result++;
			i = j + 1;
		}
		return result;
	}

}
