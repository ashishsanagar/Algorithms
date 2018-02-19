package com.ashish.algorithms.misc;

/*
 * To execute Java, please define "static void main" on a class
 * named Solution.
 *
 * If you need more classes, simply define them inline.
 1,2,3
 2,3,1
 3,1,2

 http://www.futoshiki.org/
 */

class LatinSquarePuzzle {

	public static void main(String[] args) {
		int[][] solution = buildPuzzle(4);

		for (int i = 0; i < solution.length - 1; i++) {
			for (int j = 0; j < solution[i].length - 1; j++) {
				System.out.print(solution[i][j] + " , ");
			}

			System.out.println();
		}
	}

	private static int[][] buildPuzzle(int n) {
		int[][] array = new int[n + 1][n + 1];

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {

				array[i][j] = ((i + 1) + j) % n;

				if (array[i][j] == 0) {
					array[i][j] = n;
				}
			}
		}

		return array;
	}

}

  