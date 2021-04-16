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

        new MaxAverageSubarrayOfSizeK().find(array, k);
    }

    public void find(int[] array, int k) {
        int n = array.length;

        if (k > n) {
            throw new IllegalArgumentException("K is greater than array length");
        }

        int sum = 0;
        int startIndex = 0;

        for (int i = 0; i < k; i++) {
            sum += array[i];
        }

        int maxSum = sum;

        for (int i = k; i < n; i++) {
            sum = sum - array[i - k] + array[i];

            if (sum > maxSum) {
                maxSum = sum;
                startIndex = i - k;
            }
        }

        System.out.println("Max sum is: " + maxSum + " | startIndex: " + startIndex);

        for (int i = startIndex + 1; i < startIndex + k + 1; i++) {
            System.out.print(array[i] + " ");
        }
    }
}
