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
		if (str.indexOf('x') == str.length() - 1) {
			return false;
		}
		return (str.charAt(str.indexOf('x') + 1) == 'x');
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
		int count = 0;
		for (int i = 0; i <= str.length() - 2; i++) {
			count += (str.charAt(i) == 'x' && str.charAt(i + 1) == 'x' ? 1 : 0);
		}
		
		return count;

	}

}
