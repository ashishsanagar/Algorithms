package learn.ashish.algorithms.strings;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * @author Ashish Sanagar
 */
public class NthMostFrequentStringFromArray {

    public static void main(String[] args) {
        String[] array = {"ab", "bc", "bc", "ab", "bc", "as", "abc", "cd"};

        System.out.println(new NthMostFrequentStringFromArray().find(array, 2));
    }

    public String find(String[] array, int n) {
        if (array == null || n > array.length || array.length == 0)
            return "";

        Map<String, Integer> counts = new HashMap<>();

        for (int i = 0; i < array.length; i++)
            counts.put(array[i], counts.getOrDefault(array[i], 0) + 1);

        //min heap sorted by counts
        PriorityQueue<String> pq = new PriorityQueue<>((a, b) -> counts.get(a) - counts.get(b));

        for (String s : counts.keySet()) {
            pq.add(s);
            if (pq.size() > n)
                pq.poll();
        }

        return pq.peek();
    }
}
