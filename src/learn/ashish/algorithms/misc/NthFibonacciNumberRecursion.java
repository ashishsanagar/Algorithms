
package learn.ashish.algorithms.misc;

/**
 * @author Ashish Sanagar
 */
public class NthFibonacciNumberRecursion {

    /**
     * using recursion
     */
    public static void main(String[] args) {
        int n = 3;
        System.out.println("nth number: " + new NthFibonacciNumberRecursion().fibonacci(n));
    }

    /**
     * series : 1 1 2 3 5... n = (n-1) + (n-2)
     */
    public int fibonacci(int n) {
        if (n == 0)
            return 0;

        if (n == 1 || n == 2)
            return 1;

        return fibonacci(n - 1) + fibonacci(n - 2);
    }
}
