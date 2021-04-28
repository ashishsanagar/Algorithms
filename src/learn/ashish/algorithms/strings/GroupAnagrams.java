package learn.ashish.algorithms.strings;

import java.util.*;

public class GroupAnagrams {

    /**
     * input:  ["eat", "tea", "tan", "ate", "nat", "bat"]
     * result:  [["eat", "ate", "tea",], ["nat", "tan"], ["bat"]]
     *
     * @param args
     */
    public static void main(String[] args) {
        String[] words = {"eat", "tea", "tan", "ate", "nat", "bat"};

        List<List<String>> groups = new GroupAnagrams().group(words);

        for (List<String> group : groups) {
            for (String word : group) {
                System.out.print(word + " ");
            }

            System.out.println();
        }
    }

    private List<List<String>> group(String[] words) {
        List<List<String>> result = new ArrayList<>();

        if (words == null || words.length == 0) return result;

        Map<String, List<String>> grouped = new HashMap<>();

        for (String word : words) {
            char[] chars = word.toCharArray();
            Arrays.sort(chars);
            String sorted = new String(chars);

            if (grouped.get(sorted) == null)
                grouped.put(sorted, new ArrayList<>());

            grouped.get(sorted).add(word);
        }

        result.addAll(grouped.values());

        return result;
    }
}
