package com.ashish.algorithms.array;

/**
 * @author Ashish Sanagar
 */
public class MaxLengthSquareFromMatrix {

	public static void main(String[] args) {
		int[][] matrix = {
				{1, 0, 1, 1, 1},
				{1, 1, 1, 1, 1},
				{0, 1, 1, 1, 0},
				{1, 1, 1, 1, 1}};

		int number = findMaxSquareWithOnes(matrix);

		System.out.println("Max length square with only ones: " + number);
	}

	private static int findMaxSquareWithOnes(int[][] matrix) {
		int max = 0;

		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				if (i == 0 || j == 0) {
					continue;
				}

				if (matrix[i][j] == 1) {
					int lowFromNeighbors = Integer.min(Integer.min(matrix[i][j - 1], matrix[i - 1][j]), matrix[i - 1][j - 1]);
					int currentMax = lowFromNeighbors + 1;

					if (currentMax > max) {
						max = currentMax;
					}

					matrix[i][j] = currentMax;

				}
			}
		}

		return max;
	}
}
