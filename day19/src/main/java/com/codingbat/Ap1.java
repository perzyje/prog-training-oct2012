package com.codingbat;

import java.util.*;

final class Ap1 {
	/*
	 * http://codingbat.com/prob/p146974
	 * 
	 * Given an array of scores, return true if each score is equal or greater
	 * than the one before. The array will be length 2 or more.
	 * 
	 * scoresIncreasing({1, 3, 4}) → true
	 * 
	 * scoresIncreasing({1, 3, 2}) → false
	 * 
	 * scoresIncreasing({1, 1, 4}) → true
	 */
	public boolean scoresIncreasing(int[] scores) {
		int last = Integer.MIN_VALUE;
		for (int i : scores) {
			if (i < last) {
				return false;
			}
			last = i;
		}
		return true;
	}

	/*
	 * http://codingbat.com/prob/p179487
	 * 
	 * Given an array of scores, return true if there are scores of 100 next to
	 * each other in the array. The array length will be at least 2.
	 * 
	 * scores100({1, 100, 100}) → true
	 * 
	 * scores100({1, 100, 99, 100}) → false
	 * 
	 * scores100({100, 1, 100, 100}) → true
	 */
	public boolean scores100(int[] scores) {
		for (int i = 0; i < scores.length - 1; ++i) {
			if (scores[i] == 100 && scores[i + 1] == 100) {
				return true;
			}
		}
		return false;
	}

	/*
	 * http://codingbat.com/prob/p194530
	 * 
	 * Given an array of scores sorted in increasing order, return true if the
	 * array contains 3 adjacent scores that differ from each other by at most
	 * 2, such as with {3, 4, 5} or {3, 5, 5}.
	 * 
	 * scoresClump({3, 4, 5}) → true
	 * 
	 * scoresClump({3, 4, 6}) → false
	 * 
	 * scoresClump({1, 3, 5, 5}) → true
	 */
	public boolean scoresClump(int[] scores) {
		for (int i = 0; i < scores.length - 2; ++i) {
			if (Math.abs(scores[i] - scores[i + 1]) <= 2
					&& Math.abs(scores[i] - scores[i + 2]) <= 2) {
				return true;
			}
		}

		return false;
	}

	/*
	 * Given an array of scores, compute the int average of the first half and
	 * the second half, and return whichever is larger. We'll say that the
	 * second half begins at index length/2. The array length will be at least
	 * 2. To practice decomposition, write a separate helper method
	 * 
	 * int average(int[] scores, int start, int end) {
	 * 
	 * which computes the average of the elements between indexes start..end.
	 * Call your helper method twice to implement scoresAverage(). Write your
	 * helper method after your scoresAverage() method in the JavaBat text area.
	 * Normally you would compute averages with doubles, but here we use ints so
	 * the expected results are exact.
	 * 
	 * scoresAverage({2, 2, 4, 4}) → 4
	 * 
	 * scoresAverage({4, 4, 4, 2, 2, 2}) → 4
	 * 
	 * scoresAverage({3, 4, 5, 1, 2, 3}) → 4
	 */
	public int scoresAverage(int[] scores) {
		return Math.max(average(scores, 0, scores.length / 2),
				average(scores, scores.length / 2, scores.length));
	}

	private int average(int[] scores, int start, int end) {
		int result = 0;
		for (int i = start; i < end; ++i) {
			result += scores[i];
		}
		return result / (end - start);
	}

	/*
	 * http://codingbat.com/prob/p124620
	 * 
	 * Given an array of strings, return the count of the number of strings with
	 * the given length.
	 * 
	 * wordsCount({"a", "bb", "b", "ccc"}, 1) → 2
	 * 
	 * wordsCount({"a", "bb", "b", "ccc"}, 3) → 1
	 * 
	 * wordsCount({"a", "bb", "b", "ccc"}, 4) → 0
	 */
	public int wordsCount(String[] words, int len) {
		int result = 0;
		for (String word : words) {
			if (word.length() == len) {
				result++;
			}
		}
		return result;
	}

	/*
	 * http://codingbat.com/prob/p183837
	 * 
	 * Given an array of strings, return a new array containing the first N
	 * strings. N will be in the range 1..length.
	 * 
	 * wordsFront({"a", "b", "c", "d"}, 1) → {"a"}
	 * 
	 * wordsFront({"a", "b", "c", "d"}, 2) → {"a", "b"}
	 * 
	 * wordsFront({"a", "b", "c", "d"}, 3) → {"a", "b", "c"}
	 */
	public String[] wordsFront(String[] words, int n) {
		String[] result = new String[n];
		for (int i = 0; i < n; ++i) {
			result[i] = words[i];
		}
		return result;
	}

	/*
	 * http://codingbat.com/prob/p183407
	 * 
	 * Given an array of strings, return a new List (e.g. an ArrayList) where
	 * all the strings of the given length are omitted. See wordsWithout() below
	 * which is more difficult because it uses arrays.
	 * 
	 * wordsWithoutList({"a", "bb", "b", "ccc"}, 1) → {"bb", "ccc"}
	 * 
	 * wordsWithoutList({"a", "bb", "b", "ccc"}, 3) → {"a", "bb", "b"}
	 * 
	 * wordsWithoutList({"a", "bb", "b", "ccc"}, 4) → {"a", "bb", "b", "ccc"}
	 */
	public List<String> wordsWithoutList(String[] words, int len) {
		List<String> result = new ArrayList<String>(words.length);
		for (String word : words) {
			if (word.length() != len) {
				result.add(word);
			}
		}
		return result;
	}

	/*
	 * http://codingbat.com/prob/p191212
	 * 
	 * Given a positive int n, return true if it contains a 1 digit. Note: use %
	 * to get the rightmost digit, and / to discard the rightmost digit.
	 * 
	 * hasOne(10) → true
	 * 
	 * hasOne(22) → false
	 * 
	 * hasOne(220) → false
	 */
	public boolean hasOne(int n) {
		return Integer.toString(n).contains("1");
	}

	/*
	 * http://codingbat.com/prob/p165941
	 * 
	 * We'll say that a positive int divides itself if every digit in the number
	 * divides into the number evenly. So for example 128 divides itself since
	 * 1, 2, and 8 all divide into 128 evenly. We'll say that 0 does not divide
	 * into anything evenly, so no number with a 0 digit divides itself. Note:
	 * use % to get the rightmost digit, and / to discard the rightmost digit.
	 * 
	 * dividesSelf(128) → true
	 * 
	 * dividesSelf(12) → true
	 * 
	 * dividesSelf(120) → false
	 */
	public boolean dividesSelf(int n) {
		for (char d : Integer.toString(n).toCharArray()) {
			if (d == '0') {
				return false;
			}
			if (n % Integer.valueOf(String.valueOf(d)) != 0) {
				return false;
			}
		}
		return true;
	}

	/*
	 * http://codingbat.com/prob/p134174
	 * 
	 * Given an array of positive ints, return a new array of length "count"
	 * containing the first even numbers from the original array. The original
	 * array will contain at least "count" even numbers.
	 * 
	 * copyEvens({3, 2, 4, 5, 8}, 2) → {2, 4}
	 * 
	 * copyEvens({3, 2, 4, 5, 8}, 3) → {2, 4, 8}
	 * 
	 * copyEvens({6, 1, 2, 4, 5, 8}, 3) → {6, 2, 4}
	 */
	public int[] copyEvens(int[] nums, int count) {
		int[] result = new int[count];
		int i = 0;
		for (int num : nums) {
			if (num % 2 != 0) {
				continue;
			}
			result[i++] = num;
			if (i >= count) {
				break;
			}
		}
		return result;
	}

	/*
	 * http://codingbat.com/prob/p130124
	 * 
	 * We'll say that a positive int n is "endy" if it is in the range 0..10 or
	 * 90..100 (inclusive). Given an array of positive ints, return a new array
	 * of length "count" containing the first endy numbers from the original
	 * array. Decompose out a separate isEndy(int n) method to test if a number
	 * is endy. The original array will contain at least "count" endy numbers.
	 * 
	 * copyEndy({9, 11, 90, 22, 6}, 2) → {9, 90}
	 * 
	 * copyEndy({9, 11, 90, 22, 6}, 3) → {9, 90, 6}
	 * 
	 * copyEndy({12, 1, 1, 13, 0, 20}, 2) → {1, 1}
	 */
	public int[] copyEndy(int[] nums, int count) {
		int[] result = new int[count];
		int i = 0;
		for (int num : nums) {
			if (!isEndy(num)) {
				continue;
			}
			result[i++] = num;
			if (i >= count) {
				break;
			}
		}
		return result;
	}

	private boolean isEndy(int num) {
		return (num >= 0 && num <= 10) || (num >= 90 && num <= 100);
	}

	/*
	 * http://codingbat.com/prob/p139677
	 * 
	 * Given 2 arrays that are the same length containing strings, compare the
	 * 1st string in one array to the 1st string in the other array, the 2nd to
	 * the 2nd and so on. Count the number of times that the 2 strings are
	 * non-empty and start with the same char. The strings may be any length,
	 * including 0.
	 * 
	 * matchUp({"aa", "bb", "cc"}, {"aaa", "xx", "bb"}) → 1
	 * 
	 * matchUp({"aa", "bb", "cc"}, {"aaa", "b", "bb"}) → 2
	 * 
	 * matchUp({"aa", "bb", "cc"}, {"", "", "ccc"}) → 1
	 */
	public int matchUp(String[] a, String[] b) {
		int result = 0;
		for (int i = 0; i < a.length; ++i) {
			if (a[i].length() == 0 || b[i].length() == 0) {
				continue;
			}
			if (a[i].charAt(0) == b[i].charAt(0)) {
				result++;
			}
		}
		return result;
	}

	/*
	 * http://codingbat.com/prob/p180365
	 * 
	 * The "key" array is an array containing the correct answers to an exam,
	 * like {"a", "a", "b", "b"}. the "answers" array contains a student's
	 * answers, with "?" representing a question left blank. The two arrays are
	 * not empty and are the same length. Return the score for this array of
	 * answers, giving +4 for each correct answer, -1 for each incorrect answer,
	 * and +0 for each blank answer.
	 * 
	 * scoreUp({"a", "a", "b", "b"}, {"a", "c", "b", "c"}) → 6
	 * 
	 * scoreUp({"a", "a", "b", "b"}, {"a", "a", "b", "c"}) → 11
	 * 
	 * scoreUp({"a", "a", "b", "b"}, {"a", "a", "b", "b"}) → 16
	 */
	public int scoreUp(String[] key, String[] answers) {
		int result = 0;
		for (int i = 0; i < key.length; ++i) {
			if (answers[i].equals("?")) {
				continue;
			}
			if (answers[i].equals(key[i])) {
				result += 4;
			} else {
				result -= 1;
			}
		}
		return result;
	}

	/*
	 * http://codingbat.com/prob/p121236
	 * 
	 * Given an array of strings, return a new array without the strings that
	 * are equal to the target string. One approach is to count the occurrences
	 * of the target string, make a new array of the correct length, and then
	 * copy over the correct strings.
	 * 
	 * wordsWithout({"a", "b", "c", "a"}, "a") → {"b", "c"}
	 * 
	 * wordsWithout({"a", "b", "c", "a"}, "b") → {"a", "c", "a"}
	 * 
	 * wordsWithout({"a", "b", "c", "a"}, "c") → {"a", "b", "a"}
	 */
	public String[] wordsWithout(String[] words, String target) {
		List<String> result = new ArrayList<String>();
		for (String word : words) {
			if (word.equals(target)) {
				continue;
			}
			result.add(word);
		}
		return result.toArray(new String[result.size()]);
	}

	/*
	 * http://codingbat.com/prob/p140485
	 * 
	 * Given two arrays, A and B, of non-negative int scores. A "special" score
	 * is one which is a multiple of 10, such as 40 or 90. Return the sum of
	 * largest special score in A and the largest special score in B. If an
	 * array doesn't have a special score, consider its largest special score to
	 * be zero. To practice decomposition, write a separate helper method which
	 * finds the largest special score in an array. Write your helper method
	 * after your scoresSpecial() method in the JavaBat text area.
	 * 
	 * scoresSpecial({12, 10, 4}, {2, 20, 30}) → 40
	 * 
	 * scoresSpecial({20, 10, 4}, {2, 20, 10}) → 40
	 * 
	 * scoresSpecial({12, 11, 4}, {2, 20, 31}) → 20
	 */
	public int scoresSpecial(int[] a, int[] b) {
		return findLargestSpecialScore(a) + findLargestSpecialScore(b);
	}

	private int findLargestSpecialScore(int[] arr) {
		int result = 0;
		for (int i : arr) {
			if (i % 10 == 0) {
				result = Math.max(result, i);
			}
		}
		return result;
	}

	/*
	 * http://codingbat.com/prob/p148138
	 * 
	 * We have an array of heights, representing the altitude along a walking
	 * trail. Given start/end indexes into the array, return the sum of the
	 * changes for a walk beginning at the start index and ending at the end
	 * index. For example, with the heights {5, 3, 6, 7, 2} and start=2, end=4
	 * yields a sum of 1 + 5 = 6. The start end end index will both be valid
	 * indexes into the array with start <= end.
	 * 
	 * sumHeights({5, 3, 6, 7, 2}, 2, 4) → 6
	 * 
	 * sumHeights({5, 3, 6, 7, 2}, 0, 1) → 2
	 * 
	 * sumHeights({5, 3, 6, 7, 2}, 0, 4) → 11
	 */
	public int sumHeights(int[] heights, int start, int end) {
		int result = 0;
		for (int i = start; i < end; ++i) {
			result += Math.abs(heights[i + 1] - heights[i]);
		}
		return result;
	}

	/*
	 * http://codingbat.com/prob/p157900
	 * 
	 * (A variation on the sumHeights problem.) We have an array of heights,
	 * representing the altitude along a walking trail. Given start/end indexes
	 * into the array, return the sum of the changes for a walk beginning at the
	 * start index and ending at the end index, however increases in height
	 * count double. For example, with the heights {5, 3, 6, 7, 2} and start=2,
	 * end=4 yields a sum of 1*2 + 5 = 7. The start end end index will both be
	 * valid indexes into the array with start <= end.
	 * 
	 * sumHeights2({5, 3, 6, 7, 2}, 2, 4) → 7
	 * 
	 * sumHeights2({5, 3, 6, 7, 2}, 0, 1) → 2
	 * 
	 * sumHeights2({5, 3, 6, 7, 2}, 0, 4) → 15
	 */
	public int sumHeights2(int[] heights, int start, int end) {
		int result = 0;
		for (int i = start; i < end; ++i) {
			if (heights[i + 1] > heights[i]) {
				result += 2 * (heights[i + 1] - heights[i]);
			} else {
				result += heights[i] - heights[i + 1];
			}

		}
		return result;
	}

	/*
	 * http://codingbat.com/prob/p197710
	 * 
	 * (A variation on the sumHeights problem.) We have an array of heights,
	 * representing the altitude along a walking trail. Given start/end indexes
	 * into the array, return the number of "big" steps for a walk starting at
	 * the start index and ending at the end index. We'll say that step is big
	 * if it is 5 or more up or down. The start end end index will both be valid
	 * indexes into the array with start <= end.
	 * 
	 * bigHeights({5, 3, 6, 7, 2}, 2, 4) → 1
	 * 
	 * bigHeights({5, 3, 6, 7, 2}, 0, 1) → 0
	 * 
	 * bigHeights({5, 3, 6, 7, 2}, 0, 4) → 1
	 */
	public int bigHeights(int[] heights, int start, int end) {
		int result = 0;
		for (int i = start; i < end; ++i) {
			if (Math.abs(heights[i + 1] - heights[i]) >= 5) {
				result += 1;
			}

		}
		return result;

	}

	/*
	 * http://codingbat.com/prob/p143482
	 * 
	 * We have data for two users, A and B, each with a String name and an int
	 * id. The goal is to order the users such as for sorting. Return -1 if A
	 * comes before B, 1 if A comes after B, and 0 if they are the same. Order
	 * first by the string names, and then by the id numbers if the names are
	 * the same. Note: with Strings str1.compareTo(str2) returns an int value
	 * which is negative/0/positive to indicate how str1 is ordered to str2 (the
	 * value is not limited to -1/0/1). (On the AP, there would be two User
	 * objects, but here the code simply takes the two strings and two ints
	 * directly. The code logic is the same.)
	 * 
	 * userCompare("bb", 1, "zz", 2) → -1
	 * 
	 * userCompare("bb", 1, "aa", 2) → 1
	 * 
	 * userCompare("bb", 1, "bb", 1) → 0
	 */
	public int userCompare(String aName, int aId, String bName, int bId) {
		int result = aName.compareTo(bName);
		if (result == 0) {
			result = aId - bId;
		}
		if (result != 0) {
			result /= Math.abs(result);
		}
		return result;
	}

	/*
	 * http://codingbat.com/prob/p139150
	 * 
	 * Start with two arrays of strings, A and B, each with its elements in
	 * alphabetical order and without duplicates. Return a new array containing
	 * the first N elements from the two arrays. The result array should be in
	 * alphabetical order and without duplicates. A and B will both have a
	 * length which is N or more. The best "linear" solution makes a single pass
	 * over A and B, taking advantage of the fact that they are in alphabetical
	 * order, copying elements directly to the new array.
	 * 
	 * mergeTwo({"a", "c", "z"}, {"b", "f", "z"}, 3) → {"a", "b", "c"}
	 * 
	 * mergeTwo({"a", "c", "z"}, {"c", "f", "z"}, 3) → {"a", "c", "f"}
	 * 
	 * mergeTwo({"f", "g", "z"}, {"c", "f", "g"}, 3) → {"c", "f", "g"}
	 */
	public String[] mergeTwo(String[] a, String[] b, int n) {
		String[] result = new String[n];
		int ai = 0, bi = 0;
		for (int i = 0; i < n; ++i) {
			if (a[ai].compareTo(b[bi]) < 0) {
				result[i] = a[ai];
				ai++;
			} else if (a[ai].compareTo(b[bi]) == 0) {
				result[i] = a[ai];
				ai++;
				bi++;
			} else {
				result[i] = b[bi];
				bi++;
			}
		}
		return result;
	}

	/*
	 * http://codingbat.com/prob/p100369
	 * 
	 * Start with two arrays of strings, a and b, each in alphabetical order,
	 * possibly with duplicates. Return the count of the number of strings which
	 * appear in both arrays. The best "linear" solution makes a single pass
	 * over both arrays, taking advantage of the fact that they are in
	 * alphabetical order.
	 * 
	 * commonTwo({"a", "c", "x"}, {"b", "c", "d", "x"}) → 2
	 * 
	 * commonTwo({"a", "c", "x"}, {"a", "b", "c", "x", "z"}) → 3
	 * 
	 * commonTwo({"a", "b", "c"}, {"a", "b", "c"}) → 3
	 */
	public int commonTwo(String[] a, String[] b) {
		int result = 0;
		int ai = 0, bi = 0;
		while (ai < a.length && bi < b.length) {
			if (a[ai].compareTo(b[bi]) < 0) {
				ai++;
			} else if (a[ai].compareTo(b[bi]) == 0) {
				result++;
				String s = a[ai];
				while (ai < a.length && a[ai].equals(s)) {
					ai++;
				}
				while (bi < b.length && b[bi].equals(s)) {
					bi++;
				}
			} else {
				bi++;
			}
		}
		return result;
	}

}
