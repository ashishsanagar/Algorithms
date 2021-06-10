package learn.ashish.algorithms.array;

import java.util.ArrayList;
import java.util.List;

public class FindAllDuplicatesInArray {

    /**
     * Given an integer array nums of length n where all the integers of nums are in the range [1, n] and each integer appears once or twice, return an array of all the integers that appears twice.
     * You must write an algorithm that runs in O(n) time and uses only constant extra space.
     * <p>
     * Input: nums = [4,3,2,7,8,2,3,1]
     * Output: [2,3]
     */
    public static void main(String[] args) {
        int[] nums = {4, 3, 2, 7, 8, 2, 3, 1};
        System.out.println(new FindAllDuplicatesInArray().findDuplicates(nums).toString());
    }

    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> dups = new ArrayList<>();

        if (nums.length < 2)
            return dups;

        for (int i = 0; i < nums.length; i++) {
            int index = Math.abs(nums[i]) - 1;
            if (nums[index] < 0)
                dups.add(Math.abs(nums[i]));
            else
                nums[index] = -1 * nums[index];
        }

        return dups;
    }
}
