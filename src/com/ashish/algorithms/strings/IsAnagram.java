package com.ashish.algorithms.strings;

/**
 * @author Ashish Sanagar
 */
public class IsAnagram {

    /**
     * An anagram is word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once
     */
    public static void main(String[] args) {
        String s1 = "Anagram";
        String s2 = "nagarAm";

        IsAnagram obj = new IsAnagram();
        System.out.println(obj.isAnagram(s1, s2));
        System.out.println(obj.isAnagramInN2(s1, s2));
    }

    /**
     * O(n)
     */
    public boolean isAnagram(String s1, String s2) {
        int[] letters = new int[256];

        for (char c : s1.toCharArray()) {
            letters[c]++;
        }

        for (char c : s2.toCharArray()) {
            letters[c]--;
        }

        for (int count : letters) {
            if (count != 0) {
                return false;
            }
        }

        return true;
    }

    /**
     * O(n2)
     */
    public boolean isAnagramInN2(String s1, String s2) {

        char[] firstArray = s1.toCharArray();
        char[] secondArray = s2.toCharArray();

        for (int i = 0; i < firstArray.length; i++) {
            for (int j = 0; j < secondArray.length; j++) {
                if (firstArray[i] == secondArray[j]) {
                    firstArray[i] = 0;
                    secondArray[j] = 0;
                    continue;
                }
            }
        }

        for (int i : firstArray) {
            if (i != 0) {
                return false;
            }
        }

        for (int i : secondArray) {
            if (i != 0) {
                return false;
            }
        }

        return true;
    }
}
