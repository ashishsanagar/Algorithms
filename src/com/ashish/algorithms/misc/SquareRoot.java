package com.ashish.algorithms.misc;

/**
 * @author Ashish Sanagar
 */
public class SquareRoot {

	public static void main(String[] args) {

		int x = 4;

		System.out.println(new SquareRoot().sqrt(4));
	}

	public double sqrt(int x) {
		// Base Cases
		if (x == 0 || x == 1)
			return x;

		// Do Binary Search for floor(sqrt(x))
		int start = 1, end = x, ans = 0;

		while (start <= end) {

			int mid = (start + end) / 2;

			// If x is a perfect square
			if (mid * mid == x)
				return mid;

			// Since we need floor, we update answer when mid*mid is
			// smaller than x, and move closer to sqrt(x)
			if (mid * mid < x) {
				start = mid + 1;
				ans = mid;
			} else   // If mid*mid is greater than x
				end = mid - 1;
		}

		return ans;
	}
}
