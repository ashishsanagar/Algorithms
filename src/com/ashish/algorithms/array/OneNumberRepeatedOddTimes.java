package com.ashish.algorithms.array;

/**
 * @author Ashish Sanagar
 */
public class OneNumberRepeatedOddTimes {

    public static void main(String[] args) {
        int[] a = {1, 1, 2, 3, 2, 2, 3, 5, 6, 5, 6};

        System.out.println(new OneNumberRepeatedOddTimes().find(a));
    }

    public int find(int[] a) {
        int odd = 0;
        for (int ele : a) {
            odd = odd ^ ele;
        }

        return odd;
    }
}
