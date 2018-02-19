
package com.ashish.algorithms.sorting;

/**
 * @author asanagar
 */
public class MergeSort {

	/**
	 * Divide and conquer using recursion
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

		megeSort(array);

		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + ", ");
		}
	}

	private static void megeSort(int[] array) {

		int length = array.length;

		if (length < 2) {
			return;
		}

		int mid = length / 2;
		int[] leftArray = new int[mid];
		int[] rightArray = new int[length - mid];

		for (int i = 0; i < mid; i++) {
			leftArray[i] = array[i];
		}

		for (int i = mid; i < length; i++) {
			rightArray[i - mid] = array[i];
		}

		megeSort(leftArray);
		megeSort(rightArray);
		merge(array, leftArray, rightArray);
	}

	private static void merge(int[] array, int[] arrayLeft, int[] arrayRight) {

		int leftLength = arrayLeft.length;
		int rightLenght = arrayRight.length;

		int i = 0;
		int j = 0;
		int k = 0;

		while (i < leftLength && j < rightLenght) {
			if (arrayLeft[i] < arrayRight[j]) {
				array[k] = arrayLeft[i];
				i++;
			} else {
				array[k] = arrayRight[j];
				j++;
			}
			k++;
		}

		while (i < leftLength) {
			array[k] = arrayLeft[i];
			k++;
			i++;
		}

		while (j < leftLength) {
			array[k] = arrayRight[j];
			k++;
			j++;
		}
	}

}
