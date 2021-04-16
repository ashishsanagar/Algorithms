package learn.ashish.algorithms.array;

/**
 * @author Ashish Sanagar
 */
public class OneMissingNumberFromSequence {

    /**
     * if arr [1,3,4,5] then missing number is 2
     */
    public static void main(String[] args) {
        int[] array = {1, 3, 4, 5};

        int missing = new OneMissingNumberFromSequence().findOneMissing(array);
        System.out.println("missing#:" + missing);
    }

    /**
     * using XOR
     *
     * @param array
     * @return
     */
    public int findOneMissing(int[] array) {
        int sumSequence = 0;
        int sumArrayElements = 0;

        for (int i = 1; i <= array.length + 1; i++) {
            sumSequence ^= +i;
        }

        for (int i = 0; i < array.length; i++) {
            sumArrayElements ^= +array[i];
        }

        return sumSequence ^ sumArrayElements;
    }
}
