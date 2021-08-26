package learn.ashish.algorithms.array;

import java.util.Arrays;

public class MinimumMeetingRooms {

    /**
     * Given an array of meeting time intervals intervals where intervals[i] = [starti, endi],
     * return the minimum number of conference rooms required.
     * <p>
     * Input: intervals = [[0,30],[5,10],[15,20]]
     * Output: 2
     * Input: intervals = [[7,10],[2,4]]
     * Output: 1
     */
    public static void main(String[] args) {
        System.out.println(new MinimumMeetingRooms().minMeetingRooms(new int[][]{{0, 30}, {5, 10}, {15, 20}}));
        System.out.println(new MinimumMeetingRooms().minMeetingRooms(new int[][]{{7, 10}, {2, 4}}));
    }

    /**
     * Create separate starts and end times array
     * Sort both arrays ascending
     * If end time of previous meeting is more than start time of next meeting, increase counter by 1
     */
    public int minMeetingRooms(int[][] intervals) {
        int[] startIntervals = new int[intervals.length];
        int[] endInterval = new int[intervals.length];

        for (int i = 0; i < intervals.length; i++) {
            startIntervals[i] = intervals[i][0];
            endInterval[i] = intervals[i][1];
        }

        Arrays.sort(startIntervals);
        Arrays.sort(endInterval);

        int rooms = 0;
        int endPointer = 0;

        for (int i = 0; i < startIntervals.length; i++) {
            // if there is no conflict, we dont need additional room, move end pointer as well
            if (endInterval[endPointer] <= startIntervals[i])
                endPointer++;
            else
                rooms++; // there is a conflict
        }

        return rooms;
    }
}
