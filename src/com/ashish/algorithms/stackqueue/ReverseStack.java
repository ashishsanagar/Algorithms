package com.ashish.algorithms.stackqueue;

import com.sun.tools.javac.util.Assert;

import java.util.Stack;

/**
 * @author Ashish Sanagar
 */
public class ReverseStack {

	/**
	 * Reverse stack without using additional data structures
	 */
	public static void main(String[] args) {
		Stack<Integer> stack = new Stack<>();
		stack.push(1);
		stack.push(2);
		stack.push(3);

		stack = reverseStack(stack);

		Assert.check(stack.pop() == 1);
	}

	private static Stack<Integer> reverseStack(Stack<Integer> stack) {
		if (stack.isEmpty()) return stack;

		int temp = stack.pop();
		System.out.println("in reverseStack: temp=" + temp);

		reverseStack(stack);
		System.out.println("calling insertAtBottom: temp=" + temp);
		insertAtBottom(stack, temp);

		return stack;
	}

	private static void insertAtBottom(Stack<Integer> stack, int x) {
		if (stack.isEmpty()) {
			stack.push(x);
			return;
		}

		int temp = stack.pop();
		insertAtBottom(stack, temp);
		stack.push(temp);
	}
}
