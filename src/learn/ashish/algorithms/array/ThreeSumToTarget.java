package learn.ashish.algorithms.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSumToTarget {

    /**
     * input
     * [-1,0,1,2,-1,-4]
     * <p>
     * Expected
     * [[-1,-1,2],[-1,0,1]]
     */
    public static void main(String[] args) {
        int[] input = {-1, 0, 1, 2, -1, -4};
        List<List<Integer>> result = new ThreeSumToTarget().threeSum(input);

        System.out.println(result.toString());
    }

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();

        if (nums.length < 3)
            return result;

        find(nums, result);

        return result;
    }

    private void find(int[] nums, List<List<Integer>> result) {
        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {
            int left = i + 1;
            int right = nums.length - 1;

            int target = 0 - nums[i];

            while (left < right) {
                int sum = nums[left] + nums[right];

                if (sum == target) {
                    List<Integer> ans = new ArrayList<>();
                    ans.add(nums[i]);
                    ans.add(nums[left]);
                    ans.add(nums[right]);

                    if (!result.contains(ans))
                        result.add(ans);

                    left++;
                    right--;
                } else if (sum > target)
                    right--;
                else
                    left++;
            }
        }
    }
}
