package learn.ashish.algorithms.array;

/**
 * @author Ashish Sanagar
 */
public class RotateMatrix {

    public static void main(String[] args) {
        int matrix[][] = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}};

        System.out.println("Original");
        printMatrix(matrix);

        new RotateMatrix().rotate(matrix);
        System.out.println("Rotated");
        printMatrix(matrix);
    }

    private static void printMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++)
                System.out.print(matrix[i][j] + " ");

            System.out.println();
        }
    }

    public void rotate(int[][] matrix) {
        transposeMatrix(matrix);
        reverseColumns(matrix);
    }

    private void transposeMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = i; j < matrix[0].length; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
    }

    private void reverseColumns(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0, k = matrix[0].length - 1; j < k; j++, k--) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][k];
                matrix[i][k] = temp;
            }
        }
    }
}
