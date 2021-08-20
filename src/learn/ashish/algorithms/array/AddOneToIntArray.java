package learn.ashish.algorithms.array;

import java.util.Arrays;

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

        System.out.println(Arrays.toString(helper.addOne(new int[]{9, 9, 9, 9})));
        System.out.println(Arrays.toString(helper.addOne(new int[]{9, 9, 9, 8})));
    }

    /**
     * Time: O[n]
     * Space: O[1]
     */
    public int[] addOne(int[] nums) {
        int carry = 1;

        for (int i = nums.length - 1; i >= 0; i--) {
            int replaceNumber = nums[i] + carry;

            nums[i] = replaceNumber % 10;
            carry = replaceNumber / 10;
        }

        if (carry != 0) {
            int[] newArray = new int[nums.length + 1];
            newArray[0] = carry;

            for (int i = 1; i < newArray.length; i++)
                newArray[i] = nums[i - 1];

            return newArray;
        }

        return nums;
    }
}
