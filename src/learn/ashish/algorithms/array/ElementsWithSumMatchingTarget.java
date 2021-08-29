package learn.ashish.algorithms.array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Ashish Sanagar
 */
public class ElementsWithSumMatchingTarget {

    public static void main(String[] args) {
        int[] array = {1, 3, 4, 6, 7, 3, 7};
        int target = 10;

        System.out.println("Number of ways: " + new ElementsWithSumMatchingTarget().allNumberOfWays(array, 10));

        List<String> result = new ElementsWithSumMatchingTarget().distinctPairs(array, target);

        result.forEach(System.out::println);
    }

    /**
     * Given a list of n integers arr[0..(n-1)], determine the number of different pairs of elements within it which sum to target.
     */
    public int allNumberOfWays(int[] arr, int target) {
        if (target < 1)
            return 0;

        if (arr == null | arr.length == 0)
            return 0;

        Map<Integer, Integer> map = new HashMap<>();
        int count = 0;

        for (int i = 0; i < arr.length; i++) {
            if (map.containsKey(arr[i])) {
                count++;
                map.put(target - arr[i], map.get(arr[i]) + 1);
            } else
                map.put(target - arr[i], 1);
        }

        return count;
    }

    /**
     * use hashtable to keep track of values read
     */
    public List<String> distinctPairs(int[] array, int target) {
        List<String> result = new ArrayList<>();

        if (array == null || array.length < 2 || target < 0)
            return result;

        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < array.length; i++) {
            if (map.containsKey(array[i]))
                result.add(array[map.get(array[i])] + ", " + array[i]);
            else
                map.put(target - array[i], i);
        }

        return result;
    }
}
