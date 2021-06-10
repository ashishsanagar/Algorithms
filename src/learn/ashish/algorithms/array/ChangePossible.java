package learn.ashish.algorithms.array;

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

        System.out.println(new ChangePossible().recurse(17, denominations, 0));
    }

    public boolean recurse(int money, int[] coins, int index) {
        if (money == 0)
            return true;

        for (int i = index; i < coins.length; i++)
            if (money - coins[i] >= 0 && recurse(money - coins[i], coins, i))
                return true;

        return false;
    }

    public boolean find(int[] coins, int money) {
        boolean dp[][] = new boolean[coins.length + 1][money + 1];

        dp[0][0] = true;

        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                if (coins[i - 1] <= j)
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - coins[i - 1]];
                else
                    dp[i][j] = dp[i - 1][j];
            }
        }

        return dp[coins.length][money];
    }
}
