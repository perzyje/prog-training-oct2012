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

	/*
	 * http://codingbat.com/prob/p136585
	 * 
	 * Return the "centered" average of an array of ints, which we'll say is the
	 * mean average of the values, except ignoring the largest and smallest
	 * values in the array. If there are multiple copies of the smallest value,
	 * ignore just one copy, and likewise for the largest value. Use int
	 * division to produce the final average. You may assume that the array is
	 * length 3 or more.
	 * 
	 * centeredAverage({1, 2, 3, 4, 100}) → 3
	 * 
	 * centeredAverage({1, 1, 5, 5, 10, 8, 7}) → 5
	 * 
	 * centeredAverage({-10, -4, -2, -4, -2, 0}) → -3
	 */
	public int centeredAverage(int[] nums) {
		java.util.Arrays.sort(nums);
		int sum = 0;
		for (int i = 1; i < nums.length - 1; ++i) {
			sum += nums[i];
		}
		return sum / (nums.length - 2);
	}

	/*
	 * http://codingbat.com/prob/p127384
	 * 
	 * Return the sum of the numbers in the array, returning 0 for an empty
	 * array. Except the number 13 is very unlucky, so it does not count and
	 * numbers that come immediately after a 13 also do not count.
	 * 
	 * sum13({1, 2, 2, 1}) → 6
	 * 
	 * sum13({1, 1}) → 2
	 * 
	 * sum13({1, 2, 2, 1, 13}) → 6
	 */
	public int sum13(int[] nums) {
		int sum = 0;
		for (int i = 0; i < nums.length; ++i) {
			if (nums[i] == 13) {
				++i;
				continue;
			}
			sum += nums[i];
		}
		return sum;
	}

	/*
	 * http://codingbat.com/prob/p111327
	 * 
	 * Return the sum of the numbers in the array, except ignore sections of
	 * numbers starting with a 6 and extending to the next 7 (every 6 will be
	 * followed by at least one 7). Return 0 for no numbers.
	 * 
	 * sum67({1, 2, 2}) → 5
	 * 
	 * sum67({1, 2, 2, 6, 99, 99, 7}) → 5
	 * 
	 * sum67({1, 1, 6, 7, 2}) → 4
	 */
	public int sum67(int[] nums) {
		int sum = 0;
		for (int i = 0; i < nums.length; ++i) {
			if (nums[i] == 6) {
				while (i < nums.length && nums[i] != 7) {
					++i;
				}
				continue;
			}
			sum += nums[i];
		}
		return sum;

	}

	/*
	 * http://codingbat.com/prob/p121853
	 * 
	 * Given an array of ints, return true if the array contains a 2 next to a 2
	 * somewhere.
	 * 
	 * has22({1, 2, 2}) → true
	 * 
	 * has22({1, 2, 1, 2}) → false
	 * 
	 * has22({2, 1, 2}) → false
	 */
	public boolean has22(int[] nums) {
		for (int i = 0; i < nums.length - 1; ++i) {
			if (nums[i] == 2 && nums[i + 1] == 2) {
				return true;
			}
		}
		return false;
	}

	/*
	 * http://codingbat.com/prob/p194525
	 * 
	 * Given an array of ints, return true if the array contains no 1's and no
	 * 3's.
	 * 
	 * lucky13({0, 2, 4}) → true
	 * 
	 * lucky13({1, 2, 3}) → false
	 * 
	 * lucky13({1, 2, 4}) → false
	 */
	public boolean lucky13(int[] nums) {
		for (int i : nums) {
			if (i == 1 || i == 3) {
				return false;
			}

		}
		return true;
	}

	/*
	 * http://codingbat.com/prob/p199612
	 * 
	 * Given an array of ints, return true if the sum of all the 2's in the
	 * array is exactly 8.
	 * 
	 * sum28({2, 3, 2, 2, 4, 2}) → true
	 * 
	 * sum28({2, 3, 2, 2, 4, 2, 2}) → false
	 * 
	 * sum28({1, 2, 3, 4}) → false
	 */
	public boolean sum28(int[] nums) {
		int sum = 0;
		for (int i : nums) {
			if (i == 2) {
				sum += 2;
			}
		}
		return sum == 8;
	}

	/*
	 * http://codingbat.com/prob/p104627
	 * 
	 * Given an array of ints, return true if the number of 1's is greater than
	 * the number of 4's
	 * 
	 * more14({1, 4, 1}) → true
	 * 
	 * more14({1, 4, 1, 4}) → false
	 * 
	 * more14({1, 1}) → true
	 */
	public boolean more14(int[] nums) {
		int ones = 0, fours = 0;
		for (int i : nums) {
			switch (i) {
			case 1:
				ones++;
				break;
			case 4:
				fours++;
				break;
			}
		}
		return ones > fours;
	}

	/*
	 * http://codingbat.com/prob/p186672
	 * 
	 * Given an array of ints, return true if every element is a 1 or a 4.
	 * 
	 * only14({1, 4, 1, 4}) → true
	 * 
	 * only14({1, 4, 2, 4}) → false
	 * 
	 * only14({1, 1}) → true
	 */
	public boolean only14(int[] nums) {
		for (int i : nums) {
			switch (i) {
			case 1:
			case 4:
				continue;
			default:
				return false;
			}
		}
		return true;
	}

	/*
	 * http://codingbat.com/prob/p136648
	 * 
	 * Given an array of ints, return true if it contains no 1's or it contains
	 * no 4's.
	 * 
	 * no14({1, 2, 3}) → true
	 * 
	 * no14({1, 2, 3, 4}) → false
	 * 
	 * no14({2, 3, 4}) → true
	 */
	public boolean no14(int[] nums) {
		int ones = 0, fours = 0;
		for (int i : nums) {
			switch (i) {
			case 1:
				ones++;
				break;
			case 4:
				fours++;
				break;
			}
		}
		return ones == 0 || fours == 0;
	}

	/*
	 * http://codingbat.com/prob/p110222
	 * 
	 * We'll say that a value is "everywhere" in an array if for every pair of
	 * adjacent elements in the array, at least one of the pair is that value.
	 * Return true if the given value is everywhere in the array.
	 * 
	 * isEverywhere({1, 2, 1, 3}, 1) → true
	 * 
	 * isEverywhere({1, 2, 1, 3}, 2) → false
	 * 
	 * isEverywhere({1, 2, 1, 3, 4}, 1) → false
	 */
	public boolean isEverywhere(int[] nums, int val) {
		for (int i = 0; i < nums.length - 1; ++i) {
			if (nums[i] != val && nums[i + 1] != val) {
				return false;
			}
		}
		return true;
	}

	/*
	 * http://codingbat.com/prob/p191878
	 * 
	 * Given an array of ints, return true if the array contains a 2 next to a 2
	 * or a 4 next to a 4, but not both.
	 * 
	 * either24({1, 2, 2}) → true
	 * 
	 * either24({4, 4, 1}) → true
	 * 
	 * either24({4, 4, 1, 2, 2}) → false
	 */
	public boolean either24(int[] nums) {
		boolean adjTwos = false, adjFours = false;
		for (int i = 0; i < nums.length - 1; ++i) {
			if (nums[i] == 2 && nums[i + 1] == 2) {
				adjTwos = true;
			}
			if (nums[i] == 4 && nums[i + 1] == 4) {
				adjFours = true;
			}
		}
		return adjTwos ^ adjFours;
	}

	/*
	 * http://codingbat.com/prob/p136254
	 * 
	 * Given arrays nums1 and nums2 of the same length, for every element in
	 * nums1, consider the corresponding element in nums2 (at the same index).
	 * Return the count of the number of times that the two elements differ by 2
	 * or less, but are not equal.
	 * 
	 * matchUp({1, 2, 3}, {2, 3, 10}) → 2
	 * 
	 * matchUp({1, 2, 3}, {2, 3, 5}) → 3
	 * 
	 * matchUp({1, 2, 3}, {2, 3, 3}) → 2
	 */
	public int matchUp(int[] nums1, int[] nums2) {
		int count = 0;
		assert nums1.length == nums2.length;
		for (int i = 0; i < nums1.length; ++i) {
			if (nums1[i] == nums2[i]) {
				continue;
			}
			if (Math.abs(nums1[i] - nums2[i]) <= 2) {
				count += 1;
			}
		}
		return count;
	}

	/*
	 * http://codingbat.com/prob/p168357
	 * 
	 * Given an array of ints, return true if the array contains two 7's next to
	 * each other, or there are two 7's separated by one element, such as with
	 * {7, 1, 7}.
	 * 
	 * has77({1, 7, 7}) → true
	 * 
	 * has77({1, 7, 1, 7}) → true
	 * 
	 * has77({1, 7, 1, 1, 7}) → false
	 */
	public boolean has77(int[] nums) {
		for (int i = 0; i < nums.length - 1; ++i) {
			if (nums[i] != 7) {
				continue;
			}
			if (nums[i + 1] == 7) {
				return true;
			}
			if (i + 2 < nums.length && nums[i + 2] == 7) {
				return true;
			}
		}
		return false;
	}

	/*
	 * http://codingbat.com/prob/p169260
	 * 
	 * Given an array of ints, return true if there is a 1 in the array with a 2
	 * somewhere later in the array.
	 * 
	 * has12({1, 3, 2}) → true
	 * 
	 * has12({3, 1, 2}) → true
	 * 
	 * has12({3, 1, 4, 5, 2}) → true
	 */
	public boolean has12(int[] nums) {
		boolean oneFound = false;
		for (int i : nums) {
			switch (i) {
			case 1:
				oneFound = true;
				break;
			case 2:
				if (oneFound) {
					return true;
				}
				break;
			}
		}
		return false;
	}

	/*
	 * http://codingbat.com/prob/p159979
	 * 
	 * Given an array of ints, return true if the array contains either 3 even
	 * or 3 odd values all next to each other.
	 * 
	 * modThree({2, 1, 3, 5}) → true
	 * 
	 * modThree({2, 1, 2, 5}) → false
	 * 
	 * modThree({2, 4, 2, 5}) → true
	 */
	public boolean modThree(int[] nums) {
		for (int i = 0; i < nums.length - 2; ++i) {
			if (nums[i] % 2 != 0 && nums[i + 1] % 2 != 0
					&& nums[i + 2] % 2 != 0) {
				return true;
			}
			if (nums[i] % 2 == 0 && nums[i + 1] % 2 == 0
					&& nums[i + 2] % 2 == 0) {
				return true;
			}
		}
		return false;
	}

}
