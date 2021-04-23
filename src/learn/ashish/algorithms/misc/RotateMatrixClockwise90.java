package learn.ashish.algorithms.misc;

public class RotateMatrixClockwise90 {

    public static void main(String[] args) {
        long[][] input = {{1, 2}, {3, 4}};

        long[][] rotated = new RotateMatrixClockwise90().solution(input);

        for (int i = 0; i < rotated.length; i++) {
            for (int j = 0; j < rotated[0].length; j++) {
                System.out.print(rotated[i][j] + "  ");
            }

            System.out.println();
        }
    }

    public long[][] solution(long[][] matrix) {
        int n = matrix.length;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - i; j++) {
                long temp = matrix[i][j];
                matrix[i][j] = matrix[n - 1 - j][n - 1 - i];
                matrix[n - 1 - j][n - 1 - i] = temp;
            }
        }

        for (int i = 0; i < n / 2; i++) {
            for (int j = 0; j < n; j++) {
                long temp = matrix[i][j];
                matrix[i][j] = matrix[n - 1 - i][j];
                matrix[n - 1 - i][j] = temp;
            }
        }

        return matrix;
    }
}
