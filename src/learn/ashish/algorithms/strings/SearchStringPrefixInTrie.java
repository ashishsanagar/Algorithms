package learn.ashish.algorithms.strings;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Ashish Sanagar
 */
public class SearchStringPrefixInTrie {

    public static void main(String[] args) {
        String[] words = {"abc", "ab", "bcd"};
        String prefix = "ab";

        Node trie = new Node("");
        SearchStringPrefixInTrie trieHelper = new SearchStringPrefixInTrie();

        for (String word : words)
            trieHelper.insertWordInTrie(word, trie);

        List<String> results = trieHelper.findWordsForPrefix(prefix, trie);

        results.stream().forEach(System.out::println);
    }

    public void insertWordInTrie(String word, Node trie) {
        Node curr = trie;

        for (int i = 0; i < word.length(); i++) {
            if (curr.children.containsKey(word.charAt(i)) == false)
                curr.children.put(word.charAt(i), new Node(word.substring(0, i + 1)));

            curr = curr.children.get(word.charAt(i));

            if (i == word.length() - 1)
                curr.isWord = true;
        }
    }

    public void findAllWords(Node curr, List<String> results) {
        if (curr.isWord)
            results.add(curr.prefix);

        for (Character c : curr.children.keySet())
            findAllWords(curr.children.get(c), results);
    }

    public List<String> findWordsForPrefix(String prefix, Node trie) {
        List<String> results = new ArrayList<>();

        Node curr = trie;

        for (char c : prefix.toCharArray()) {
            if (curr.children.containsKey(c))
                curr = curr.children.get(c);
            else
                return results;
        }

        findAllWords(curr, results);

        return results;
    }

    private static class Node {
        String prefix;
        boolean isWord;
        Map<Character, Node> children = new HashMap<>();

        private Node(String prefix) {
            this.prefix = prefix;
        }
    }
}
