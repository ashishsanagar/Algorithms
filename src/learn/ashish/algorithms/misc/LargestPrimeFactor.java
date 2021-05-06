package learn.ashish.algorithms.misc;

public class LargestPrimeFactor {

    /**
     * The prime factors of 13195 are 5, 7, 13 and 29
     */
    public static void main(String[] args) {
        long n = new Long("13195");

        System.out.println(new LargestPrimeFactor().solve(n));
    }

    public long solve(long n) {
        long max = 0;

        for (long i = 2; i <= n; i++) {
            if (n % i == 0) {
                max = Math.max(max, i);
                n = n / i;
            }
        }

        return max;
    }
}
