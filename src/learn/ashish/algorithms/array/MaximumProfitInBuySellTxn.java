package learn.ashish.algorithms.array;

/**
 * @author Ashish Sanagar
 */
public class MaximumProfitInBuySellTxn {

    /**
     * find max profit if input array contains stock prices.
     * <p>
     * 1. single txn
     * <p>
     * 2. all txns
     */
    public static void main(String[] args) {
        int[] prices = {2, 1, 5, 2, 6, 5};

        System.out.println("single txn profit:" + maxProfitSingleTxnV2(prices));
        System.out.println("all txn profit: =" + maxProfitAllTxns(prices));
        System.out.println("k txn profit: " + maxProfitKTransactions(2, prices));
    }

    public static int maxProfitKTransactions(int k, int[] prices) {
        if (k == 0 || prices.length < 2)
            return 0;

        int[][] dp = new int[k + 1][prices.length];

        for (int i = 1; i < dp.length; i++) {
            int maxDiff = -prices[0];

            for (int j = 1; j < dp[i].length; j++) {
                dp[i][j] = Math.max(dp[i][j - 1], prices[j] + maxDiff);

                maxDiff = Math.max(maxDiff, dp[i - 1][j] - prices[j]);
            }
        }

        return dp[k][prices.length - 1];
    }

    /**
     * Buy at low and sell once at peak
     */
    private static int maxProfitSingleTxnV2(int[] prices) {
        if (prices.length < 2)
            return 0;

        int maxProfit = -1;
        int minPrice = prices[0];

        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < minPrice)
                minPrice = prices[i];
            else
                maxProfit = Math.max(maxProfit, prices[i] - minPrice);
        }

        return maxProfit;
    }

    /**
     * Sell if ith index value is less than i+1 th
     */
    private static int maxProfitAllTxns(int[] prices) {
        if (prices.length < 2)
            return 0;

        int maxprofit = 0;

        for (int i = 1; i < prices.length; i++)
            if (prices[i] > prices[i - 1])
                maxprofit += prices[i] - prices[i - 1];

        return maxprofit;
    }
}
