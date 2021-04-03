package com.ashish.algorithms.array;

/**
 * @author Ashish Sanagar
 */
public class MaxSubArray {

    public static void main(String[] args) {

        int[] array = {-2, 1, -3, 4, -1, 2, 1, -5, 4};

        int max = new MaxSubArray().find(array);
        System.out.println(max);
    }

    public int find(int[] array) {
        int sum = 0;
        int max = 0;

        for (int ele : array) {
            sum = Math.max(sum + ele, ele);
            max = Math.max(max, sum);
        }

        return max;
    }
}
