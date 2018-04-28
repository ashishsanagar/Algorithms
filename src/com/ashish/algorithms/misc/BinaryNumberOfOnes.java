package com.ashish.algorithms.misc;

/**
 * @author Ashish Sanagar
 */
public class BinaryNumberOfOnes {

	/**
	 * For given integer x, find out if its convertde to binary then how many ones it will have
	 * <p>
	 * 6 = 0b110 - answer should be 2
	 */
	public static void main(String[] args) {
		int x = 6;

		new BinaryNumberOfOnes().convert(x);
	}

	public void convert(int x) {
		int sum = 0;

		while (x > 0) {
			sum = sum + (x % 2);
			x = x / 2;
		}

		System.out.println(sum);
	}
}
