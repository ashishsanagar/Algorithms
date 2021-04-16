package learn.ashish.algorithms.array;


import java.util.ArrayList;
import java.util.List;

public class KClosestElementsFromTarget {

    /**
     * find k-nearest neighbor
     * data = new int[] {2, 3, 66, 66, 67, 90} // sorted
     * target = 70;
     * k = 3;
     * return {66, 66, 67}
     * k <= data.length
     */
    public static void main(String[] args) {
        int[] a = {2, 3, 66, 66, 67, 90};
        int target = 70;
        int k = 7;

        KClosestElementsFromTarget helper = new KClosestElementsFromTarget();

        List<Integer> result = helper.findClosestKElements(a, target, k);

        for (Integer val : result) {
            System.out.print(val + " ");
        }
    }

    /**
     * Find closest index in O(n)
     *
     * @param a
     * @param target
     * @return
     */
    private static int findClosestIndex(int[] a, int target) {
        if (a == null || a.length == 0) {
            throw new IllegalArgumentException("Invalid input");
        }

        int min = Math.abs(target - a[0]);

        int closestIndex = 0;

        for (int i = 1; i < a.length; i++) {
            int diff = Math.abs(target - a[i]);
            if (diff < min) {
                min = diff;
                closestIndex = i;
            }
        }

        // System.out.println("Closest Index = " + closestIndex + " | closestVal=" + a[closestIndex]);

        return closestIndex;
    }

    public List<Integer> findClosestKElements(int[] a, int target, int k) {
        if (k > a.length)
            throw new IllegalArgumentException("Invalid Input");

        List<Integer> result = new ArrayList<>();

        int index = findClosestIndex(a, target);
        int i = index > 0 ? index - 1 : index;
        int j = index < a.length - 1 ? index + 1 : index;

        result.add(a[index]);

        while (result.size() < k) {
            int iSide = Integer.MAX_VALUE;
            int jSide = Integer.MAX_VALUE;

            if (i >= 0) {
                iSide = Math.abs(target - a[i]);
            }
            if (j <= a.length) {
                jSide = Math.abs(target - a[j]);
            }

            if (iSide < jSide) {
                result.add(a[i]);
                i--;

            } else {
                result.add(a[j]);
                j++;
            }
        }

        return result;
    }
}
