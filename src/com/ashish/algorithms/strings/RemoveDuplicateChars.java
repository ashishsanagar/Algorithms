package com.ashish.algorithms.strings;

/**
 * @author Ashish Sanagar
 */
public class RemoveDuplicateChars {

    public static void main(String[] args) {
        RemoveDuplicateChars obj = new RemoveDuplicateChars();

        obj.remove("aaaa");

        obj.remove("ashish");

        obj.remove("abababa");

        obj.remove("a");

        obj.remove(null);
    }

    public void remove(String str) {

        if (str == null || str.length() < 1) return;

        boolean[] visited = new boolean[256];

        for (int i = 0; i < str.length(); i++) {

            if (visited[str.charAt(i)] == false) {
                visited[str.charAt(i)] = true;
            } else {
                str = str.substring(0, i) + str.substring(i + 1);
                i--;
            }
        }

        System.out.println("result = " + str);
    }

}
