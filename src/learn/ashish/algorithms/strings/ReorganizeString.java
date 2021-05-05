package learn.ashish.algorithms.strings;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class ReorganizeString {

    /**
     * Given a string S, check if the letters can be rearranged so that two characters that are adjacent to each other are not the same.
     * <p>
     * If possible, output any possible result.  If not possible, return the empty string.
     * <p>
     * Example 1:
     * <p>
     * Input: S = "aab"
     * Output: "aba"
     * <p>
     * Example 2:
     * <p>
     * Input: S = "aaab"
     * Output: ""
     */
    public static void main(String[] args) {
        System.out.println(new ReorganizeString().reorganizeString("aab"));
    }

    public String reorganizeString(String S) {
        Map<Character, Integer> counts = new HashMap<>();
        for (char c : S.toCharArray())
            counts.put(c, counts.getOrDefault(c, 0) + 1);

        PriorityQueue<Character> q = new PriorityQueue<>((a, b) -> counts.get(b) - counts.get(a));
        q.addAll(counts.keySet());

        StringBuilder result = new StringBuilder();

        while (q.size() >= 2) {
            char curr = q.remove();
            char next = q.remove();

            result.append(curr).append(next);

            counts.put(curr, counts.get(curr) - 1);
            counts.put(next, counts.get(next) - 1);

            if (counts.get(curr) > 0)
                q.add(curr);
            if (counts.get(next) > 0)
                q.add(next);
        }

        if (!q.isEmpty()) {
            char last = q.remove();
            if (counts.get(last) > 1) {
                return "";
            }
            result.append(last);
        }

        return result.toString();
    }
}
