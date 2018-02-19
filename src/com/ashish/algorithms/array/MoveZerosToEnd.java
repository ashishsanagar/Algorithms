package com.ashish.algorithms.array;

/**
 * @author Ashish Sanagar
 */
public class MoveZerosToEnd {

	public static void main(String[] args) {
		int[] a = {1, 0, 4, 0, 0, 8, 5, 7, 9, 0, 10};

		approachTwo(a);

	}

	private static void approachTwo(int[] a) {

		int i = -1;
		int j = 0;

		while (j < a.length) {

			if (a[j] != 0) {
				i++;

				int temp = a[j];
				a[j] = a[i];
				a[i] = temp;

			}

			j++;
		}

		for (int ele : a) {
			System.out.print(ele + " ");
		}
	}

	private static void approachOne(int[] a) {
		for (int i = 0; i < a.length; i++) {
			if (a[i] == 0) {
				for (int j = i + 1; j < a.length; j++) {
					a[j - 1] = a[j];
				}

				a[a.length - 1] = 0;
			}
		}

		for (int ele : a) {
			System.out.print(ele + " ");
		}
	}
}
