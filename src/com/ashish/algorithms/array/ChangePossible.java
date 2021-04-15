package com.ashish.algorithms.array;

public class ChangePossible {

    /**
     * Given an unlimited supply of coins of denominations x1, x2, . . . , xn,
     * we wish to make change for a value v; that is, we wish to find a set of coins whose total value is v
     * <p>
     * Is it possible to make change for v using coins of denominations x1, . . . , xn?
     * <p>
     * Each coin used once
     *
     * @param args
     */
    public static void main(String[] args) {
        int[] denominations = {2, 5, 10};
        System.out.println(new ChangePossible().find(denominations, 8));

        System.out.println(new ChangePossible().find(denominations, 17));
    }

    public boolean find(int[] denominations, int v) {
        boolean dp[][] = new boolean[denominations.length + 1][v + 1];

        dp[0][0] = true;

        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                if (denominations[i - 1] <= j)
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - denominations[i - 1]];
                else
                    dp[i][j] = dp[i - 1][j];
            }
        }

        return dp[denominations.length][v];
    }
}
