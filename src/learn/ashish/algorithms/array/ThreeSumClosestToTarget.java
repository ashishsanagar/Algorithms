package learn.ashish.algorithms.array;

import java.util.Arrays;

public class ThreeSumClosestToTarget {

    /**
     * Given an integer array nums of length n and an integer target, find three integers in nums such that the sum is closest to target.
     * <p>
     * Input: nums = [-1,2,1,-4], target = 1
     * Output: 2
     * Explanation: The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
     */
    public static void main(String[] args) {
        System.out.println(threeSumClosest(new int[]{-1, 2, 1, -4}, 1));
    }


    public static int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);

        int closest = Integer.MAX_VALUE;

        for (int i = 0; i < nums.length && closest != 0; i++) {
            int left = i + 1;
            int right = nums.length - 1;

            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];

                if (Math.abs(closest) > Math.abs(target - sum))
                    closest = target - sum;
                else if (sum < target)
                    left++;
                else
                    right--;
            }
        }

        return target - closest;
    }
}
