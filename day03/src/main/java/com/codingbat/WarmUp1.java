package com.codingbat;

/*
 * Useful links:
 * http://codingbat.com/example.html
 * http://codingbat.com/doc/ifboolean.html
 * http://codingbat.com/doc/string.html
 * http://codingbat.com/doc/loop.html
 * http://codingbat.com/doc/array.html
 */
public final class WarmUp1 {
	/*
	 * http://codingbat.com/prob/p187868
	 * 
	 * The parameter weekday is true if it is a weekday, and the parameter
	 * vacation is true if we are on vacation. We sleep in if it is not a
	 * weekday or we're on vacation. Return true if we sleep in.
	 * 
	 * sleepIn(false, false) → true
	 * 
	 * sleepIn(true, false) → false
	 * 
	 * sleepIn(false, true) → true
	 */
	public boolean sleepIn(boolean weekday, boolean vacation) {
		return !weekday || vacation;
	}

	/*
	 * http://codingbat.com/prob/p181646
	 * 
	 * We have two monkeys, a and b, and the parameters aSmile and bSmile
	 * indicate if each is smiling. We are in trouble if they are both smiling
	 * or if neither of them is smiling. Return true if we are in trouble.
	 * 
	 * monkeyTrouble(true, true) → true
	 * 
	 * monkeyTrouble(false, false) → true
	 * 
	 * monkeyTrouble(true, false) → false
	 */
	public boolean monkeyTrouble(boolean aSmile, boolean bSmile) {
		return !(aSmile ^ bSmile);
	}

	/*
	 * http://codingbat.com/prob/p154485
	 * 
	 * Given two int values, return their sum. Unless the two values are the
	 * same, then return double their sum.
	 * 
	 * sumDouble(1, 2) → 3
	 * 
	 * sumDouble(3, 2) → 5
	 * 
	 * sumDouble(2, 2) → 8
	 */
	public int sumDouble(int a, int b) {
		int result = a + b;
		if (a == b) {
			result *= 2;
		}
		return result;
	}

	/*
	 * http://codingbat.com/prob/p116624
	 * 
	 * Given an int n, return the absolute difference between n and 21, except
	 * return double the absolute difference if n is over 21.
	 * 
	 * diff21(19) → 2
	 * 
	 * diff21(10) → 11
	 * 
	 * diff21(21) → 0
	 */
	public int diff21(int n) {
		int result = Math.abs(n - 21);
		if (n > 21) {
			result *= 2;
		}
		return result;
	}

	/*
	 * http://codingbat.com/prob/p140449
	 * 
	 * We have a loud talking parrot. The "hour" parameter is the current hour
	 * time in the range 0..23. We are in trouble if the parrot is talking and
	 * the hour is before 7 or after 20. Return true if we are in trouble.
	 * 
	 * parrotTrouble(true, 6) → true
	 * 
	 * parrotTrouble(true, 7) → false
	 * 
	 * parrotTrouble(false, 6) → false
	 */
	public boolean parrotTrouble(boolean talking, int hour) {
		return talking && (hour < 7 || hour > 20);
	}

	/*
	 * http://codingbat.com/prob/p182873
	 * 
	 * Given 2 ints, a and b, return true if one if them is 10 or if their sum
	 * is 10.
	 * 
	 * makes10(9, 10) → true
	 * 
	 * makes10(9, 9) → false
	 * 
	 * makes10(1, 9) → true
	 */
	public boolean makes10(int a, int b) {
		return a == 10 || b == 10 || a + b == 10;
	}

	/*
	 * http://codingbat.com/prob/p184004
	 * 
	 * Given an int n, return true if it is within 10 of 100 or 200. Note:
	 * Math.abs(num) computes the absolute value of a number.
	 * 
	 * nearHundred(93) → true
	 * 
	 * nearHundred(90) → true
	 * 
	 * nearHundred(89) → false
	 */
	public boolean nearHundred(int n) {
		return Math.abs(100 - n) <= 10 || Math.abs(200 - n) <= 10;
	}

	/*
	 * http://codingbat.com/prob/p159227
	 * 
	 * Given 2 int values, return true if one is negative and one is positive.
	 * Except if the parameter "negative" is true, then return true only if both
	 * are negative.
	 * 
	 * posNeg(1, -1, false) → true
	 * 
	 * posNeg(-1, 1, false) → true
	 * 
	 * posNeg(-4, -5, true) → true
	 */
	public boolean posNeg(int a, int b, boolean negative) {
		if (negative) {
			return a < 0 && b < 0;
		} else {
			return a * b < 0;
		}
	}

	/*
	 * http://codingbat.com/prob/p191914
	 * 
	 * Given a string, return a new string where "not " has been added to the
	 * front. However, if the string already begins with "not", return the
	 * string unchanged. Note: use .equals() to compare 2 strings.
	 * 
	 * notString("candy") → "not candy"
	 * 
	 * notString("x") → "not x"
	 * 
	 * notString("not bad") → "not bad"
	 */
	public String notString(String str) {
		if (str.startsWith("not")) {
			return str;
		}
		return "not " + str;
	}

	/*
	 * http://codingbat.com/prob/p190570
	 * 
	 * Given a non-empty string and an int n, return a new string where the char
	 * at index n has been removed. The value of n will be a valid index of a
	 * char in the original string (i.e. n will be in the range
	 * 0..str.length()-1 inclusive).
	 * 
	 * missingChar("kitten", 1) → "ktten"
	 * 
	 * missingChar("kitten", 0) → "itten"
	 * 
	 * missingChar("kitten", 4) → "kittn"
	 */
	public String missingChar(String str, int n) {
		return str.substring(0, n) + str.substring(n + 1);
	}

	/*
	 * http://codingbat.com/prob/p123384
	 * 
	 * Given a string, return a new string where the first and last chars have
	 * been exchanged.
	 * 
	 * frontBack("code") → "eodc"
	 * 
	 * frontBack("a") → "a"
	 * 
	 * frontBack("ab") → "ba"
	 */
	public String frontBack(String str) {
		if (str.length() < 2) {
			return str;
		}
		return str.substring(str.length() - 1)
				+ str.substring(1, str.length() - 1) + str.substring(0, 1);
	}

	/*
	 * http://codingbat.com/prob/p136351
	 * 
	 * Given a string, we'll say that the front is the first 3 chars of the
	 * string. If the string length is less than 3, the front is whatever is
	 * there. Return a new string which is 3 copies of the front.
	 * 
	 * front3("Java") → "JavJavJav"
	 * 
	 * front3("Chocolate") → "ChoChoCho"
	 * 
	 * front3("abc") → "abcabcabc"
	 */
	public String front3(String str) {
		String front = str.length() < 3 ? str : str.substring(0, 3);
		return front + front + front;
	}

	/*
	 * http://codingbat.com/prob/p161642
	 * 
	 * Given a string, take the last char and return a new string with the last
	 * char added at the front and back, so "cat" yields "tcatt". The original
	 * string will be length 1 or more.
	 * 
	 * backAround("cat") → "tcatt"
	 * 
	 * backAround("Hello") → "oHelloo"
	 * 
	 * backAround("a") → "aaa"
	 */
	public String backAround(String str) {
		return str.substring(str.length() - 1) + str
				+ str.substring(str.length() - 1);
	}

	/*
	 * http://codingbat.com/prob/p183592
	 * 
	 * Given a string, take the first 2 chars and return the string with the 2
	 * chars added at both the front and back, so "kitten" yields"kikittenki".
	 * If the string length is less than 2, use whatever chars are there.
	 * 
	 * front22("kitten") → "kikittenki"
	 * 
	 * front22("Ha") → "HaHaHa"
	 * 
	 * front22("abc") → "ababcab"
	 */
	public String front22(String str) {
		String front = str.length() < 2 ? str : str.substring(0, 2);
		return front + str + front;
	}

	/*
	 * http://codingbat.com/prob/p191022
	 * 
	 * Given a string, return true if the string starts with "hi" and false
	 * otherwise.
	 * 
	 * startHi("hi there") → true
	 * 
	 * startHi("hi") → true
	 * 
	 * startHi("hello hi") → false
	 */
	public boolean startHi(String str) {
		return str.startsWith("hi");
	}

	/*
	 * http://codingbat.com/prob/p192082
	 * 
	 * Given two temperatures, return true if one is less than 0 and the other
	 * is greater than 100.
	 * 
	 * icyHot(120, -1) → true
	 * 
	 * icyHot(-1, 120) → true
	 * 
	 * icyHot(2, 120) → false
	 */
	public boolean icyHot(int temp1, int temp2) {
		return Math.min(temp1, temp2) < 0 && Math.max(temp1, temp2) > 100;
	}

	/*
	 * http://codingbat.com/prob/p144535
	 * 
	 * Given 2 int values, return true if either of them is in the range 10..20
	 * inclusive.
	 * 
	 * in1020(12, 99) → true
	 * 
	 * in1020(21, 12) → true
	 * 
	 * in1020(8, 99) → false
	 */
	public boolean in1020(int a, int b) {
		return (a >= 10 && a <= 20) || (b >= 10 && b <= 20);
	}

	/*
	 * http://codingbat.com/prob/p178986
	 * 
	 * We'll say that a number is "teen" if it is in the range 13..19 inclusive.
	 * Given 3 int values, return true if 1 or more of them are teen.
	 * 
	 * hasTeen(13, 20, 10) → true
	 * 
	 * hasTeen(20, 19, 10) → true
	 * 
	 * hasTeen(20, 10, 13) → true
	 */
	public boolean hasTeen(int a, int b, int c) {
		if (a >= 13 && a <= 19) {
			return true;
		}
		if (b >= 13 && b <= 19) {
			return true;
		}
		if (c >= 13 && c <= 19) {
			return true;
		}
		return false;
	}

	/*
	 * http://codingbat.com/prob/p165701
	 * 
	 * We'll say that a number is "teen" if it is in the range 13..19 inclusive.
	 * Given 2 int values, return true if one or the other is teen, but not
	 * both.
	 * 
	 * loneTeen(13, 99) → true
	 * 
	 * loneTeen(21, 19) → true
	 * 
	 * loneTeen(13, 13) → false
	 */
	public boolean loneTeen(int a, int b) {
		int i = 0;
		if (a >= 13 && a <= 19) {
			i++;
		}
		if (b >= 13 && b <= 19) {
			i++;
		}
		return i == 1;
	}

	/*
	 * http://codingbat.com/prob/p100905
	 * 
	 * Given a string, if the string "del" appears starting at index 1, return a
	 * string where that "del" has been deleted. Otherwise, return the string
	 * unchanged.
	 * 
	 * delDel("adelbc") → "abc"
	 * 
	 * delDel("adelHello") → "aHello"
	 * 
	 * delDel("adedbc") → "adedbc"
	 */
	public String delDel(String str) {
		if (str.indexOf("del") != 1) {
			return str;
		}
		return str.substring(0, 1) + str.substring(4);
	}

	/*
	 * http://codingbat.com/prob/p151713
	 * 
	 * Return true if the given string begins with "mix", except the 'm' can be
	 * anything, so "pix", "9ix" .. all count.
	 * 
	 * mixStart("mix snacks") → true
	 * 
	 * mixStart("pix snacks") → true
	 * 
	 * mixStart("piz snacks") → false
	 */
	public boolean mixStart(String str) {
		return str.indexOf("ix") == 1;
	}

	/*
	 * http://codingbat.com/prob/p199720
	 * 
	 * Given a string, return a string made of the first 2 chars (if present),
	 * however include first char only if it is 'o' and include the second only
	 * if it is 'z', so "ozymandias" yields "oz".
	 * 
	 * startOz("ozymandias") → "oz"
	 * 
	 * startOz("bzoo") → "z"
	 * 
	 * startOz("oxx") → "o"
	 */
	public String startOz(String str) {
		String result = "";
		if (str.length() >= 1 && str.charAt(0) == 'o') {
			result += "o";
		}
		if (str.length() >= 2 && str.charAt(1) == 'z') {
			result += "z";
		}
		return result;
	}

	/*
	 * http://codingbat.com/prob/p101887
	 * 
	 * Given three int values, A B C, return the largest.
	 * 
	 * intMax(1, 2, 3) → 3
	 * 
	 * intMax(1, 3, 2) → 3
	 * 
	 * intMax(3, 2, 1) → 3
	 */
	public int intMax(int a, int b, int c) {
		int m1 = Math.max(a, b);
		return Math.max(m1, c);
	}

	/*
	 * http://codingbat.com/prob/p172021
	 * 
	 * Given 2 int values, return whichever value is nearest to the value 10, or
	 * return 0 in the event of a tie. Note that Math.abs(n) returns the
	 * absolute value of a number.
	 * 
	 * close10(8, 13) → 8
	 * 
	 * close10(13, 8) → 8
	 * 
	 * close10(13, 7) → 0
	 */
	public int close10(int a, int b) {
		if (Math.abs(10 - a) == Math.abs(10 - b)) {
			return 0;
		}
		return Math.abs(10 - a) < Math.abs(10 - b) ? a : b;
	}

	/*
	 * http://codingbat.com/prob/p132134
	 * 
	 * Given 2 int values, return true if they are both in the range 30..40
	 * inclusive, or they are both in the range 40..50 inclusive.
	 * 
	 * in3050(30, 31) → true
	 * 
	 * in3050(30, 41) → false
	 * 
	 * in3050(40, 50) → true
	 */
	public boolean in3050(int a, int b) {
		if (a >= 30 && a <= 40) {
			if (b >= 30 && b <= 40) {
				return true;
			}
		}

		if (a >= 40 && a <= 50) {
			if (b >= 40 && b <= 50) {
				return true;
			}
		}

		return false;
	}

	/*
	 * http://codingbat.com/prob/p177372
	 * 
	 * Given 2 positive int values, return the larger value that is in the range
	 * 10..20 inclusive, or return 0 if neither is in that range.
	 * 
	 * max1020(11, 19) → 19
	 * 
	 * max1020(19, 11) → 19
	 * 
	 * max1020(11, 9) → 11
	 */
	public int max1020(int a, int b) {
		int r = 0;
		if (a >= 10 && a <= 20) {
			r = Math.max(r, a);
		}
		if (b >= 10 && b <= 20) {
			r = Math.max(r, b);
		}
		return r;
	}

	/*
	 * http://codingbat.com/prob/p173784
	 * 
	 * Return true if the given string contains between 1 and 3 'e' chars.
	 * 
	 * stringE("Hello") → true
	 * 
	 * stringE("Heelle") → true
	 * 
	 * stringE("Heelele") → false
	 */
	public boolean stringE(String str) {
		int d = str.length() - str.replaceAll("e", "").length();
		return (d >= 1 && d <= 3);
	}

	/*
	 * http://codingbat.com/prob/p125339
	 * 
	 * Given two non-negative int values, return true if they have the same last
	 * digit, such as with 27 and 57. Note that the % "mod" operator computes
	 * remainders, so 17 % 10 is 7.
	 * 
	 * lastDigit(7, 17) → true
	 * 
	 * lastDigit(6, 17) → false
	 * 
	 * lastDigit(3, 113) → true
	 */
	public boolean lastDigit(int a, int b) {
		return a % 10 == b % 10;
	}

	/*
	 * http://codingbat.com/prob/p125268
	 * 
	 * Given a string, return a new string where the last 3 chars are now in
	 * upper case. If the string has less than 3 chars, uppercase whatever is
	 * there. Note that str.toUpperCase() returns the uppercase version of a
	 * string.
	 * 
	 * endUp("Hello") → "HeLLO"
	 * 
	 * endUp("hi there") → "hi thERE"
	 * 
	 * endUp("hi") → "HI"
	 */
	public String endUp(String str) {
		if (str.length() <= 3) {
			return str.toUpperCase();
		}
		return str.substring(0, str.length() - 3)
				+ str.substring(str.length() - 3).toUpperCase();
	}

	/*
	 * http://codingbat.com/prob/p196441
	 * 
	 * Given a non-empty string and an int N, return the string made starting
	 * with char 0, and then every Nth char of the string. So if N is 3, use
	 * char 0, 3, 6, ... and so on. N is 1 or more.
	 * 
	 * everyNth("Miracle", 2) → "Mrce"
	 * 
	 * everyNth("abcdefg", 2) → "aceg"
	 * 
	 * everyNth("abcdefg", 3) → "adg"
	 */
	public String everyNth(String str, int n) {
		return str.replaceAll(String.format("(.).{0,%d}", n - 1), "$1");
	}

	/*
	 * http://blog.racket-lang.org/2012/10/the-3n1-problem_4990.html
	 * http://xkcd.com/710/ http://en.wikipedia.org/wiki/Collatz_conjecture
	 * 
	 * Consider a positive number n. The cycle length of n is the number of
	 * times we repeat the following, until we reach n=1:
	 * 
	 * - If n is odd, then n ⇐ 3n+1
	 * 
	 * - If n is even, then n ⇐ n/2
	 * 
	 * For example, given n=22, we see the following sequence: 22 11 34 17 52 26
	 * 13 40 20 10 5 16 8 4 2 1. The cycle length of 22 is, therefore, 15, since
	 * it took 16 repetitions to get to 1.
	 */
	public int collatzCycleLength(int n) {
		int steps = 0;
		int value = n;
		while (value != 1) {
			if (value % 2 != 0) {
				value = 3 * value + 1;
			} else {
				value = value / 2;
			}
			steps++;
		}
		return steps;
	}
}
