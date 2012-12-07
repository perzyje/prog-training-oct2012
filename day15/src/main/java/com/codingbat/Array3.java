package com.codingbat;

public final class Array3 {
	/*
	 * http://codingbat.com/prob/p189576
	 * 
	 * Consider the leftmost and rightmost appearances of some value in an
	 * array. We'll say that the "span" is the number of elements between the
	 * two inclusive. A single value has a span of 1. Returns the largest span
	 * found in the given array. (Efficiency is not a priority.)
	 * 
	 * maxSpan({1, 2, 1, 1, 3}) → 4
	 * 
	 * maxSpan({1, 4, 2, 1, 4, 1, 4}) → 6
	 * 
	 * maxSpan({1, 4, 2, 1, 4, 4, 4}) → 6
	 */

	private int span(int[] nums, int current) {
		int i = nums.length - 1;
		while (i > current && nums[i] != nums[current]) {
			i--;
		}
		return i - current + 1;

	}

	public int maxSpan(int[] nums) {
		int max = 0;
		int spa = 0;
		for (int i = 0; i < nums.length; i++) {
			spa = span(nums, i);
			max = (max < spa) ? spa : max;
		}
		return max;
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

	private int findNext(int[] nums, int fi, int se) {
		int sta = 0;
		if (nums[0] == se) {
			return 0;
		}
		while (true) {
			while (sta < nums.length && nums[sta] != se) {
				sta++;
			}
			if (nums[sta - 1] != fi) {
				return sta;
			} else {
				sta++;
			}
		}
	}

	private int[] fixnm(int[] nums, int n, int m) {
		int tmp = 0;
		int aux;
		for (int i = 0; i < nums.length - 1; i++) {
			if (nums[i] == n && !(nums[i + 1] == m)) {
				tmp = findNext(nums, n, m);
				aux = nums[tmp];
				nums[tmp] = nums[i + 1];
				nums[i + 1] = aux;
			}
		}
		return nums;
	}

	public int[] fix34(int[] nums) {
		return fixnm(nums, 3, 4);
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
		return fixnm(nums, 4, 5);
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
		int s = 0;
		for (int n : nums) {
			s += n;
		}
		int l = 0;
		for (int n : nums) {
			l += n;
			if (s == 2 * l) {
				return true;
			}
			if (s < 2 * l) {
				return false;
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
		int iterI = 0;
		int iterO = 0;
		while (iterI < inner.length && iterO < outer.length) {
			if (outer[iterO] > inner[iterI]) {
				return false;
			} else if (outer[iterO] == inner[iterI]) {
				iterO++;
				iterI++;

			} else {
				iterO++;
			}
		}
		if (iterI == inner.length) {
			return true;
		}
		if (iterO >= outer.length) {
			return false;
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
		int[] res = new int[n * n];
		int lim = n;
		int upto = 1;
		for (int i = 0; i < n * n; i++) {
			if (lim <= upto) {
				res[i] = lim;
			}
			lim--;
			if (lim == 0) {
				lim = n;
				upto++;
			}
		}
		return res;
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
		int[] res = new int[n * (n + 1) / 2];
		int limsup = 1;
		int count = 1;
		for (int i = 0; i < n * (n + 1) / 2; i++) {
			res[i] = count;
			if (count == limsup) {
				count = 1;
				limsup++;
			} else {
				count++;
			}
		}
		return res;

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
		int clumps = 0;
		boolean lastSame = false;
		for (int i = 1; i < nums.length; i++) {
			if (nums[i] == nums[i - 1]) {
				if (!lastSame) {
					clumps++;
					lastSame = true;
				}
			} else {
				lastSame = false;
			}
		}
		return clumps;
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
		int[] rev = new int[nums.length];

		for (int i = 0; i < nums.length; i++) {
			rev[nums.length - i - 1] = nums[i];
		}
		int[][] matrix = new int[nums.length][nums.length];
		int maxNow = 0;
		for (int i = 0; i < nums.length; i++) {
			for (int j = 0; j < nums.length; j++) {
				if (nums[i] == rev[j]) {
					if (i == 0 || j == 0) {
						matrix[i][j] = 1;
					} else {
						matrix[i][j] = matrix[i - 1][j - 1] + 1;
					}
					if (matrix[i][j] > maxNow) {
						maxNow = matrix[i][j];
					}
				} else {
					matrix[i][j] = 0;
				}
			}
		}
		return maxNow;
	}

}
