package learn.ashish.algorithms.array;

/**
 * @author Ashish Sanagar
 */
public class MaxAverageSubarrayOfSizeK {

    /**
     * Maximum average subarray of size k
     */
    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int k = 4;

        System.out.println(new MaxAverageSubarrayOfSizeK().find(array, k));
    }

    public int find(int[] array, int k) {
        if (k > array.length)
            return 0;

        int sum = 0;

        for (int i = 0; i < k; i++)
            sum += array[i];

        int maxSum = sum;

        for (int i = k; i < array.length; i++) {
            sum = sum - array[i - k] + array[i];
            maxSum = Math.max(maxSum, sum);
        }

        return maxSum / k;
    }
}
