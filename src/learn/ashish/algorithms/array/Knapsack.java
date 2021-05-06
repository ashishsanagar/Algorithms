package learn.ashish.algorithms.array;

public class Knapsack {
    public static void main(String[] args) {
        int[] weights = {2, 4, 5};
        int[] values = {5, 1, 4};
        int capacity = 7;

        System.out.println(new Knapsack().solve(weights, values, capacity));
    }

    /**
     * choose weights <= capacity with maximum total value
     */
    private int solve(int[] weights, int[] values, int capacity) {
        if (weights.length != values.length || capacity < 1)
            return 0;

        int[][] dp = new int[values.length + 1][capacity + 1];

        for (int i = 1; i <= values.length; i++) {
            for (int j = 1; j <= capacity; j++) {
                // capacity is in range 0 to "capacity" input. we start from 1, which means
                // current available intermediate capacity minus weight, if its >0
                // chose max of value without addition of this weight and value if we add this current weight
                if (j - weights[i - 1] >= 0)
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - weights[i - 1]] + values[i - 1]);
                else
                    dp[i][j] = dp[i - 1][j];
            }
        }

        return dp[values.length][capacity];
    }
}
