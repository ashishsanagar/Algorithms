package com.ashish.algorithms.strings;

/**
 * @author Ashish Sanagar
 */
public class HasAllUniqueChars {

	public static void main(String[] args) {

		System.out.println(hasAllUniqueChars("abcdef"));
		System.out.println(hasAllUniqueChars("aaabbs"));

		System.out.println(hasAllUniqueCharsImproved("abcc"));
	}

	private static boolean hasAllUniqueChars(String str) {
		boolean[] visted = new boolean[256];

		for (char c : str.toCharArray()) {
			if (visted[c] == false) {
				visted[c] = true;
			} else {
				return false;
			}
		}

		return true;
	}

	private static boolean hasAllUniqueCharsImproved(String str) {

		int checker = 0;

		for (char c : str.toCharArray()) {

			int value = c - 'a';

			if ((checker & (1 << value)) > 0) {
				return false;
			}

			checker = checker | (1 << value);

			System.out.println("checker (" + c + ")=" + checker);
		}

		return true;
	}

}
