package learn.ashish.algorithms.array;

/**
 * @author Ashish Sanagar
 */
public class PeakElementinArray {

    /**
     * an element which is greater than the left and right elements is a peak
     */
    public static void main(String[] args) {
        int[] array = {10, 30, 40, 60, 50};

        System.out.println(find(array));
    }

    private static int find(int[] nums) {
        int low = 0;
        int high = nums.length - 1;

        while (low < high) {
            int mid = low + (high - low) / 2;

            if (nums[mid] < nums[mid + 1])
                low = mid + 1;
            else
                high = mid;
        }

        return nums[low];
    }
}
