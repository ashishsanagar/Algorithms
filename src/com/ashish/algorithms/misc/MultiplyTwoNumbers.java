package com.ashish.algorithms.misc;

/**
 * @author Ashish Sanagar
 */
public class MultiplyTwoNumbers {
    public static void main(String[] args) {
        int x = 20;
        int y = 10;

        int product = new MultiplyTwoNumbers().multiply(x, y);
        System.out.println(product);
    }

    public int multiply(int x, int y) {
        if (x < y) {
            return multiply(y, x);
        }

        int sum = 0;

        for (int i = 0; i < y; i++) {
            sum += x;
        }

        return sum;
    }
}

