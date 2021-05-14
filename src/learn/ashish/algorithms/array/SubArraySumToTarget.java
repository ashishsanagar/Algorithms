package learn.ashish.algorithms.array;

import java.util.HashMap;
import java.util.Map;

public class SubArraySumToTarget {

    /**
     * Given an array of integers nums and an integer k, return the total number of continuous subarrays whose sum equals to k.
     * <p>
     * Input: nums = [1,1,1], k = 2
     * Output: 2
     * <p>
     * Note: there can be negative numbers in array
     */
    public static void main(String[] args) {
        int[] nums = {1, 0, 1, 2, -1}; // [1, 0, 1] [0, 1, 2, -1], [2], [1, 2, -1]

        System.out.println(new SubArraySumToTarget().find(nums, 2));
    }

    public int find(int[] nums, int k) {
        if (nums == null || nums.length == 0)
            return 0;

        Map<Integer, Integer> map = new HashMap<>();

        int count = 0;
        int currSum = 0;

        for (int num : nums) {
            currSum += num;

            if (currSum == k)
                count++;

            if (map.containsKey(currSum - k))
                count += map.get(currSum - k);

            map.put(currSum, map.getOrDefault(currSum, 0) + 1);
        }

        return count;
    }
}
