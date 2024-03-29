package learn.ashish.algorithms.array;

import java.util.Arrays;

public class RemoveDupsFromSortedArray {

    /**
     * inplace update, return new length
     */
    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 2, 3};
        System.out.println(Arrays.toString(nums));
        System.out.println(new RemoveDupsFromSortedArray().removeDuplicates(nums));
        System.out.println(Arrays.toString(nums));
    }

    public int removeDuplicates(int[] nums) {
        if (nums.length == 0)
            return 0;

        int i = 0;

        for (int j = 1; j < nums.length; j++) {
            if (nums[j] != nums[i]) {
                i++;
                nums[i] = nums[j];
            }
        }

        return i + 1;
    }

}
