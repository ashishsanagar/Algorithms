package com.ashish.algorithms.misc;

/**
 * @author Ashish Sanagar
 */
public class BinaryNumberOfOnes {

    /**
     * For given integer x, find out after binary conversion, how many ones it will have
     * <p>
     * 6 = 0b110 -> 2
     */
    public static void main(String[] args) {
        int x = 6;

        System.out.println(new BinaryNumberOfOnes().convert(x));
    }

    public int convert(int x) {
        int sum = 0;

        while (x > 0) {
            sum = sum + (x % 2);
            x = x / 2;
        }

        return sum;
    }
}
