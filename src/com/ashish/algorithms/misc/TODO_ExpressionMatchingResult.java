package com.ashish.algorithms.misc;

/**
 * @author Ashish Sanagar
 */
public class TODO_ExpressionMatchingResult {
	/**
	 * given 4 element array, return true or false if there is expression to give X as result.
	 * <p>
	 * [2,1,4,3]
	 * (2+1+3) * 4 == 24
	 * <p>
	 * [2,8,8,9]
	 * ((2-(8-9))×8)=24
	 */
	public static void main(String[] args) {
		int[] a = {2, 1, 4, 3};

		int target = 24;

		findExpression(a, target);
	}

	private static void findExpression(int[] a, int target) {
		if ((a[0] + a[1] + a[2] + a[3]) > target) {

		}
	}
}
