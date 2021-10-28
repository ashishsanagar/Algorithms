package learn.ashish.algorithms.array;

import java.util.Arrays;
import java.util.LinkedList;

public class MergeIntervals {

    /**
     * Given an array of intervals where intervals[i] = [starti, endi], merge all overlapping intervals, and return an
     * array of the non-overlapping intervals that cover all the intervals in the input.
     * <p>
     * Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
     * Output: [[1,6],[8,10],[15,18]]
     * Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into [1,6].
     */
    public static void main(String[] args) {
        int[][] intervals = {{1, 3}, {2, 6}};
        int[][] result = new MergeIntervals().merge(intervals);

        for (int[] r : result)
            System.out.println(Arrays.toString(r));
    }

    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        LinkedList<int[]> merged = new LinkedList<>();

        for (int[] interval : intervals) {
            if (merged.isEmpty() || merged.getLast()[1] < interval[0])
                merged.add(interval);
            else
                merged.getLast()[1] = Math.max(merged.getLast()[1], interval[1]);
        }

        return merged.toArray(new int[merged.size()][]);
    }
}
