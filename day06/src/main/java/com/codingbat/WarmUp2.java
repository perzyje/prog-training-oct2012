package com.codingbat;

public final class WarmUp2 {
	/*
	 * http://codingbat.com/prob/p142270
	 * 
	 * Given a string and a non-negative int n, return a larger string that is n
	 * copies of the original string.
	 * 
	 * stringTimes("Hi", 2) → "HiHi"
	 * 
	 * stringTimes("Hi", 3) → "HiHiHi"
	 * 
	 * stringTimes("Hi", 1) → "Hi"
	 */
	public String stringTimes(String str, int n) {
		StringBuilder s = new StringBuilder();
		for (int i = 0; i < n; i++) {
			s.append(str);
		}
		return s.toString();
	}

	/*
	 * http://codingbat.com/prob/p101475
	 * 
	 * Given a string and a non-negative int n, we'll say that the front of the
	 * string is the first 3 chars, or whatever is there if the string is less
	 * than length 3. Return n copies of the front;
	 * 
	 * frontTimes("Chocolate", 2) → "ChoCho"
	 * 
	 * frontTimes("Chocolate", 3) → "ChoChoCho"
	 * 
	 * frontTimes("Abc", 3) → "AbcAbcAbc"
	 */
	public String frontTimes(String str, int n) {
		return (str.length() < 3) ? stringTimes(str, n) : stringTimes(
				str.substring(0, 3), n);
	}

	/*
	 * http://codingbat.com/prob/p165666
	 * 
	 * Given a string, return a new string made of every other char starting
	 * with the first, so "Hello" yields "Hlo".
	 * 
	 * stringBits("Hello") → "Hlo"
	 * 
	 * stringBits("Hi") → "H"
	 * 
	 * stringBits("Heeololeo") → "Hello"
	 */
	public String stringBits(String str) {
		StringBuilder s = new StringBuilder();
		for (int i = 0; i < str.length(); i += 2) {
			s.append(str.charAt(i));
		}
		return s.toString();
	}

	/*
	 * http://codingbat.com/prob/p117334
	 * 
	 * Given a non-empty string like "Code" return a string like "CCoCodCode".
	 * 
	 * stringSplosion("Code") → "CCoCodCode"
	 * 
	 * stringSplosion("abc") → "aababc"
	 * 
	 * stringSplosion("ab") → "aab"
	 */
	public String stringSplosion(String str) {
		StringBuilder s = new StringBuilder();
		for (int i = 0; i < str.length(); i++) {
			s.append(str.substring(0, i + 1));
		}
		return s.toString();
	}

	/*
	 * http://codingbat.com/prob/p178318
	 * 
	 * Given a string, return the count of the number of times that a substring
	 * length 2 appears in the string and also as the last 2 chars of the
	 * string, so "hixxxhi" yields 1 (we won't count the end substring).
	 * 
	 * last2("hixxhi") → 1
	 * 
	 * last2("xaxxaxaxx") → 1
	 * 
	 * last2("axxxaaxx") → 2
	 */
	public int last2(String str) {
		String lastW = (str.length() < 2 ? str : str
				.substring(str.length() - 2));
		int instances = 0;
		String s = str;
		instances = 0;
		while (s.indexOf(lastW) != s.length() - lastW.length()) {
			s = s.substring(s.indexOf(lastW) + 1);
			instances++;
		}
		return instances;
	}

	/*
	 * http://codingbat.com/prob/p184031
	 * 
	 * Given an array of ints, return the number of 9's in the array.
	 * 
	 * arrayCount9({1, 2, 9}) → 1
	 * 
	 * arrayCount9({1, 9, 9}) → 2
	 * 
	 * arrayCount9({1, 9, 9, 3, 9}) → 3
	 */
	public int arrayCount9(int[] nums) {
		int instances = 0;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] == 9) {
				instances++;
			}
		}
		return instances;
	}

	/*
	 * http://codingbat.com/prob/p186031
	 * 
	 * Given an array of ints, return true if one of the first 4 elements in the
	 * array is a 9. The array length may be less than 4.
	 * 
	 * arrayFront9({1, 2, 9, 3, 4}) → true
	 * 
	 * arrayFront9({1, 2, 3, 4, 9}) → false
	 * 
	 * arrayFront9({1, 2, 3, 4, 5}) → false
	 */
	public boolean arrayFront9(int[] nums) {
		int lim = nums.length < 4 ? nums.length : 4;
		for (int i = 0; i < lim; i++) {
			if (nums[i] == 9) {
				return true;
			}
		}
		return false;
	}

	/*
	 * http://codingbat.com/prob/p136041
	 * 
	 * Given an array of ints, return true if .. 1, 2, 3, .. appears in the
	 * array somewhere.
	 * 
	 * array123({1, 1, 2, 3, 1}) → true
	 * 
	 * array123({1, 1, 2, 4, 1}) → false
	 * 
	 * array123({1, 1, 2, 1, 2, 3}) → true
	 */
	public boolean array123(int[] nums) {
		if (nums.length < 3) {
			return false;
		}
		for (int i = 0; i < nums.length - 2; i++) {
			if (nums[i] == 1 && nums[i + 1] == 2 && nums[i + 2] == 3) {
				return true;
			}
		}
		return false;
	}

	/*
	 * http://codingbat.com/prob/p198640
	 * 
	 * Given 2 strings, a and b, return the number of the positions where they
	 * contain the same length 2 substring. So "xxcaazz" and "xxbaaz" yields 3,
	 * since the "xx", "aa", and "az" substrings appear in the same place in
	 * both strings.
	 * 
	 * stringMatch("xxcaazz", "xxbaaz") → 3
	 * 
	 * stringMatch("abc", "abc") → 2
	 * 
	 * stringMatch("abc", "axc") → 0
	 */
	public int stringMatch(String a, String b) {
		int max = a.length() < b.length() ? a.length() : b.length();
		int insta = 0;
		for (int i = 0; i < max - 1; i++) {
			if ((a.charAt(i) == b.charAt(i))
					&& (a.charAt(i + 1)) == b.charAt(i + 1)) {
				insta++;
			}
		}
		return insta;
	}

	/*
	 * http://codingbat.com/prob/p171260
	 * 
	 * Given a string, return a version where all the "x" have been removed.
	 * Except an "x" at the very start or end should not be removed.
	 * 
	 * stringX("xxHxix") → "xHix"
	 * 
	 * stringX("abxxxcd") → "abcd"
	 * 
	 * stringX("xabxxxcdx") → "xabcdx"
	 */
	public String stringX(String str) {
		if (str.length() < 3) {
			return str;
		}
		String s = str.substring(1, str.length() - 1);
		while (s.indexOf('x') != -1) {
			s = s.substring(0, s.indexOf('x'))
					+ s.substring(s.indexOf('x') + 1);
		}
		return str.charAt(0) + s + str.charAt(str.length() - 1);
	}

	/*
	 * http://codingbat.com/prob/p121596
	 * 
	 * Given a string, return a string made of the chars at indexes 0,1, 4,5,
	 * 8,9 ... so "kittens" yields "kien".
	 * 
	 * altPairs("kitten") → "kien"
	 * 
	 * altPairs("Chocolate") → "Chole"
	 * 
	 * altPairs("CodingHorror") → "Congrr"
	 */
	public String altPairs(String str) {
		StringBuilder sb = new StringBuilder();
		if (str.length() < 2) {
			return str;
		}
		for (int i = 0; i < str.length(); i++) {
			if (i % 4 == 0 || i % 4 == 1) {
				sb.append(str.charAt(i));
			}
		}
		return sb.toString();
	}

	/*
	 * http://codingbat.com/prob/p126212
	 * 
	 * Suppose the string "yak" is unlucky. Given a string, return a version
	 * where all the "yak" are removed, but the "a" can be any char. The "yak"
	 * strings will not overlap.
	 * 
	 * stringYak("yakpak") → "pak"
	 * 
	 * stringYak("pakyak") → "pak"
	 * 
	 * stringYak("yak123ya") → "123ya"
	 */
	public String stringYak(String str) {
		return str.replaceAll("y.k", "");
	}

	/*
	 * http://codingbat.com/prob/p110019
	 * 
	 * Given an array of ints, return the number of times that two 6's are next
	 * to each other in the array. Also count instances where the second "6" is
	 * actually a 7.
	 * 
	 * array667({6, 6, 2}) → 1
	 * 
	 * array667({6, 6, 2, 6}) → 1
	 * 
	 * array667({6, 7, 2, 6}) → 1
	 */
	public int array667(int[] nums) {
		boolean last6 = false;
		int insta = 0;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] == 6) {
				if (last6) {
					insta++;
				} else {
					last6 = true;
				}
			} else {
				if (nums[i] == 7 && last6) {
					insta++;
				}
				last6 = false;
			}
		}
		return insta;
	}

	/*
	 * http://codingbat.com/prob/p170221
	 * 
	 * Given an array of ints, we'll say that a triple is a value appearing 3
	 * times in a row in the array. Return true if the array does not contain
	 * any triples.
	 * 
	 * noTriples({1, 1, 2, 2, 1}) → true
	 * 
	 * noTriples({1, 1, 2, 2, 2, 1}) → false
	 * 
	 * noTriples({1, 1, 1, 2, 2, 2, 1}) → false
	 */
	public boolean noTriples(int[] nums) {
		for (int i = 0; i < nums.length - 2; i++) {
			if (nums[i] == nums[i + 1] && nums[i + 1] == nums[i + 2]) {
				return false;
			}
		}
		return true;
	}

	/*
	 * http://codingbat.com/prob/p167430
	 * 
	 * Given an array of ints, return true if it contains a 2, 7, 1 pattern -- a
	 * value, followed by the value plus 5, followed by the value minus 1.
	 * Additionally the 271 counts even if the "1" differs by 2 or less from the
	 * correct value.
	 * 
	 * has271({1, 2, 7, 1}) → true
	 * 
	 * has271({1, 2, 8, 1}) → false
	 * 
	 * has271({2, 7, 1}) → true
	 */
	public boolean has271(int[] nums) {
		for (int i = 0; i < nums.length - 2; i++) {
			if ((nums[i + 1] == nums[i] + 5)
					&& Math.abs(nums[i + 2] - (nums[i] - 1)) <= 2) {
				return true;
			}
		}
		return false;
	}
}
