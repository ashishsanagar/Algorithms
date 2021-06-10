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

        if (nums == null || nums.length == 0)
            return result;

        Arrays.sort(nums);

        for (int i = 0; i < nums.length && nums[i] <= 0; i++) {
            if (i == 0 || nums[i - 1] != nums[i])
                twoSum(nums, i, result);
        }

        return result;
    }

    private void twoSum(int[] nums, int index, List<List<Integer>> result) {
        int low = index + 1;
        int high = nums.length - 1;

        while (low < high) {
            int sum = nums[index] + nums[low] + nums[high];

            if (sum < 0)
                ++low;
            else if (sum > 0)
                --high;
            else {
                result.add(Arrays.asList(nums[index], nums[low++], nums[high--]));

                while (low < high && nums[low] == nums[low - 1])
                    low++;
            }
        }
    }
}
