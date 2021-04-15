package com.ashish.algorithms.strings;

public class LongestCommonSubstringAndSubSequence {

    /**
     * if x and y are 2 strings, then find maximum length of common substring in x and sub-sequence in y
     * <p>
     * x: ashish
     * y: thisstringhas
     * answer: 4 (hish)
     *
     * @param args
     */
    public static void main(String[] args) {
        String x = "ashish";
        String y = "thisstringhas";

        System.out.println(new LongestCommonSubstringAndSubSequence().find(x, y));

    }

    public int find(String x, String y) {
        int max = 0;

        if (x == null || x.length() == 0) return 0;
        if (y == null || y.length() == 0) return 0;

        int[][] dp = new int[x.length() + 1][y.length() + 1];

        for (int i = 0; i < dp.length; i++)
            dp[i][0] = 0;

        for (int j = 0; j < dp[0].length; j++)
            dp[0][j] = 0;

        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                if (x.charAt(i - 1) == y.charAt(j - 1))
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                else
                    dp[i][j] = dp[i][j - 1];

                max = Math.max(max, dp[i][j]);
            }
        }

        return max;
    }

}
