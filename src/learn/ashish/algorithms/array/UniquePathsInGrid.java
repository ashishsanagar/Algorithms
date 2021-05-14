package learn.ashish.algorithms.array;

public class UniquePathsInGrid {

    /**
     * Robot is located at top-left corner or m x n  grid, only move possible is right or down
     * <p>
     * how many unique paths are there to reach both
     */
    public static void main(String[] args) {
        int m = 3;
        int n = 2;

        System.out.println(new UniquePathsInGrid().find(m, n));
    }

    private int find(int m, int n) {
        int[][] dp = new int[m][n];

        //base case: every element in first row or column can be reached in unique one way as robot can move only up or down
        for (int i = 0; i < dp.length; i++)
            dp[i][0] = 1;
        for (int j = 0; j < dp[0].length; j++)
            dp[0][j] = 1;

        //recurrance relation dp[i][j] = dp[i][j-1] + dp[i-1][j]
        for (int i = 1; i < dp.length; i++)
            for (int j = 1; j < dp[0].length; j++)
                dp[i][j] = dp[i][j - 1] + dp[i - 1][j];

        return dp[m - 1][n - 1];
    }
}
