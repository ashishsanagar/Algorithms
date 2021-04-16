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

        System.out.println(printPeakElement(array));
    }

    /**
     * using binary search
     *
     * @param array
     * @return
     */
    private static int printPeakElement(int[] array) {
        if (array == null || array.length == 0) {
            return 0;
        }

        if (array.length == 1) {
            return array[0];
        }

        if (array.length == 2) {
            if (array[0] > array[1]) {
                return array[0];
            } else {
                System.out.println("Peak: " + array[1]);
                return array[1];
            }
        }

        int low = 0;
        int high = array.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;

            if ((mid == 0 || array[mid - 1] <= array[mid]) && (mid == array.length - 1 || array[mid] >= array[mid + 1])) {
                return array[mid];
            } else if (array[mid] < array[mid - 1]) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }

        }

        return 0;
    }
}
