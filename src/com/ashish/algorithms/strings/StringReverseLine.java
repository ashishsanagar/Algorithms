package com.ashish.algorithms.strings;

/**
 * @author asanagar
 */
public class StringReverseLine {
	public static void main(String[] args) {
		String line = "reverse string java program.";

		reverseString1(line);
		reverseString2(line);
	}

	private static String reverseString1(String line) {
		String[] words = line.split(" \\,");
		String reverse = "";
		for (String word : words) {
			reverse += new StringBuilder(word).reverse();
		}

		System.out.println(reverse);

		return reverse;
	}

	private static String reverseString2(String line) {
		String reverse = "";
		int len = line.length();

		for (int i = len - 1; i >= 0; i--) {
			reverse += line.charAt(i);
		}

		System.out.println(reverse);

		return reverse;
	}

}


