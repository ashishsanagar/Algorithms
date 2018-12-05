package com.ashish.algorithms.strings;

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
        String s = "abcca";

        new MaxSubstringNoRepeatngChars().print(s);
    }

    public void print(String s) {
        int length = s.length();

        int i = 0;
        int j = 0;
        int maxSubStrLength = 0;

        Set<Character> set = new HashSet<>();

        while (i < length && j < length) {
            if (set.contains(s.charAt(j)) == false) {
                set.add(s.charAt(j));
                j++;
                maxSubStrLength = Math.max(maxSubStrLength, j - i);
            } else {
                set.remove(s.charAt(i));
                i++;
            }
        }

        System.out.println(maxSubStrLength);
    }
}
