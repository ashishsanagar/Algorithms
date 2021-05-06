package learn.ashish.algorithms.array;

public class ContiguousSubarrays {

    public static void main(String[] args) {
        int[] array = {3, 4, 1, 6, 2};

        int[] result = new ContiguousSubarrays().count(array);

        for (int i : result)
            System.out.print(i + ", ");
    }

    /**
     * You are given an array arr of N integers. For each index i, you are required to determine the number of contiguous
     * subarrays that fulfill the following conditions:
     * The value at index i must be the maximum element in the contiguous subarrays, and
     * These contiguous subarrays must either start from or end on index i.
     * Example:
     * arr = [3, 4, 1, 6, 2]
     * output = [1, 3, 1, 5, 1]
     *
     * @param arr
     * @return
     */
    int[] count(int[] arr) {
        if (arr == null || arr.length < 1) return arr;

        int[] result = new int[arr.length];

        for (int i = 0; i < arr.length; i++) {
            int count = 1; // include ith element to count as thats minimum subarray
            int k = i;

            // search elements on left side of index i
            while (k >= 0) {
                k = k - 1;

                if (k >= 0 && arr[i] > arr[k])
                    count++;
                else
                    break;
            }

            k = i;
            // search elements on right side of index i
            while (k < arr.length) {
                k = k + 1;

                if (k < arr.length && arr[i] > arr[k])
                    count++;
                else
                    break;
            }

            result[i] = count;
        }

        return result;
    }
}
