package learn.ashish.algorithms.array;

/**
 * @author Ashish Sanagar
 */
public class MaxSubArray {

    public static void main(String[] args) {
        int[] array = {-2, 1, -3, 4, -1, 2, 1, -5, 4};

        System.out.println(new MaxSubArray().find(array));
    }

    public int find(int[] array) {
        int sum = 0;
        int max = Integer.MIN_VALUE;

        for (int ele : array) {
            sum = Math.max(sum + ele, ele);
            max = Math.max(max, sum);
        }

        return max;
    }
}
