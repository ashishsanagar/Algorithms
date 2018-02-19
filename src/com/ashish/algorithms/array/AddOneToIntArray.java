package com.ashish.algorithms.array;

/**
 * @author Ashish Sanagar
 */
public class AddOneToIntArray {

	/**
	 * Given a integer array add one to its concatenated value.
	 * <p>
	 * [1,2,3,4] -> [1,2,3,5] [9,9,9,9] -> [1,0,0,0,0]
	 */
	public static void main(String[] args) {

		int[] a = {
				9,
				9,
				9,
				9
		};

		int carry = 0;

		for (int i = a.length - 1; i >= 0; i--) {
			int replaceNumber = a[i] + carry;

			if (i == a.length - 1) {
				replaceNumber = replaceNumber + 1;
			}

			if (replaceNumber < 10) {
				a[i] = replaceNumber;
				carry = 0;
				break;
			}

			a[i] = replaceNumber % 10;
			carry = replaceNumber / 10;
		}

		if (carry != 0) {
			int[] newArray = new int[a.length + 1];
			newArray[0] = carry;

			for (int i = 0; i < a.length; i++) {
				newArray[i + 1] = a[i];
			}

			for (int i = 0; i < newArray.length; i++) {
				System.out.print(newArray[i]);
			}
		} else {
			for (int i = 0; i < a.length; i++) {
				System.out.print(a[i]);
			}
		}
	}
}


