
package learn.ashish.algorithms.sorting;

/**
 * @author asanagar
 */
public class QuickSort {

    public static void main(String[] args) {

        int[] array = {
                1,
                5,
                8,
                9,
                3,
                2,
                7,
                4
        };

        new QuickSort().sort(array, 0, array.length - 1);

        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + ", ");
        }
    }

    private static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public void sort(int[] array, int start, int end) {
        if (start < end) {
            int partitionIndex = partition(array, start, end);
            sort(array, start, partitionIndex - 1);
            sort(array, partitionIndex + 1, end);
        }
    }

    //consider last element as PIVOT. rearrange list so that, all left elements of pivot are less than pivot and all right are greater.
    //increment partition index every time we swap.
    private int partition(int[] array, int start, int end) {

        int pivotValue = array[end];
        int partitionIndex = start;
        for (int i = start; i < end; i++) {
            if (array[i] <= pivotValue) {

                swap(array, partitionIndex, i);

                partitionIndex++;
            }
        }

        swap(array, partitionIndex, end);

        return partitionIndex;
    }

}
