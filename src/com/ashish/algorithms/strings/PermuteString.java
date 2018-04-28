package com.ashish.algorithms.strings;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Ashish Sanagar
 */
public class PermuteString {

	static Set<String> permutationSet = new HashSet<>();

	public static void main(String[] args) {

		new PermuteString().process("abcd", "");
	}

	public void process(String input, String chosen) {

		if (input.isEmpty()) {
			System.out.println(chosen);
			permutationSet.add(chosen);
		} else {
			for (int i = 0; i < input.length(); i++)
				process(input.substring(0, i) + input.substring(i + 1, input.length()), chosen + input.charAt(i));
		}
	}
}
