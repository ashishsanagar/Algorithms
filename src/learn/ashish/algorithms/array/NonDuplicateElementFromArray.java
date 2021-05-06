package learn.ashish.algorithms.array;

/**
 * @author Ashish Sanagar
 */
public class NonDuplicateElementFromArray {

    /**
     * find non-duplicate element from given array
     */
    public static void main(String[] args) {
        int[] a = {1, 1, 3, 6, 8, 3, 8};
        System.out.println(new NonDuplicateElementFromArray().find(a));
    }

    public int find(int[] a) {
        int x = 0;

        for (int ele : a)
            x = x ^ ele;

        return x;
    }
}


