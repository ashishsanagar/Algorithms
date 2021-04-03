package com.ashish.algorithms.array;

import java.util.HashMap;

/**
 * @author Ashish Sanagar
 */
public class TwoSumArrayReturnIndices {

    /**
     * Given an array of integers, return indices of the two numbers such that they add up to a specific target sum.
     */
    public static void main(String a[]) {
        int[] array = {3, 2, 5, 8, 4, 9, 1};
        int targetSum = 17;

        int[] result = new TwoSumArrayReturnIndices().twoSum(array, targetSum);

        if (result != null && result.length > 1) {
            System.out.println("indices: " + result[0] + " " + result[1]);
        }
    }

    public int[] twoSum(int[] nums, int target) {
        HashMap map = new HashMap();

        for (int i = 0; i < nums.length; i++) {
            if (map.get(nums[i]) != null) {
                int[] result = new int[2];
                result[0] = (Integer) map.get(nums[i]);
                result[1] = i;
                return result;
            }
            map.put(target - nums[i], i);
        }

        return null;
    }
}
