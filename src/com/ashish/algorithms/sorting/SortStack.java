package com.ashish.algorithms.sorting;

import java.util.Stack;

/**
 * @author Ashish Sanagar
 */
public class SortStack {

	/**
	 * Sort elements from given stack using only one extra stack
	 */
	public static void main(String[] args) {
		Stack<Integer> stack = new Stack<>();

		stack.push(4);
		stack.push(7);
		stack.push(1);
		stack.push(10);
		stack.push(6);

		Stack<Integer> sortedStack = sortStackElements(stack);

		while (sortedStack.isEmpty() == false) {
			System.out.print(sortedStack.pop() + " ");
		}
	}

	private static Stack<Integer> sortStackElements(Stack<Integer> stack) {
		if (stack == null || stack.isEmpty()) {
			return stack;
		}

		Stack<Integer> sortedStack = new Stack<>();

		while (stack.isEmpty() == false) {
			int temp = stack.pop();

			while (sortedStack.isEmpty() == false && temp > sortedStack.peek()) {
				stack.push(sortedStack.pop());
			}

			sortedStack.push(temp);
		}

		return sortedStack;
	}

}
