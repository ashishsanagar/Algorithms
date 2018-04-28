package com.ashish.algorithms.misc;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Ashish Sanagar
 */
public class ConvertToBase7 {

	/**
	 * 10 -> 13
	 */
	public static void main(String[] args) {
		int number = 10;

		new ConvertToBase7().convert(number);
	}

	public void convert(int number) {
		List<Integer> result = new ArrayList<>();

		while (number > 0) {
			result.add(number % 7);
			number = number / 7;
		}

		for (int i = result.size() - 1; i >= 0; i--) {
			System.out.print(result.get(i));
			//System.out.print(Character.toString((char)result.get(i).intValue()));
		}
	}
}