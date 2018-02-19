package com.ashish.algorithms.sorting;

/**
 * @author Ashish Sanagar
 */
public class SelectionSort {

	public static void main(String[] args) {
		int[] array = {5, 2, 8, 5, 9, 1};

		selectionSort(array);

		for (Integer val : array) {
			System.out.print(val + " ");
		}
	}

	private static void selectionSort(int[] array) {

		for (int i = 0; i < array.length; i++) {

			int iMin = i;

			for (int j = i + 1; j < array.length; j++) {
				if (array[j] < array[iMin]) {
					iMin = j;
				}
			}

			int temp = array[i];
			array[i] = array[iMin];
			array[iMin] = temp;
		}

	}
}
