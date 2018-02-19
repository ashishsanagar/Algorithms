package com.ashish.algorithms.misc;

/**
 * @author Ashish Sanagar
 */
public class FindOneNumberRepatedOddTimes {
	public static void main(String[] args) {
		int[] a = {1, 1, 2, 3, 2, 2, 3, 5, 6, 5, 6};

		int odd = 0;
		for (int ele : a) {
			odd = odd ^ ele;
		}

		System.out.println("Odd number of times repeated ele: " + odd);
	}
}
