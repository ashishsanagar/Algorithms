package com.ashish.algorithms.strings;

/**
 * @author asanagar
 */
public class StringReverseLine {
    public static void main(String[] args) {
        String line = "This is a reverse string java program.";

        StringReverseLine obj = new StringReverseLine();
        System.out.println(obj.reverseString1(line));
        System.out.println(obj.reverseString2(line));
    }

    public String reverseString1(String line) {
        String[] words = line.split(" \\,");
        StringBuilder reverse = new StringBuilder();

        for (String word : words) {
            reverse.append(new StringBuilder(word).reverse());
        }

        return reverse.toString();
    }

    public String reverseString2(String line) {
        StringBuilder reverse = new StringBuilder();
        int len = line.length();

        for (int i = len - 1; i >= 0; i--) {
            reverse.append(line.charAt(i));
        }

        return reverse.toString();
    }

}


