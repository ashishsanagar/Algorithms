package com.ashish.algorithms.array;

/**
 * @author Ashish Sanagar
 */
public class MaxSubArray {

	public static void main(String[] args) {

		int[] array = {-2, 1, -3, 4, -1, 2, 1, -5, 4};

		int max = new MaxSubArray().findMax(array);
		System.out.println(max);
	}

	public int findMax(int[] array) {
		int sum = array[0];
		int max = array[0];

		for (int i = 1; i < array.length; i++) {
			sum = Math.max(sum + array[i], array[i]);
			max = Math.max(max, sum);
		}

		return max;
	}
}