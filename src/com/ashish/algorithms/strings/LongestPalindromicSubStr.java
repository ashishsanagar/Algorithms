package com.ashish.algorithms.strings;

public class LongestPalindromicSubStr {
    public static void main(String[] args) {
        LongestPalindromicSubStr helper = new LongestPalindromicSubStr();
        System.out.println(helper.find("tryracecartoday"));
    }

    // naive O(n^3)
    public String find(String s) {
        String longestPalindrome = "";

        if (s == null || s.isEmpty() || s.length() == 1) return s;

        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                String subStr = s.substring(j, i);

                if (subStr.equals(new StringBuilder(subStr).reverse().toString())) {
                    if (longestPalindrome.length() < subStr.length()) {
                        longestPalindrome = subStr;
                    }
                }
            }
        }

        return longestPalindrome;
    }
}
