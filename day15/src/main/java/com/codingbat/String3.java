package com.codingbat;

public final class String3 {
	/*
	 * http://codingbat.com/prob/p199171
	 * 
	 * Given a string, count the number of words ending in 'y' or 'z' -- so the
	 * 'y' in "heavy" and the 'z' in "fez" count, but not the 'y' in "yellow"
	 * (not case sensitive). We'll say that a y or z is at the end of a word if
	 * there is not an alphabetic letter immediately following it. (Note:
	 * Character.isLetter(char) tests if a char is an alphabetic letter.)
	 * 
	 * countYZ("fez day") → 2
	 * 
	 * countYZ("day fez") → 2
	 * 
	 * countYZ("day fyyyz") → 2
	 */
	public int countYZ(String str) {
		int result = 0;
		for (int i = 0; i < str.length(); ++i) {
			if (i < str.length() - 1 && Character.isLetter(str.charAt(i + 1))) {
				continue;
			}
			if (str.toLowerCase().charAt(i) == 'y'
					|| str.toLowerCase().charAt(i) == 'z') {
				result++;
			}
		}
		return result;
	}

	/*
	 * http://codingbat.com/prob/p192570
	 * 
	 * Given two strings, base and remove, return a version of the base string
	 * where all instances of the remove string have been removed (not case
	 * sensitive). You may assume that the remove string is length 1 or more.
	 * Remove only non-overlapping instances, so with "xxx" removing "xx" leaves
	 * "x".
	 * 
	 * withoutString("Hello there", "llo") → "He there"
	 * 
	 * withoutString("Hello there", "e") → "Hllo thr"
	 * 
	 * withoutString("Hello there", "x") → "Hello there"
	 */
	public String withoutString(String base, String remove) {
		return java.util.regex.Pattern
				.compile(java.util.regex.Pattern.quote(remove),
						java.util.regex.Pattern.CASE_INSENSITIVE).matcher(base)
				.replaceAll("");
	}

	/*
	 * http://codingbat.com/prob/p141736
	 * 
	 * Given a string, return true if the number of appearances of "is" anywhere
	 * in the string is equal to the number of appearances of "not" anywhere in
	 * the string (case sensitive).
	 * 
	 * equalIsNot("This is not") → false
	 * 
	 * equalIsNot("This is notnot") → true
	 * 
	 * equalIsNot("noisxxnotyynotxisi") → true
	 */
	public boolean equalIsNot(String str) {
		int is = 0, not = 0;
		for (int i = 0;;) {
			i = str.indexOf("is", i);
			if (i < 0) {
				break;
			}
			is++;
			i += 2;
		}
		for (int i = 0;;) {
			i = str.indexOf("not", i);
			if (i < 0) {
				break;
			}
			not++;
			i += 3;
		}
		return is == not;
	}

	/*
	 * http://codingbat.com/prob/p198664
	 * 
	 * We'll say that a lowercase 'g' in a string is "happy" if there is another
	 * 'g' immediately to its left or right. Return true if all the g's in the
	 * given string are happy.
	 * 
	 * gHappy("xxggxx") → true
	 * 
	 * gHappy("xxgxx") → false
	 * 
	 * gHappy("xxggyygxx") → false
	 */
	public boolean gHappy(String str) {
		return str.replaceAll("gg+", "").indexOf('g') < 0;
	}

	/*
	 * http://codingbat.com/prob/p195714
	 * 
	 * We'll say that a "triple" in a string is a char appearing three times in
	 * a row. Return the number of triples in the given string. The triples may
	 * overlap.
	 * 
	 * countTriple("abcXXXabc") → 1
	 * 
	 * countTriple("xxxabyyyycd") → 3
	 * 
	 * countTriple("a") → 0
	 */
	public int countTriple(String str) {
		int result = 0;
		for (int i = 0; i < str.length() - 2; ++i) {
			if (str.charAt(i) == str.charAt(i + 1)
					&& str.charAt(i + 1) == str.charAt(i + 2)) {
				result += 1;
			}
		}
		return result;
	}

	/*
	 * http://codingbat.com/prob/p197890
	 * 
	 * Given a string, return the sum of the digits 0-9 that appear in the
	 * string, ignoring all other characters. Return 0 if there are no digits in
	 * the string. (Note: Character.isDigit(char) tests if a char is one of the
	 * chars '0', '1', .. '9'. Integer.parseInt(string) converts a string to an
	 * int.)
	 * 
	 * sumDigits("aa1bc2d3") → 6
	 * 
	 * sumDigits("aa11b33") → 8
	 * 
	 * sumDigits("Chocolate") → 0
	 */
	public int sumDigits(String str) {
		int result = 0;
		for (char c : str.replaceAll("\\D+", "").toCharArray()) {
			result += c - '0';
		}
		return result;
	}

	/*
	 * http://codingbat.com/prob/p131516
	 * 
	 * Given a string, return the longest substring that appears at both the
	 * beginning and end of the string without overlapping. For example,
	 * sameEnds("abXab") is "ab".
	 * 
	 * sameEnds("abXYab") → "ab"
	 * 
	 * sameEnds("xx") → "x"
	 * 
	 * sameEnds("xxx") → "x"
	 */
	public String sameEnds(String string) {
		java.util.regex.Matcher m = java.util.regex.Pattern.compile(
				"(.*).*?\\1").matcher(string);
		if (!m.matches()) {
			return "";
		}
		return m.group(1);
	}

	/*
	 * http://codingbat.com/prob/p139411
	 * 
	 * Given a string, look for a mirror image (backwards) string at both the
	 * beginning and end of the given string. In other words, zero or more
	 * characters at the very begining of the given string, and at the very end
	 * of the string in reverse order (possibly overlapping). For example, the
	 * string "abXYZba" has the mirror end "ab".
	 * 
	 * mirrorEnds("abXYZba") → "ab"
	 * 
	 * mirrorEnds("abca") → "a"
	 * 
	 * mirrorEnds("aba") → "aba"
	 */
	public String mirrorEnds(String string) {
		StringBuilder result = new StringBuilder(string.length());
		for (int i = 0; i < string.length(); ++i) {
			if (string.charAt(i) != string.charAt(string.length() - i - 1)) {
				break;
			}
			result.append(string.charAt(i));
		}
		return result.toString();
	}

	/*
	 * http://codingbat.com/prob/p179479
	 * 
	 * Given a string, return the length of the largest "block" in the string. A
	 * block is a run of adjacent chars that are the same.
	 * 
	 * maxBlock("hoopla") → 2
	 * 
	 * maxBlock("abbCCCddBBBxx") → 3
	 * 
	 * maxBlock("") → 0
	 */
	public int maxBlock(String str) {
		int result = 0;
		for (int i = 0; i < str.length(); ++i) {
			for (int j = i; j < str.length(); ++j) {
				if (str.charAt(i) != str.charAt(j)) {
					break;
				}
				result = Math.max(result, j - i + 1);
			}
		}
		return result;
	}

	/*
	 * http://codingbat.com/prob/p121193
	 * 
	 * Given a string, return the sum of the numbers appearing in the string,
	 * ignoring all other characters. A number is a series of 1 or more digit
	 * chars in a row. (Note: Character.isDigit(char) tests if a char is one of
	 * the chars '0', '1', .. '9'. Integer.parseInt(string) converts a string to
	 * an int.)
	 * 
	 * sumNumbers("abc123xyz") → 123
	 * 
	 * sumNumbers("aa11b33") → 44
	 * 
	 * sumNumbers("7 11") → 18
	 */
	public int sumNumbers(String str) {
		java.util.regex.Matcher m = java.util.regex.Pattern.compile("\\d+")
				.matcher(str);
		int result = 0;
		while (m.find()) {
			result += Integer.parseInt(m.group());
		}
		return result;
	}

	/*
	 * http://codingbat.com/prob/p154137
	 * 
	 * Given a string, return a string where every appearance of the lowercase
	 * word "is" has been replaced with "is not". The word "is" should not be
	 * immediately preceeded or followed by a letter -- so for example the "is"
	 * in "this" does not count. (Note: Character.isLetter(char) tests if a char
	 * is a letter.)
	 * 
	 * notReplace("is test") → "is not test"
	 * 
	 * notReplace("is-is") → "is not-is not"
	 * 
	 * notReplace("This is right") → "This is not right"
	 */
	public String notReplace(String str) {
		return str.replaceAll("(?<!\\w)is(?!\\w)", "is not");
	}

}