package learn.ashish.algorithms.array;

import java.util.HashMap;
import java.util.Map;

public class PairSumNumberOfWays {

    /**
     * Given a list of n integers arr[0..(n-1)], determine the number of different pairs of elements within it which sum to k.
     * If an integer appears in the list multiple times, each copy is considered to be different; that is, two pairs
     * are considered different if one pair includes at least one array index which the other doesn't, even if they
     * include the same values.
     * <p>
     * <p>
     * example
     * n = 5
     * k = 6
     * arr = [1, 5, 3, 3, 3]
     * output = 4
     */
    public static void main(String[] args) {
        int[] arr = {1, 5, 3, 3, 3};
        System.out.println(numberOfWays(arr, 6));
    }

    private static int numberOfWays(int[] arr, int k) {
        if (k < 1) return 0;

        if (arr == null | arr.length == 0) return 0;

        Map<Integer, Integer> map = new HashMap<>();
        int count = 0;

        for (int i = 0; i < arr.length; i++) {
            if (map.containsKey(arr[i])) {
                count += map.get(arr[i]);

                map.put(k - arr[i], map.get(arr[i]) + 1);
            } else {
                map.put(k - arr[i], 1);
            }
        }

        return count;
    }
}
