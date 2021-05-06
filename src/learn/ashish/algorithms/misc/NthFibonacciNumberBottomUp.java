
package learn.ashish.algorithms.misc;

/**
 * @author Ashish Sanagar
 */
public class NthFibonacciNumberBottomUp {

    /**
     * using bottom up
     */
    public static void main(String[] args) {
        int n = 10000;

        System.out.println("nth number: " + bottomUp(n));
    }

    private static int bottomUp(int n) {
        int[] bottomUpArray = new int[n + 1];

        if (n == 1 || n == 2)
            return 1;

        bottomUpArray[1] = 1;
        bottomUpArray[2] = 1;

        for (int i = 3; i <= n; i++)
            bottomUpArray[i] = bottomUpArray[i - 1] + bottomUpArray[i - 2];

        return bottomUpArray[n];
    }
}
