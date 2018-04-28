package com.ashish.algorithms.sorting;

/**
 * @author Ashish Sanagar
 */
public class BubbleSort {

	public static void main(String[] a) {
		int[] x = {
				12,
				35,
				87,
				26,
				9,
				28,
				7
		};

		new BubbleSort().sort(x);
	}

	public void sort(int[] x) {
		int n = x.length;

		for (int i = 0; i < n; i++) {
			for (int j = 1; j < (n - i); j++) {
				// every iteration to move one element to n, n-1 ... position
				if (x[j - 1] > x[j]) {
					int temp = x[j - 1];
					x[j - 1] = x[j];
					x[j] = temp;
				}
			}
		}

		for (int i = 0; i < x.length; i++) {
			System.out.print(x[i] + " ");
		}
	}
}
