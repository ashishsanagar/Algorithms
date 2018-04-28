package com.ashish.algorithms.strings;

/**
 * @author asanagar
 */
public class StringReverseLine {
	public static void main(String[] args) {
		String line = "reverse string java program.";

		StringReverseLine obj = new StringReverseLine();
		obj.reverseString1(line);
		obj.reverseString2(line);
	}

	public String reverseString1(String line) {
		String[] words = line.split(" \\,");
		String reverse = "";
		for (String word : words) {
			reverse += new StringBuilder(word).reverse();
		}

		System.out.println(reverse);

		return reverse;
	}

	public String reverseString2(String line) {
		String reverse = "";
		int len = line.length();

		for (int i = len - 1; i >= 0; i--) {
			reverse += line.charAt(i);
		}

		System.out.println(reverse);

		return reverse;
	}

}


