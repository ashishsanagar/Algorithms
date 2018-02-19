package com.ashish.algorithms.misc;

/**
 * @author Ashish Sanagar
 */
public class MultiplyTwoNumbersWithoutOperators {
	public static void main(String[] args) {
		int x = 20;
		int y = 10;

		int product = multiply(x,y);
		System.out.println(product);
	}

	private static int multiply(int x, int y) {

		if(x < y){
			int temp = x;
			x= y;
			y= temp;
		}

		int sum = 0;

		for(int i = 0; i<y; i++){
			sum +=x;
		}

		return sum;
	}
}

