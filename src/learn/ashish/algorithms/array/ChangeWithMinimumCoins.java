package learn.ashish.algorithms.array;

public class ChangeWithMinimumCoins {

    public static void main(String[] args) {
        // available coins 1, 2, 5
        int[] coins = {1, 2, 5};
        int money = 9;

        System.out.println(new ChangeWithMinimumCoins().findByDPImproved(money, coins));
    }

    /**
     * to find change for n, take minimum from i-1, i-2 and i-5 and add 1.
     * why (i - 1) + 1: suppose you are finding change for $10, its as good as finding change for $9 and add $1
     * why (i - 2) + 1: suppose you are finding change for $10, its as good as finding change for $8 and add $2
     * why (i - 5) + 1: suppose you are finding change for $10, its as good as finding change for $5 and add $5
     * <p>
     * Time: O[len(coins) * money]
     * Space: O[money]
     */
    public int findByDPImproved(int money, int[] coins) {
        int[] dp = new int[money + 1];
        dp[0] = 0;

        for (int i = 1; i < dp.length; i++) {
            dp[i] = Integer.MAX_VALUE;

            for (int j = 0; j < coins.length; j++)
                if (i - coins[j] >= 0)
                    dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
        }

        return dp[money];
    }
}
