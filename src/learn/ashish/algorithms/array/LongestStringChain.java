package learn.ashish.algorithms.array;

import java.util.HashMap;
import java.util.Map;

public class LongestStringChain {

    /**
     * You are given an array of words where each word consists of lowercase English letters.
     * <p>
     * wordA is a predecessor of wordB if and only if we can insert exactly one letter anywhere in wordA without changing the order of the other characters to make it equal to wordB.
     * <p>
     * Input: words = ["a","b","ba","bca","bda","bdca"]
     * Output: 4
     * Explanation: One of the longest word chains is ["a","ba","bda","bdca"].
     */
    public static void main(String[] args) {
        String[] words = {"a", "b", "ba", "bca", "bda", "bdca"};
        //String[] words = {"a", "ba"};

        System.out.println(new LongestStringChain().longestStrChain(words));
    }


    public int longestStrChain(String[] words) {
        int max = 0;
        if (words == null || words.length == 0)
            return max;

        Map<String, Integer> memo = new HashMap<>();

        for (String word : words)
            max = Math.max(max, dfs(words, word, memo));

        return max;
    }

    private int dfs(String[] words, String word, Map<String, Integer> memo) {
        if (memo.containsKey(word))
            return memo.get(word);

        int maxLen = 1;

        StringBuilder sb = new StringBuilder(word);

        for (int i = 0; i < sb.length(); i++) {
            char c = sb.charAt(i);
            sb.deleteCharAt(i);

            if (exists(words, sb.toString())) {
                int currLen = 1 + dfs(words, sb.toString(), memo);
                maxLen = Math.max(maxLen, currLen);
            }
            sb.insert(i, c);
        }

        memo.put(word, maxLen);
        return maxLen;
    }

    private boolean exists(String[] words, String word) {
        for (String w : words) {
            if (w.equals(word))
                return true;
        }

        return false;
    }

}
