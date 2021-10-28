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
        System.out.println(new ChangePossible().findDPRepeatCoins(denominations, 17));

        System.out.println(new ChangePossible().recurse(17, denominations, 0));
    }

    public boolean recurse(int money, int[] coins, int index) {
        if (money == 0)
            return true;
        if (money < 0)
            return false;

        for (int i = index; i < coins.length; i++)
            if (money - coins[i] >= 0 && recurse(money - coins[i], coins, i))
                return true;

        return false;
    }

    /**
     * Time: O[n * m]
     * Space: O[m]
     */
    public boolean findDPRepeatCoins(int[] coins, int money) {
        boolean dp[] = new boolean[money + 1];

        dp[0] = true;

        for (int i = 1; i < dp.length; i++) {
            for (int coin : coins) {
                if (i - coin >= 0)
                    dp[i] = dp[i] || dp[i - coin];
            }
        }

        return dp[money];
    }
}
