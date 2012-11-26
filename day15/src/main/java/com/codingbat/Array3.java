package com.codingbat;

public final class Array3 {
	/*
	 * http://codingbat.com/prob/p189576
	 * 
	 * Consider the leftmost and righmost appearances of some value in an array.
	 * We'll say that the "span" is the number of elements between the two
	 * inclusive. A single value has a span of 1. Returns the largest span found
	 * in the given array. (Efficiency is not a priority.)
	 * 
	 * maxSpan({1, 2, 1, 1, 3}) → 4
	 * 
	 * maxSpan({1, 4, 2, 1, 4, 1, 4}) → 6
	 * 
	 * maxSpan({1, 4, 2, 1, 4, 4, 4}) → 6
	 */
	public int maxSpan(int[] nums) {
		int result = 0;
		for (int i = 0; i < nums.length; ++i) {
			for (int j = nums.length - 1; j >= 0; --j) {
				if (nums[i] == nums[j]) {
					result = Math.max(result, j - i + 1);
					break;
				}
			}
		}
		return result;
	}

	/*
	 * http://codingbat.com/prob/p159339
	 * 
	 * Return an array that contains exactly the same numbers as the given
	 * array, but rearranged so that every 3 is immediately followed by a 4. Do
	 * not move the 3's, but every other number may move. The array contains the
	 * same number of 3's and 4's, every 3 has a number after it that is not a 3
	 * or 4, and a 3 appears in the array before any 4.
	 * 
	 * fix34({1, 3, 1, 4}) → {1, 3, 4, 1}
	 * 
	 * fix34({1, 3, 1, 4, 4, 3, 1}) → {1, 3, 4, 1, 1, 3, 4}
	 * 
	 * fix34({3, 2, 2, 4}) → {3, 4, 2, 2}
	 */
	public int[] fix34(int[] nums) {
		int fours = 0;
		for (int i = 0; i < nums.length; ++i) {
			if (nums[i] != 3) {
				continue;
			}
			while (nums[fours] != 4) {
				fours++;
			}
			nums[fours] = nums[i + 1];
			nums[i + 1] = 4;
			fours++;
		}
		return nums;
	}

	/*
	 * http://codingbat.com/prob/p125819
	 * 
	 * (This is a slightly harder version of the fix34 problem.) Return an array
	 * that contains exactly the same numbers as the given array, but rearranged
	 * so that every 4 is immediately followed by a 5. Do not move the 4's, but
	 * every other number may move. The array contains the same number of 4's
	 * and 5's, and every 4 has a number after it that is not a 4. In this
	 * version, 5's may appear anywhere in the original array.
	 * 
	 * fix45({5, 4, 9, 4, 9, 5}) → {9, 4, 5, 4, 5, 9}
	 * 
	 * fix45({1, 4, 1, 5}) → {1, 4, 5, 1}
	 * 
	 * fix45({1, 4, 1, 5, 5, 4, 1}) → {1, 4, 5, 1, 1, 4, 5}
	 */
	public int[] fix45(int[] nums) {
		int[] result = new int[nums.length];
		for (int i = 0; i < nums.length; ++i) {
			if (nums[i] == 4) {
				result[i] = 4;
				result[i + 1] = 5;
			}
		}

		int j = 0;
		for (int i = 0; i < nums.length; ++i) {
			if (nums[i] == 4 || nums[i] == 5) {
				continue;
			}
			while (result[j] == 4 || result[j] == 5) {
				j++;
			}
			result[j] = nums[i];
			j++;
		}
		return result;
	}

	/*
	 * http://codingbat.com/prob/p158767
	 * 
	 * Given a non-empty array, return true if there is a place to split the
	 * array so that the sum of the numbers on one side is equal to the sum of
	 * the numbers on the other side.
	 * 
	 * canBalance({1, 1, 1, 2, 1}) → true
	 * 
	 * canBalance({2, 1, 1, 2, 1}) → false
	 * 
	 * canBalance({10, 10}) → true
	 */
	public boolean canBalance(int[] nums) {
		for (int i = 0; i < nums.length; ++i) {
			int s1 = 0;
			for (int j = 0; j < i; ++j) {
				s1 += nums[j];
			}
			int s2 = 0;
			for (int j = i; j < nums.length; ++j) {
				s2 += nums[j];
			}
			if (s1 == s2) {
				return true;
			}
		}

		return false;
	}

	/*
	 * http://codingbat.com/prob/p134022
	 * 
	 * Given two arrays of ints sorted in increasing order, outer and inner,
	 * return true if all of the numbers in inner appear in outer. The best
	 * solution makes only a single "linear" pass of both arrays, taking
	 * advantage of the fact that both arrays are already in sorted order.
	 * 
	 * linearIn({1, 2, 4, 6}, {2, 4}) → true
	 * 
	 * linearIn({1, 2, 4, 6}, {2, 3, 4}) → false
	 * 
	 * linearIn({1, 2, 4, 4, 6}, {2, 4}) → true
	 */
	public boolean linearIn(int[] outer, int[] inner) {
		for (int i : inner) {
			boolean found = false;
			for (int j : outer) {
				if (i == j) {
					found = true;
					break;
				}
			}
			if (!found) {
				return false;
			}
		}
		return true;
	}

	/*
	 * http://codingbat.com/prob/p155405
	 * 
	 * Given n>=0, create an array length n*n with the following pattern, shown
	 * here for n=3 : {0, 0, 1, 0, 2, 1, 3, 2, 1}
	 * 
	 * squareUp(3) → {0, 0, 1, 0, 2, 1, 3, 2, 1}
	 * 
	 * squareUp(2) → {0, 1, 2, 1}
	 * 
	 * squareUp(4) → {0, 0, 0, 1, 0, 0, 2, 1, 0, 3, 2, 1, 4, 3, 2, 1}
	 */
	public int[] squareUp(int n) {
		int[] result = new int[n * n];
		int k = 0;
		for (int i = 0; i < n; ++i) {
			int start = n - i - 1;
			for (int j = 0; j < n; ++j) {
				result[k++] = j < start ? 0 : n - j;
			}
		}
		return result;
	}

	/*
	 * http://codingbat.com/prob/p104090
	 * 
	 * Given n>=0, create an array with the pattern {1, 1, 2, 1, 2, 3, ... 1, 2,
	 * 3 .. n}. Note that the length of the array will be 1 + 2 + 3 ... + n,
	 * which is known to sum to exactly n*(n + 1)/2.
	 * 
	 * seriesUp(3) → {1, 1, 2, 1, 2, 3}
	 * 
	 * seriesUp(4) → {1, 1, 2, 1, 2, 3, 1, 2, 3, 4}
	 * 
	 * seriesUp(2) → {1, 1, 2}
	 */
	public int[] seriesUp(int n) {
		int[] result = new int[n * (n + 1) / 2];
		int k = 0;
		for (int i = 1; i <= n; ++i) {
			for (int j = 1; j <= i; ++j) {

				result[k++] = j;
			}
		}
		return result;
	}

	/*
	 * http://codingbat.com/prob/p193817
	 * 
	 * Say that a "clump" in an array is a series of 2 or more adjacent elements
	 * of the same value. Return the number of clumps in the given array.
	 * 
	 * countClumps({1, 2, 2, 3, 4, 4}) → 2
	 * 
	 * countClumps({1, 1, 2, 1, 1}) → 2
	 * 
	 * countClumps({1, 1, 1, 1, 1}) → 1
	 */
	public int countClumps(int[] nums) {
		int result = 0;
		for (int i = 0; i < nums.length; ++i) {
			int value = nums[i];
			int j = i;
			while (j < nums.length && nums[j] == value) {
				j++;
			}
			if (j - i > 1) {
				result += 1;
			}
			i = j - 1;
		}
		return result;
	}

	/*
	 * http://codingbat.com/prob/p196409
	 * 
	 * We'll say that a "mirror" section in an array is a group of contiguous
	 * elements such that somewhere in the array, the same group appears in
	 * reverse order. For example, the largest mirror section in {1, 2, 3, 8, 9,
	 * 3, 2, 1} is length 3 (the {1, 2, 3} part). Return the size of the largest
	 * mirror section found in the given array.
	 * 
	 * maxMirror({1, 2, 3, 8, 9, 3, 2, 1}) → 3
	 * 
	 * maxMirror({1, 2, 1, 4}) → 3
	 * 
	 * maxMirror({7, 1, 2, 9, 7, 2, 1}) → 2
	 */
	public int maxMirror(int[] nums) {
		if (nums.length < 2) {
			return nums.length;
		}
		int result = 0;
		for (int i = 0; i < nums.length; ++i) {
			for (int j = i + 1; j < nums.length; ++j) {
				int[] part = new int[j - i + 1];
				for (int k = 0; k < part.length; ++k) {
					part[part.length - k - 1] = nums[i + k];
				}

				for (int k = 0; k < nums.length; ++k) {
					int l = 0;
					while (l < part.length && k + l < nums.length) {
						if (nums[k + l] != part[l]) {
							break;
						}
						l++;
					}
					if (l == part.length) {
						result = Math.max(result, part.length);
						break;
					}
				}
			}
		}
		return result;
	}

}
