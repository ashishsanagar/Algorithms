package com.ashish.algorithms.sorting;

/**
 * @author Ashish Sanagar
 */
public class InsertionSort {

	/**
	 * in-place insertion of values from index 1. Consider first element is sorted
	 * and insert elements from index 1 and so on in left sorted array
	 */
	public static void main(String[] args) {


		int[] array = {
				1,
				5,
				8,
				9,
				3,
				2,
				7,
				4
		};

		new InsertionSort().insertionSort(array);

		for (Integer val : array) {
			System.out.print(val + " ");
		}

	}

	public void insertionSort(int[] array) {

		int length = array.length;

		for (int i = 1; i < length; i++) {

			int value = array[i];
			int hole = i;

			while (hole > 0 && array[hole - 1] > value) {
				array[hole] = array[hole - 1];
				hole--;
			}

			array[hole] = value;
		}
	}
}
