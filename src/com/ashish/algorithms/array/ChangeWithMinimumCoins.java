package com.ashish.algorithms.array;

public class ChangeWithMinimumCoins {

    public static void main(String[] args) {
        // available coins 1, 2, 5

        int money = 5;

        System.out.println(new ChangeWithMinimumCoins().find(money));
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
    public int find(int money) {
        int[] result = new int[money + 1];
        result[0] = 0;

        for (int i = 1; i < money + 1; i++) {
            result[i] = result[i - 1] + 1;

            if (i - 2 >= 0)
                result[i] = Math.min(result[i], result[i - 2] + 1);

            if (i - 5 >= 0)
                result[i] = Math.min(result[i], result[i - 5] + 1);
        }

        return result[money];
    }
}
