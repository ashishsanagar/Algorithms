package com.ashish.algorithms.strings;

/**
 * @author Ashish Sanagar
 */
public class ReplaceSpaceWithPercent20 {
    public static void main(String[] args) {

        String str = "a a"; // a%20a

        System.out.println("encoded: " + new ReplaceSpaceWithPercent20().encode(str));
        System.out.println("decoded: " + new ReplaceSpaceWithPercent20().decode("a%20"));

    }

    public String encode(String str) {
        if (str == null || str.isEmpty()) return str;

        StringBuilder builder = new StringBuilder();

        for (char c : str.toCharArray()) {
            if (c == ' ') {
                builder.append("%20");
            } else {
                builder.append(c);
            }
        }

        return (builder.toString());
    }

    public String decode(String encoded) {
        if (encoded == null || encoded.isEmpty()) return encoded;

        for (int i = 0; i < encoded.length() - 2; i++) {
            if ("%20".equals(encoded.substring(i, i + 3))) {
                encoded = i == 0 ? "" : encoded.substring(0, i) + encoded.substring(i + 3);
            }
        }

        return encoded;
    }
}
