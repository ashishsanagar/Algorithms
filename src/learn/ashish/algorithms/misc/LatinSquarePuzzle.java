package learn.ashish.algorithms.misc;


class LatinSquarePuzzle {

    /**
     * 1,2,3
     * 2,3,1
     * 3,1,2
     * <p>
     * http://www.futoshiki.org/
     */
    public static void main(String[] args) {
        int[][] solution = new LatinSquarePuzzle().buildPuzzle(4);

        for (int i = 0; i < solution.length - 1; i++) {
            for (int j = 0; j < solution[i].length - 1; j++)
                System.out.print(solution[i][j] + " ");

            System.out.println();
        }
    }

    public int[][] buildPuzzle(int n) {
        int[][] array = new int[n + 1][n + 1];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                array[i][j] = ((i + 1) + j) % n;

                if (array[i][j] == 0)
                    array[i][j] = n;
            }
        }

        return array;
    }
}

