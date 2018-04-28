package com.ashish.algorithms.array;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Ashish Sanagar
 */
public class MatrixToSpiral {

	public static void main(String[] args) {

		int[][] matrix = {
				{1, 2, 3},
				{4, 5, 6},
				{7, 8, 9}};

		List<Integer> result = new MatrixToSpiral().matrixToSpiral(matrix);

		for (Integer val : result) {
			System.out.print(val + " ");
		}
	}

	public List<Integer> matrixToSpiral(int[][] matrix) {
		List<Integer> result = new ArrayList<>();

		if (matrix == null || matrix.length == 0) {
			return result;
		}

		int columns = matrix[0].length;
		int rows = matrix.length;
		int x = 0, y = 0;

		while (rows > 0 && columns > 0) {

			if (rows == 1) {
				for (int i = 0; i < rows; i++) {
					result.add(matrix[x++][y]);
				}
				break;
			}

			if (columns == 1) {
				for (int i = 0; i < columns; i++) {
					result.add(matrix[x][y++]);
				}
				break;
			}

			//move right
			for (int i = 0; i < columns - 1; i++) {
				result.add(matrix[x][y++]);
			}

			//move down
			for (int i = 0; i < rows - 1; i++) {
				result.add(matrix[x++][y]);
			}

			//move left
			for (int i = 0; i < columns - 1; i++) {
				result.add(matrix[x][y--]);
			}

			//move up
			for (int i = 0; i < rows - 1; i++) {
				result.add(matrix[x--][y]);
			}

			rows = rows - 2;
			columns = columns - 2;
			x++;
			y++;
		}
		return result;
	}
}