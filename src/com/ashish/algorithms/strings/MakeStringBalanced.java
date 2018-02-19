package com.ashish.algorithms.strings;

import java.util.Stack;

/*
Given a string with alpha-numeric characters and parentheses, return a string with balanced parentheses by removing the fewest characters possible. You cannot add anything to the string.

balance("()")->"()"
		balance("a(b)c)")->"a(b)c"
		balance(")(")->""

		balance("))(())")->"(())"
		balance("")->""
		balance("(((((")->""
		*/

public class MakeStringBalanced {

	public static void main(String[] args) {
		String str = "()()()a(b(c((";

		String result = balance(str);

		System.out.println(result);
	}

	private static String balance(String str) {
		if (str == null || str.length() < 1) {
			return str;
		}

		Stack<Integer> stack1 = new Stack<Integer>();
		Stack<Integer> stack2 = new Stack<Integer>();

		for (int i = 0; i < str.length(); i++) {
			char nextChar = str.charAt(i);

			if (nextChar == '(') {
				stack1.push(i);
			} else if (nextChar == ')') {
				if (stack1.size() > 0) {
					int fromStack = stack1.pop();

					if (str.charAt(fromStack) != '(') {
						stack2.push(i);
						stack2.push(fromStack);
					}
				} else {
					stack2.push(i);
				}
			}

		}

		while (stack1.size() > 0) {
			str = deleteChar(str, stack1.pop());
		}

		while (stack2.size() > 0) {
			str = deleteChar(str, stack2.pop());
		}

		return str;
	}

	private static String deleteChar(String str, int index) {
		return str.substring(0, index) + str.substring(index + 1);
	}

}