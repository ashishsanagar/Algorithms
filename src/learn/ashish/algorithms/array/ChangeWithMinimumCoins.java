package learn.ashish.algorithms.array;

public class ChangeWithMinimumCoins {

    public static void main(String[] args) {
        // available coins 1, 2, 5
        int[] coins = {1, 2, 5};
        int money = 9;

        System.out.println(new ChangeWithMinimumCoins().find(money, coins));

        System.out.println(new ChangeWithMinimumCoins().findByDP(money, coins));
    }

    /**
     * to find change for n, take minimum from i-1, i-2 and i-5 and add 1.
     * why (i - 1) + 1: suppose you are finding change for $10, its as good as finding change for $9 and add $1
     * why (i - 2) + 1: suppose you are finding change for $10, its as good as finding change for $8 and add $2
     * why (i - 5) + 1: suppose you are finding change for $10, its as good as finding change for $5 and add $5
     *
     * @param money
     * @return
     */
    public int find(int money, int[] coins) {
        int[] result = new int[money + 1];
        result[0] = 0;

        for (int i = 1; i < money + 1; i++) {
            result[i] = Integer.MAX_VALUE;

            for (int j = 0; j < coins.length; j++)
                if (i - coins[j] >= 0)
                    result[i] = Math.min(result[i], result[i - coins[j]] + 1);
        }

        return result[money];
    }

    public int findByDP(int money, int[] coins) {
        int[][] dp = new int[coins.length + 1][money + 1];

        for (int i = 0; i < dp[0].length; i++)
            dp[0][i] = Integer.MAX_VALUE;

        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                if (j - (coins[i - 1]) >= 0)
                    dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - coins[i - 1]] + 1);
                else
                    dp[i][j] = dp[i - 1][j];
            }
        }

        return dp[coins.length][money];
    }
}
