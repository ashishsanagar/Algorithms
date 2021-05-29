
package learn.ashish.algorithms.sorting;

/**
 * @author asanagar
 */
public class MergeSort {

    /**
     * Divide and conquer using recursion
     */
    public static void main(String[] args) {
        int[] array = {1, 5, 8, 9, 3, 2, 7, 4};

        new MergeSort().sort(array);

        for (int i = 0; i < array.length; i++)
            System.out.print(array[i] + ", ");
    }

    private static void merge(int[] array, int[] left, int[] right) {
        int i = 0;
        int j = 0;
        int k = 0;

        while (i < left.length && j < right.length) {
            if (left[i] < right[j])
                array[k++] = left[i++];
            else
                array[k++] = right[j++];
        }

        while (i < left.length)
            array[k++] = left[i++];

        while (j < left.length)
            array[k++] = right[j++];
    }

    public void sort(int[] array) {
        if (array == null || array.length < 2)
            return;

        int mid = array.length / 2;
        int[] leftArray = new int[mid];
        int[] rightArray = new int[array.length - mid];

        for (int i = 0; i < mid; i++)
            leftArray[i] = array[i];

        for (int i = mid; i < array.length; i++)
            rightArray[i - mid] = array[i];

        sort(leftArray);
        sort(rightArray);
        merge(array, leftArray, rightArray);
    }
}
