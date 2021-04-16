package learn.ashish.algorithms.array;

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

        int maxSquare = new MaxLengthSquareFromMatrix().find(matrix);

        System.out.println("Max length square with only ones: " + maxSquare);
    }

    public int find(int[][] matrix) {
        int max = 0;

        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[0].length; j++) {

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
