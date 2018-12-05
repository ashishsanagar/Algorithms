package com.ashish.algorithms.array;

/**
 * @author Ashish Sanagar
 */
public class NonDuplicateElementFromArray {

    /**
     * find non-duplicate element from given aaray
     */
    public static void main(String[] args) {
        int[] a = {1, 1, 3, 6, 8, 3, 8};

        new NonDuplicateElementFromArray().find(a);
    }

    public void find(int[] a) {
        int x = 0;

        for (int ele : a) {
            x = x ^ ele;
        }

        System.out.println(x);
    }
}


