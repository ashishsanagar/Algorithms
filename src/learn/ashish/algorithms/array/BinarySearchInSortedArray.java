package learn.ashish.algorithms.array;

/**
 * @author Ashish Sanagar
 */
public class BinarySearchInSortedArray {

    /**
     * binary search O(log(n))
     */
    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 6};

        boolean exists = new BinarySearchInSortedArray().findElement(array, 4);
        System.out.println(exists);
    }

    /**
     * Time: O[n]
     * Space: O[1]
     */
    public boolean findElement(int[] array, int ele) {
        if (array == null || array.length == 0)
            return false;

        int low = 0;
        int high = array.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (ele == array[mid])
                return true;
            else if (ele < array[mid])
                high = mid - 1;
            else
                low = mid + 1;
        }

        return false;
    }
}
