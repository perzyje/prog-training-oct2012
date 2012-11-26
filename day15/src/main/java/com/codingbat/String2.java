package com.codingbat;

public final class String2 {
	/*
	 * http://codingbat.com/prob/p165312
	 * 
	 * Given a string, return a string where for every char in the original,
	 * there are two chars.
	 * 
	 * doubleChar("The") → "TThhee"
	 * 
	 * doubleChar("AAbb") → "AAAAbbbb"
	 * 
	 * doubleChar("Hi-There") → "HHii--TThheerree"
	 */
	public String doubleChar(String str) {
		StringBuilder result = new StringBuilder(str.length() * 2);
		for (char c : str.toCharArray()) {
			result.append(c).append(c);
		}
		return result.toString();
	}

	/*
	 * http://codingbat.com/prob/p147448
	 * 
	 * Return the number of times that the string "hi" appears anywhere in the
	 * given string.
	 * 
	 * countHi("abc hi ho") → 1
	 * 
	 * countHi("ABChi hi") → 2
	 * 
	 * countHi("hihi") → 2
	 */
	public int countHi(String str) {
		int result = 0;
		for (int i = 0;;) {
			i = str.indexOf("hi", i);
			if (i < 0) {
				break;
			}
			i++;
			result++;
		}
		return result;
	}

	/*
	 * http://codingbat.com/prob/p111624
	 * 
	 * Return true if the string "cat" and "dog" appear the same number of times
	 * in the given string.
	 * 
	 * catDog("catdog") → true
	 * 
	 * catDog("catcat") → false
	 * 
	 * catDog("1cat1cadodog") → true
	 */
	public boolean catDog(String str) {
		int r1 = 0;
		for (int i = 0;;) {
			i = str.indexOf("cat", i);
			if (i < 0) {
				break;
			}
			i++;
			r1++;
		}

		int r2 = 0;
		for (int i = 0;;) {
			i = str.indexOf("dog", i);
			if (i < 0) {
				break;
			}
			i++;
			r2++;
		}
		return r1 == r2;
	}

	/*
	 * http://codingbat.com/prob/p123614
	 * 
	 * Return the number of times that the string "code" appears anywhere in the
	 * given string, except we'll accept any letter for the 'd', so "cope" and
	 * "cooe" count.
	 * 
	 * countCode("aaacodebbb") → 1
	 * 
	 * countCode("codexxcode") → 2
	 * 
	 * countCode("cozexxcope") → 2
	 */
	public int countCode(String str) {
		int result = 0;
		for (int i = 0; i < str.length() - 3; ++i) {
			if (str.charAt(i) == 'c' && str.charAt(i + 1) == 'o'
					&& str.charAt(i + 3) == 'e') {
				result += 1;
			}
		}
		return result;
	}

	/*
	 * http://codingbat.com/prob/p126880
	 * 
	 * Given two strings, return true if either of the strings appears at the
	 * very end of the other string, ignoring upper/lower case differences (in
	 * other words, the computation should not be "case sensitive"). Note:
	 * str.toLowerCase() returns the lowercase version of a string.
	 * 
	 * endOther("Hiabc", "abc") → true
	 * 
	 * endOther("AbC", "HiaBc") → true
	 * 
	 * endOther("abc", "abXabc") → true
	 */
	public boolean endOther(String a, String b) {
		String lowerA = a.toLowerCase(), lowerB = b.toLowerCase();
		return lowerA.endsWith(lowerB) || lowerB.endsWith(lowerA);
	}

	/*
	 * http://codingbat.com/prob/p136594
	 * 
	 * Return true if the given string contains an appearance of "xyz" where the
	 * xyz is not directly preceeded by a period (.). So "xxyz" counts but
	 * "x.xyz" does not.
	 * 
	 * xyzThere("abcxyz") → true
	 * 
	 * xyzThere("abc.xyz") → false
	 * 
	 * xyzThere("xyz.abc") → true
	 */
	public boolean xyzThere(String str) {
		if (str.startsWith("xyz")) {
			return true;
		}
		for (int i = 0; i < str.length(); ++i) {
			if (str.charAt(i) == '.') {
				continue;
			}
			if (str.substring(i + 1).startsWith("xyz")) {
				return true;
			}
		}
		return false;
	}

	/*
	 * http://codingbat.com/prob/p175762
	 * 
	 * Return true if the given string contains a "bob" string, but where the
	 * middle 'o' char can be any char.
	 * 
	 * bobThere("abcbob") → true
	 * 
	 * bobThere("b9b") → true
	 * 
	 * bobThere("bac") → false
	 */
	public boolean bobThere(String str) {
		return str.matches(".*b.b.*");
	}

	/*
	 * http://codingbat.com/prob/p134250
	 * 
	 * We'll say that a String is xy-balanced if for all the 'x' chars in the
	 * string, there exists a 'y' char somewhere later in the string. So "xxy"
	 * is balanced, but "xyx" is not. One 'y' can balance multiple 'x's. Return
	 * true if the given string is xy-balanced.
	 * 
	 * xyBalance("aaxbby") → true
	 * 
	 * xyBalance("aaxbb") → false
	 * 
	 * xyBalance("yaaxbb") → false
	 */
	public boolean xyBalance(String str) {
		return str.matches("[^xy]*|.*y[^x]*");
	}

	/*
	 * http://codingbat.com/prob/p125185
	 * 
	 * Given two strings, A and B, create a bigger string made of the first char
	 * of A, the first char of B, the second char of A, the second char of B,
	 * and so on. Any leftover chars go at the end of the result.
	 * 
	 * mixString("abc", "xyz") → "axbycz"
	 * 
	 * mixString("Hi", "There") → "HTihere"
	 * 
	 * mixString("xxxx", "There") → "xTxhxexre"
	 */
	public String mixString(String a, String b) {
		StringBuilder result = new StringBuilder(a.length() + b.length());
		int i = 0;
		while (i < a.length() && i < b.length()) {
			result.append(a.charAt(i)).append(b.charAt(i));
			i++;
		}
		while (i < a.length()) {
			result.append(a.charAt(i));
			i++;
		}
		while (i < b.length()) {
			result.append(b.charAt(i));
			i++;
		}
		return result.toString();
	}

	/*
	 * http://codingbat.com/prob/p152339
	 * 
	 * Given a string and an int N, return a string made of N repetitions of the
	 * last N characters of the string. You may assume that N is between 0 and
	 * the length of the string, inclusive.
	 * 
	 * repeatEnd("Hello", 3) → "llollollo"
	 * 
	 * repeatEnd("Hello", 2) → "lolo"
	 * 
	 * repeatEnd("Hello", 1) → "o"
	 */
	public String repeatEnd(String str, int n) {
		StringBuilder result = new StringBuilder(n * n);
		for (int i = 0; i < n; ++i) {
			result.append(str.substring(str.length() - n));
		}
		return result.toString();
	}

	/*
	 * http://codingbat.com/prob/p128796
	 * 
	 * Given a string and an int n, return a string made of the first n
	 * characters of the string, followed by the first n-1 characters of the
	 * string, and so on. You may assume that n is between 0 and the length of
	 * the string, inclusive (i.e. n >= 0 and n <= str.length()).
	 * 
	 * repeatFront("Chocolate", 4) → "ChocChoChC"
	 * 
	 * repeatFront("Chocolate", 3) → "ChoChC"
	 * 
	 * repeatFront("Ice Cream", 2) → "IcI"
	 */
	public String repeatFront(String str, int n) {
		StringBuilder result = new StringBuilder();
		for (int i = 0; i < n; ++i) {
			result.append(str.substring(0, n - i));
		}
		return result.toString();
	}

	/*
	 * http://codingbat.com/prob/p109637
	 * 
	 * Given two strings, word and a separator, return a big string made of
	 * count occurences of the word, separated by the separator string.
	 * 
	 * repeatSeparator("Word", "X", 3) → "WordXWordXWord"
	 * 
	 * repeatSeparator("This", "And", 2) → "ThisAndThis"
	 * 
	 * repeatSeparator("This", "And", 1) → "This"
	 */
	public String repeatSeparator(String word, String sep, int count) {
		StringBuilder result = new StringBuilder();
		for (int i = 0; i < count; ++i) {
			if (i > 0) {
				result.append(sep);
			}
			result.append(word);
		}
		return result.toString();
	}

	/*
	 * http://codingbat.com/prob/p136417
	 * 
	 * Given a string, consider the prefix string made of the first N chars of
	 * the string. Does that prefix string appear somewhere else in the string?
	 * Assume that the string is not empty and that N is in the range
	 * 1..str.length().
	 * 
	 * prefixAgai("abXYabc", 1) → true
	 * 
	 * prefixAgain("abXYabc", 2) → true
	 * 
	 * prefixAgain("abXYabc", 3) → false
	 */
	public boolean prefixAgain(String str, int n) {
		return str.indexOf(str.substring(0, n), 1) > -1;
	}

	/*
	 * http://codingbat.com/prob/p159772
	 * 
	 * Given a string, does "xyz" appear in the middle of the string? To define
	 * middle, we'll say that the number of chars to the left and right of the
	 * "xyz" must differ by at most one. This problem is harder than it looks.
	 * 
	 * xyzMiddle("AAxyzBB") → true
	 * 
	 * xyzMiddle("AxyzBB") → true
	 * 
	 * xyzMiddle("AxyzBBB") → false
	 */
	public boolean xyzMiddle(String str) {
		if (str.length() < 3) {
			return false;
		}
		if (str.length() % 2 == 0) {
			return str.substring(str.length() / 2 - 2, str.length() / 2 + 1)
					.equals("xyz")
					|| str.substring(str.length() / 2 - 1, str.length() / 2 + 2)
							.equals("xyz");
		} else {
			return str.substring(str.length() / 2 - 1, str.length() / 2 + 2)
					.equals("xyz");
		}
	}

	/*
	 * http://codingbat.com/prob/p129952
	 * 
	 * A sandwich is two pieces of bread with something in between. Return the
	 * string that is between the first and last appearance of "bread" in the
	 * given string, or return the empty string "" if there are not two pieces
	 * of bread.
	 * 
	 * getSandwich("breadjambread") → "jam"
	 * 
	 * getSandwich("xxbreadjambreadyy") → "jam"
	 * 
	 * getSandwich("xxbreadyy") → ""
	 */
	public String getSandwich(String str) {
		java.util.regex.Matcher m = java.util.regex.Pattern.compile(
				"bread(.+)bread").matcher(str);
		if (!m.find()) {
			return "";
		}
		return m.group(1);
	}

	/*
	 * http://codingbat.com/prob/p194491
	 * 
	 * Returns true if for every '*' (star) in the string, if there are chars
	 * both immediately before and after the star, they are the same.
	 * 
	 * sameStarChar("xy*yzz") → true
	 * 
	 * sameStarChar("xy*zzz") → false
	 * 
	 * sameStarChar("*xa*az") → true
	 */
	public boolean sameStarChar(String str) {
		for (int i = 1; i < str.length() - 1; ++i) {
			if (str.charAt(i) != '*') {
				continue;
			}
			if (str.charAt(i - 1) != str.charAt(i + 1)) {
				return false;
			}
		}
		return true;
	}

	/*
	 * http://codingbat.com/prob/p180759
	 * 
	 * Look for patterns like "zip" and "zap" in the string -- length-3,
	 * starting with 'z' and ending with 'p'. Return a string where for all such
	 * words, the middle letter is gone, so "zipXzap" yields "zpXzp".
	 * 
	 * zipZap("zipXzap") → "zpXzp"
	 * 
	 * zipZap("zopzop") → "zpzp"
	 * 
	 * zipZap("zzzopzop") → "zzzpzp"
	 */
	public String zipZap(String str) {
		return str.replaceAll("z.p", "zp");
	}

	/*
	 * http://codingbat.com/prob/p139564
	 * 
	 * Return a version of the given string, where for every star (*) in the
	 * string the star and the chars immediately to its left and right are gone.
	 * So "ab*cd" yields "ad" and "ab**cd" also yields "ad".
	 * 
	 * starOut("ab*cd") → "ad"
	 * 
	 * starOut("ab**cd") → "ad"
	 * 
	 * starOut("sm*eilly") → "silly"
	 */
	public String starOut(String str) {
		return str.replaceAll(".?\\*+.?", "");
	}

	/*
	 * http://codingbat.com/prob/p170829
	 * 
	 * Given a string and a non-empty word string, return a version of the
	 * original String where all chars have been replaced by pluses ("+"),
	 * except for appearances of the word string which are preserved unchanged.
	 * 
	 * plusOut("12xy34", "xy") → "++xy++"
	 * 
	 * plusOut("12xy34", "1") → "1+++++"
	 * 
	 * plusOut("12xy34xyabcxy", "xy") → "++xy++xy+++xy"
	 */
	public String plusOut(String str, String word) {
		StringBuilder result = new StringBuilder(str.length());
		for (int i = 0; i < str.length(); ++i) {
			if (str.substring(i).startsWith(word)) {
				result.append(word);
				i += word.length() - 1;
			} else {
				result.append('+');
			}
		}
		return result.toString();
	}

	/*
	 * http://codingbat.com/prob/p147538
	 * 
	 * Given a string and a non-empty word string, return a string made of each
	 * char just before and just after every appearance of the word in the
	 * string. Ignore cases where there is no char before or after the word, and
	 * a char may be included twice if it is between two words.
	 * 
	 * wordEnds("abcXY123XYijk", "XY") → "c13i"
	 * 
	 * wordEnds("XY123XY", "XY") → "13"
	 * 
	 * wordEnds("XY1XY", "XY") → "11"
	 */
	public String wordEnds(String str, String word) {
		StringBuilder result = new StringBuilder();
		for (int i = 0; i < str.length(); ++i) {
			if (!str.substring(i).startsWith(word)) {
				continue;
			}
			if (i > 0) {
				result.append(str.charAt(i - 1));
			}
			if (i + word.length() < str.length()) {
				result.append(str.charAt(i + word.length()));
			}
		}
		return result.toString();
	}

}
