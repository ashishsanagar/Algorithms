package com.ashish.algorithms.array;

import java.util.HashMap;
import java.util.Map;

public class CanParitionArrayEqualSum {

    /**
     * Input: nums = [1,5,11,5]
     * Output: true
     * Explanation: The array can be partitioned as [1, 5, 5] and [11].
     *
     * @param args
     */
    public static void main(String[] args) {
        int[] nums = {1, 5, 11, 5};

        System.out.println(new CanParitionArrayEqualSum().canPartition(nums));
    }

    public boolean canPartition(int[] nums) {
        int total = 0;
        for (int num : nums) total += num;

        if (total % 2 != 0) return false;

        int sum = 0;

        Map<String, Boolean> memo = new HashMap<>();

        return find(nums, 0, sum, total, memo);
    }

    public boolean find(int[] nums, int index, int sum, int total, Map<String, Boolean> memo) {
        String key = index + ":" + sum;

        if (memo.get(key) != null) return memo.get(key);

        if (sum * 2 == total) return true;

        if (sum > total / 2 || index >= nums.length) return false;

        boolean result = find(nums, index + 1, sum + nums[index], total, memo) ||
                find(nums, index + 1, sum, total, memo);

        memo.put(key, result);

        return result;
    }
}
