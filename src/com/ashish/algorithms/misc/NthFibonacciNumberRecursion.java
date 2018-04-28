
package com.ashish.algorithms.misc;

/**
 * @author Ashish Sanagar
 */
public class NthFibonacciNumberRecursion {

	/**
	 * using recursion
	 */
	public static void main(String[] args) {
		int n = 8;
		System.out.println("nth number: " + new NthFibonacciNumberRecursion().fibonacci(n));
	}

	public int fibonacci(int n) {
		if (n == 1 || n == 2) {
			return 1;
		}

		return fibonacci(n - 1) + fibonacci(n - 2);
	}
}
