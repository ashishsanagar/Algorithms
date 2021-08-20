package learn.ashish.algorithms.array;

import java.util.Arrays;

public class CalendarEventConflicts {

    /**
     * There are n events, and k conflicts are okay.
     * if conflicts are more than k, return false
     */
    public static void main(String[] args) {
        // there are 3 conflicts in below calendar.
        Event[] events = {new Event(1, 5), new Event(2, 4), new Event(6, 7), new Event(7, 8), new Event(4, 7)};

        System.out.println(new CalendarEventConflicts().hasConflicts(events, 2));
    }

    /**
     * get separate arrays for start and end times. sort both arrays asc
     * if start of next meeting is is less than end time of previous meeting, there is conflict
     * <p>
     * Time: O[nlog(n)]
     * Space:
     */
    public boolean hasConflicts(Event[] events, int k) {
        if (events == null || events.length <= k)
            return false;

        int[] starts = new int[events.length];
        int[] ends = new int[events.length];

        for (int i = 0; i < events.length; i++) {
            starts[i] = events[i].start;
            ends[i] = events[i].end;
        }

        Arrays.sort(starts);
        Arrays.sort(ends);

        int conflicts = 0;

        for (int i = 0; i < starts.length - 1; i++)
            if (starts[i + 1] < ends[i])
                conflicts++;

        return conflicts > k;
    }

    static class Event {
        public int start;
        public int end;

        public Event(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
}
