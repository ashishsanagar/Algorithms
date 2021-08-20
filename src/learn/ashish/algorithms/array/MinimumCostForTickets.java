package learn.ashish.algorithms.array;

import java.util.Arrays;

public class MinimumCostForTickets {

    /**
     * The days of the year that you will travel is given as an array days.  Each day is an integer from 1 to 365.
     * <p>
     * Train tickets are sold in 3 different ways:
     * <p>
     * a 1-day pass is sold for costs[0] dollars;
     * a 7-day pass is sold for costs[1] dollars;
     * a 30-day pass is sold for costs[2] dollars.
     * <p>
     * The passes allow that many days of consecutive travel.  For example, if we get a 7-day pass on day 2, then we can travel for 7 days: day 2, 3, 4, 5, 6, 7, and 8.
     * <p>
     * Return the minimum number of dollars you need to travel every day in the given list of days.
     * <p>
     * Input: days = [1,4,6,7,8,20], costs = [2,7,15]
     * Output: 11
     */
    public static void main(String[] args) {
        int[] days = {1, 4, 6, 7, 8, 20};
        int[] costs = {2, 7, 15};
        System.out.println(new MinimumCostForTickets().mincostTickets(days, costs));
    }

    public int mincostTickets(int[] days, int[] costs) {
        int n = days.length;
        int[] dp = new int[n + 1];

        for (int i = n - 1; i >= 0; --i) {
            int weekly = i;
            int monthly = i;
            int daily = i + 1;

            while (weekly < n && days[weekly] < days[i] + 7)
                ++weekly;
            while (monthly < n && days[monthly] < days[i] + 30)
                ++monthly;
            dp[i] = Math.min(costs[0] + dp[daily], Math.min(costs[1] + dp[weekly], costs[2] + dp[monthly]));

            System.out.println(weekly + ", " + monthly);
            System.out.println(Arrays.toString(dp));
        }

        return dp[0];
    }
}
