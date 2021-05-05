package com.ashish.algorithms.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PermutationOfArray {

    public static void main(String[] args) {
        int[] a = {3, 2, 1};
        List<int[]> result = new ArrayList<>();

        new PermutationOfArray().permutations(a, 0, result);

        for (int[] array : result) {
            for (int ele : array) {
                System.out.print(ele + ", ");
            }
            System.out.println();
        }
    }

    public void permutations(int[] nums, int index, List<int[]> result) {
        if (index == nums.length) {
            result.add(Arrays.copyOf(nums, nums.length));
            return;
        }

        for (int i = index; i < nums.length; i++) {
            int temp = nums[i];
            nums[i] = nums[index];
            nums[index] = temp;

            permutations(nums, index + 1, result);

            temp = nums[index];
            nums[index] = nums[i];
            nums[i] = temp;
        }
    }
}
