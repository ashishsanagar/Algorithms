package learn.ashish.algorithms.array;

/**
 * @author Ashish Sanagar
 */
public class FindMaximumProfitInBuySellTxn {

    /**
     * find max profit if input array contains stock prices.
     * <p>
     * 1. single txn
     * <p>
     * 2. all txns
     */
    public static void main(String[] args) {
        int[] prices = {2, 1, 5, 2, 6, 5};

        System.out.println("maxProfitSingleTxnV2=" + maxProfitSingleTxnV2(prices));

        System.out.println("maxProfitMultipleTxns=" + maxProfitAllTxns(prices));
    }

    /**
     * Buy at low and sell onces at peak
     *
     * @param prices
     * @return
     */
    private static int maxProfitSingleTxnV2(int[] prices) {
        int maxProfit = -1;
        int minPrice = Integer.MAX_VALUE;

        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < minPrice) {
                minPrice = prices[i];
            } else if (prices[i] - minPrice > maxProfit) {
                maxProfit = prices[i] - minPrice;
            }
        }

        return maxProfit;
    }

    /**
     * Sel
     *
     * @param prices
     * @return
     */
    private static int maxProfitAllTxns(int[] prices) {
        int maxprofit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1])
                maxprofit += prices[i] - prices[i - 1];
        }
        return maxprofit;
    }
}
