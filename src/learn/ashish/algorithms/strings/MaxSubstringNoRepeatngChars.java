package learn.ashish.algorithms.strings;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Ashish Sanagar
 */
public class MaxSubstringNoRepeatngChars {

    /**
     * Longest Substring Without Repeating Characters
     * <p>
     * acbadad -> cbad = 4
     * abcaca -> abc -> 3
     */
    public static void main(String[] args) {
        String s = "acbadad";

        System.out.println("Max subStr length for input " + s + ": " + new MaxSubstringNoRepeatngChars().maxLength(s));
    }

    /**
     * sliding window pattern
     */
    public int maxLength(String input) {
        int i = 0;
        int j = 0;
        int max = 0;

        Set<Character> chars = new HashSet<>();

        while (i < input.length() && j < input.length()) {
            if (chars.contains(input.charAt(j)) == false) {
                chars.add(input.charAt(j));
                j++;
                max = Math.max(max, j - i);
            } else {
                chars.remove(input.charAt(i));
                i++;
            }
        }

        return max;
    }
}
