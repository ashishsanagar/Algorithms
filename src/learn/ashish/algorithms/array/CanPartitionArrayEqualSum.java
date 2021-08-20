package learn.ashish.algorithms.array;

import java.util.HashMap;
import java.util.Map;

public class CanPartitionArrayEqualSum {

    /**
     * Input: nums = [1,5,11,5]
     * Output: true
     * Explanation: The array can be partitioned as [1, 5, 5] and [11].
     */
    public static void main(String[] args) {
        int[] nums = {1, 5, 11, 5};

        System.out.println(new CanPartitionArrayEqualSum().canPartitionRecursive(nums));
        System.out.println(new CanPartitionArrayEqualSum().canPartitionDP(nums));
    }

    /**
     * Time: O[n * m] -> m = sum of nb elements
     * Space: O[m]
     */
    public boolean canPartitionDP(int[] nums) {
        if (nums == null || nums.length == 0)
            return true;

        int total = 0;

        for (int num : nums)
            total += num;

        if (total % 2 != 0)
            return false;

        int target = total / 2;

        boolean[] dp = new boolean[target + 1];
        dp[0] = true;
        for (int i = 0; i < nums.length; i++) {
            for (int j = target; j >= nums[i]; j--) {
                dp[j] = dp[j] | dp[j - nums[i]];
            }
        }

        return dp[target];
    }

    /**
     * Time: O[2 ^ n]
     * Space: O[n] -> memoization hashtable
     */
    public boolean canPartitionRecursive(int[] nums) {
        int total = 0;
        for (int num : nums)
            total += num;

        if (total % 2 != 0)
            return false;

        Map<String, Boolean> memo = new HashMap<>();

        return find(nums, 0, 0, total / 2, memo);
    }

    public boolean find(int[] nums, int index, int currSum, int target, Map<String, Boolean> memo) {
        String key = index + ":" + currSum;

        if (memo.get(key) != null)
            return memo.get(key);

        if (currSum == target)
            return true;

        if (currSum > target || index >= nums.length)
            return false;

        boolean result = find(nums, index + 1, currSum + nums[index], target, memo) ||
                find(nums, index + 1, currSum, target, memo);

        memo.put(key, result);

        return result;
    }
}
