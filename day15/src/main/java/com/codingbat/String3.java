package com.codingbat;

import java.util.regex.*;

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
		Pattern pattern = Pattern.compile("[yY][\\W|\\d]|[yY]$");
		Matcher matcher = pattern.matcher(str);
		int count = 0;
		while (matcher.find()) {
			count++;
		}
		pattern = Pattern.compile("[zZ][\\W|\\d]|[zZ]$");
		matcher = pattern.matcher(str);
		while (matcher.find()) {
			count++;
		}
		return count;

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
		Pattern pattern = Pattern.compile(remove, Pattern.CASE_INSENSITIVE);
		Matcher matcher = pattern.matcher(base);
		return matcher.replaceAll("");
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

	private int noInstances(String toSearch, String where) {
		Pattern pattern = Pattern.compile(toSearch);
		Matcher matcher = pattern.matcher(where);
		int count = 0;
		while (matcher.find()) {
			count++;
		}
		return count;
	}

	public boolean equalIsNot(String str) {

		return (noInstances("is", str) == noInstances("not", str));
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
		Pattern pattern = Pattern.compile("gg+");
		Matcher matcher = pattern.matcher(str);
		matcher.replaceAll("");
		matcher.usePattern(Pattern.compile("g"));
		if (matcher.find()) {
			return false;
		}
		return true;
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
		char[] ch = str.toCharArray();
		int contor = 0;
		for (int i = 2; i < ch.length; i++) {
			if (ch[i] == ch[i - 1] && ch[i - 1] == ch[i - 2]) {
				contor++;
			}
		}
		return contor;
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
		Pattern pattern = Pattern.compile("[0-9]");
		Matcher matcher = pattern.matcher(str);
		int sum = 0;
		while (matcher.find()) {
			sum += Integer.parseInt(matcher.group());
		}
		return sum;
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
		Pattern pattern = Pattern.compile("^(.*).*\\1$");
		Matcher matcher = pattern.matcher(string);

		matcher.find();

		return matcher.group(1);

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

		char[] ch = string.toCharArray();
		int i = 0;
		while (i < ch.length) {
			if (ch[i] != ch[ch.length - 1 - i]) {
				break;
			} else {
				i++;
			}
		}
		StringBuilder sb = new StringBuilder();
		for (int j = 0; j < i; j++) {
			sb.append(ch[j]);
		}
		return sb.toString();

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
		Pattern pattern = Pattern.compile("([a-zA-Z0-9])\\1*");
		Matcher matcher = pattern.matcher(str);
		int max = 0;
		while (matcher.find()) {
			max = (max < matcher.group().length() ? matcher.group().length()
					: max);
		}
		return max;
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
		Pattern pattern = Pattern.compile("[0-9]+");
		Matcher matcher = pattern.matcher(str);
		int sum = 0;
		while (matcher.find()) {
			sum += Integer.parseInt(matcher.group());
		}
		return sum;
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
		StringBuilder sb = new StringBuilder();
		char[] ch = str.toCharArray();
		int i = 0;
		while (i < ch.length) {
			if (ch[i] == 'i' && ch[i + 1] == 's') {
				if (i > 0 && Character.isLetter(ch[i - 1])) {
					sb.append(ch[i]);
					i++;
					continue;
				} else if (i + 2 < ch.length && Character.isLetter(ch[i + 2])) {
					sb.append(ch[i]);
					i++;
					continue;
				} else {
					sb.append("is not");
					i += 2;
				}

			} else {
				sb.append(ch[i]);
				i++;
			}
		}
		return sb.toString();
	}

}