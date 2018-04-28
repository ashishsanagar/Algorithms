package com.ashish.algorithms.array;

import java.util.Stack;

/**
 * @author Ashish Sanagar
 */
public class MaxHistogramArea {

	/**
	 * 2      2
	 * \  1   \
	 * \  \   \
	 * \  \   \
	 * -----------------
	 */
	public static void main(String[] args) {
		int[] input = {2, 1, 2};

		int maxArea = new MaxHistogramArea().findMaxHistogramArea(input);
		System.out.println(maxArea);
	}

	private static int getMaxArea(Stack<Integer> stack, int[] input, int i, int maxArea) {
		int top = stack.pop();
		int area = 0;

		if (stack.isEmpty()) {
			area = input[top] * i;
		} else {
			area = input[top] * (i - stack.peek() - 1);
		}

		if (maxArea < area) {
			maxArea = area;
		}

		return maxArea;
	}

	public int findMaxHistogramArea(int[] input) {
		Stack<Integer> stack = new Stack<>();
		int maxArea = -1;
		int area = 0;

		int i = 0;

		while (i < input.length) {
			if (stack.isEmpty() || input[stack.peek()] <= input[i]) {
				stack.push(i++);
			} else {
				maxArea = getMaxArea(stack, input, i, maxArea);
			}
		}

		while (stack.isEmpty() == false) {
			maxArea = getMaxArea(stack, input, i, maxArea);
		}
		return maxArea;
	}
}
