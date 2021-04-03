package com.ashish.algorithms.strings;

/**
 * @author Ashish Sanagar
 */
public class RemoveDuplicateChars {

    public static void main(String[] args) {
        RemoveDuplicateChars obj = new RemoveDuplicateChars();

        System.out.println(obj.remove("aaaa"));

        System.out.println(obj.remove("ashish"));

        System.out.println(obj.remove(null));
    }

    public String remove(String str) {
        if (str == null || str.length() < 2) return str;

        boolean[] visited = new boolean[256];

        for (int i = 0; i < str.length(); i++) {
            if (visited[str.charAt(i)] == false) {
                visited[str.charAt(i)] = true;
            } else {
                str = str.substring(0, i) + str.substring(i + 1);
                i--;
            }
        }

        return str;
    }

}
