package com.ashish.algorithms.strings;

/**
 * @author Ashish Sanagar
 */
public class ReplaceSpaceWithPercent20 {
	public static void main(String[] args) {

		String str = "a a"; // a%20a

		encodeString(str);
	}

	private static void encodeString(String str) {
		StringBuilder builder = new StringBuilder();

		for (char c : str.toCharArray()) {
			if (c == ' ') {
				builder.append("%20");
			} else {
				builder.append(c);
			}
		}

		System.out.println("result: " + builder.toString());

	}
}
