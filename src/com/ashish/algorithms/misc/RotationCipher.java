package com.ashish.algorithms.misc;

public class RotationCipher {

    /**
     * Rotate every alphanumeric character by a certain rotation factoe between 0 to N.
     * Rotating a character means replacing it with another character that is a certain number of
     * steps away in normal alphabetic or numerical order.
     *
     * @param args
     */
    public static void main(String[] args) {
        System.out.println(new RotationCipher().rotationalCipher("Ashish-123", 1));
    }

    /**
     * If we have to rotate a-z and rotation factor is from 0 to n, n%26 gives the actual smallest rotation required value
     * a-z, A-Z, 0-9 are in sequence in ascii.
     *
     * @param input
     * @param rotationFactor
     * @return
     */
    String rotationalCipher(String input, int rotationFactor) {
        String result = "";

        for (Character c : input.toCharArray()) {
            if (Character.isLowerCase(c)) {
                result += Character.toString((char) (((c - 'a' + rotationFactor) % 26) + 'a'));
            } else if (Character.isUpperCase(c)) {
                result += Character.toString((char) (((c - 'A' + rotationFactor) % 26) + 'A'));
            } else if (Character.isDigit(c)) {
                result += Character.toString((char) (((c - '0' + rotationFactor) % 10) + '0'));
            } else {
                result += (char) c;
            }
        }

        return result;
    }
}
