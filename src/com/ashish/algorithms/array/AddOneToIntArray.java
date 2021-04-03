package com.ashish.algorithms.array;

/**
 * @author Ashish Sanagar
 */
public class AddOneToIntArray {

    /**
     * Given a integer array add one to its concatenated value.
     * <p>
     * [1,2,3,4] -> [1,2,3,5]
     * [9,9,9,9] -> [1,0,0,0,0]
     */
    public static void main(String[] args) {
        AddOneToIntArray helper = new AddOneToIntArray();

        helper.print(helper.addOne(new int[]{9, 9, 9, 9}));

        helper.print(helper.addOne(new int[]{9, 9, 9, 8}));
    }

    public int[] addOne(int[] inputArray) {
        int carry = 1;

        for (int i = inputArray.length - 1; i >= 0; i--) {
            int replaceNumber = inputArray[i] + carry;

            inputArray[i] = replaceNumber % 10;
            carry = replaceNumber / 10;
        }

        if (carry != 0) {
            int[] newArray = new int[inputArray.length + 1];
            newArray[0] = carry;

            for (int i = 1; i < inputArray.length; i++) {
                newArray[i] = inputArray[i];
            }

            return newArray;
        }

        return inputArray;
    }

    public void print(int[] a) {
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i]);
        }

        System.out.println();
    }
}
