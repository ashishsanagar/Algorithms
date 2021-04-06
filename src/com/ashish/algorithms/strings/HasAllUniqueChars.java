package com.ashish.algorithms.strings;

/**
 * @author Ashish Sanagar
 */
public class HasAllUniqueChars {

    public static void main(String[] args) {
        HasAllUniqueChars obj = new HasAllUniqueChars();

        System.out.println(obj.hasAllUniqueChars("abcdef"));
        System.out.println(obj.hasAllUniqueChars("aaabbs"));

        System.out.println(obj.hasAllUniqueCharsImproved("abcc"));
    }

    public boolean hasAllUniqueCharsImproved(String str) {
        int checker = 0;

        for (char c : str.toCharArray()) {
            int value = c - 'a';

            if ((checker & (1 << value)) > 0) {
                return false;
            }

            checker = checker | (1 << value);
            System.out.println("checker (" + c + ")=" + checker);
        }

        return true;
    }

    public boolean hasAllUniqueChars(String str) {
        boolean[] visted = new boolean[256];

        for (char c : str.toCharArray()) {
            if (visted[c] == false) {
                visted[c] = true;
            } else {
                return false;
            }
        }

        return true;
    }

}
