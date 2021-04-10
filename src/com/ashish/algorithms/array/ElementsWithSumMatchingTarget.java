package com.ashish.algorithms.array;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Ashish Sanagar
 */
public class ElementsWithSumMatchingTarget {

    public static void main(String[] args) {
        int[] array = {1, 3, 4, 6, 7, 3, 7};
        int target = 10;

        new ElementsWithSumMatchingTarget().distinctPairs(array, target);

        System.out.println("Number of ways: " + new ElementsWithSumMatchingTarget().allNumberOfWays(array, 10));
    }

    /**
     * Given a list of n integers arr[0..(n-1)], determine the number of different pairs of elements within it which sum to k.
     *
     * @param arr
     * @param k
     * @return
     */
    public int allNumberOfWays(int[] arr, int k) {
        // Write your code here
        if (k < 1) return 0;

        if (arr == null | arr.length == 0) return 0;

        Map<Integer, Integer> map = new HashMap<>();
        int count = 0;

        for (int i = 0; i < arr.length; i++) {
            if (map.containsKey(arr[i])) {
                count = count + map.get(arr[i]);

                map.put(k - arr[i], map.get(arr[i]) + 1);

            } else {
                map.put(k - arr[i], 1);

            }
        }

        return count;
    }

    /**
     * use hashtable to keep track of values read
     *
     * @param array
     * @param target
     */
    public void distinctPairs(int[] array, int target) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < array.length; i++) {
            if (map.containsKey(array[i])) {
                System.out.println(array[map.get(array[i])] + " + " + array[i] + " = " + target);
            } else {
                map.put(target - array[i], i);
            }
        }
    }
}
