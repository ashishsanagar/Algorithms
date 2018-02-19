package com.ashish.algorithms.stackqueue;

import java.util.Stack;

/**
 * @author Ashish Sanagar
 */
public class SortStack {

	public static void main(String[] args) {
		Stack<Integer> s1 = new Stack<>();
		s1.push(3);
		s1.push(2);
		s1.push(9);

		sortStack(s1);
	}

	private static void sortStack(Stack<Integer> s1) {

		Stack<Integer> s2 = new Stack<>();

		while (s1.isEmpty() == false) {
			int temp = s1.pop();

			while (s2.isEmpty() == false && s2.peek() < temp) {
				s1.push(s2.pop());
			}

			s2.push(temp);
		}


		while (s2.isEmpty() == false) {
			System.out.print(s2.pop() + " ");
		}

	}
}
