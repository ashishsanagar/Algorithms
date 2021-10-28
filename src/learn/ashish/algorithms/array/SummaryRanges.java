package learn.ashish.algorithms.array;

import java.util.ArrayList;
import java.util.List;

public class SummaryRanges {

    /**
     * You are given a sorted unique integer array nums.
     * <p>
     * Return the smallest sorted list of ranges that cover all the numbers in the array exactly. That is, each element
     * of nums is covered by exactly one of the ranges, and there is no integer x such that x is in one of the ranges
     * but not in nums.
     * Input: nums = [0,1,2,4,5,7]
     * Output: ["0->2","4->5","7"]
     * Explanation: The ranges are:
     * [0,2] --> "0->2"
     * [4,5] --> "4->5"
     * [7,7] --> "7"
     */
    public static void main(String[] args) {
        int[] nums = {0, 1, 2, 4, 5, 7};
        System.out.println(summaryRanges(nums));
    }

    public static List<String> summaryRanges(int[] nums) {
        List<String> result = new ArrayList<>();

        int start = 0;
        int end = 0;

        for (int i = 0; i < nums.length; i++) {
            if (i + 1 < nums.length && nums[i] + 1 == nums[i + 1])
                end++;
            else {
                if (start == end)
                    result.add("" + nums[start]);
                else
                    result.add("" + nums[start] + "->" + nums[end]);

                start = i + 1;
                end = i + 1;
            }
        }

        return result;
    }

}
