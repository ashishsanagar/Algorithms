package learn.ashish.algorithms.array;

import java.util.Arrays;

/**
 * @author Ashish Sanagar
 */
public class MartixRowsColumnsZeroIfElementIsZero {

    public static void main(String[] args) {
        int matrix[][] = {{1, 2, 3},
                {4, 0, 6},
                {7, 8, 9}};

        System.out.println("Original");
        printMatrix(matrix);

        new MartixRowsColumnsZeroIfElementIsZero().replaceRowColumns(matrix);
        System.out.println("After");
        printMatrix(matrix);

    }

    private static void printMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++)
            System.out.println(Arrays.toString(matrix[i]));
    }

    public void replaceRowColumns(int[][] matrix) {
        int[] rows = new int[matrix.length];
        int[] column = new int[matrix[0].length];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    rows[i] = 1;
                    column[j] = 1;
                }
            }
        }

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (rows[i] == 1 || column[j] == 1)
                    matrix[i][j] = 0;
            }
        }
    }
}
