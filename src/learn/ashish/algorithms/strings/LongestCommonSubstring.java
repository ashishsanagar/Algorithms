package learn.ashish.algorithms.strings;

public class LongestCommonSubstring {

    /**
     * x: ashish
     * y: thisstringhas
     * answer: 3 (his)
     */
    public static void main(String[] args) {
        String x = "ashish";
        String y = "thisstringhas";

        System.out.println(new LongestCommonSubstring().find(x, y));
    }

    public int find(String x, String y) {
        int max = 0;

        if (x == null || x.length() == 0 || y == null || y.length() == 0)
            return 0;

        int[][] dp = new int[x.length() + 1][y.length() + 1];

        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                if (x.charAt(i - 1) == y.charAt(j - 1))
                    dp[i][j] = dp[i - 1][j - 1] + 1;

                max = Math.max(max, dp[i][j]);
            }
        }

        return max;
    }

}
