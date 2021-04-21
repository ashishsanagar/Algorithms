package learn.ashish.algorithms.misc;

public class NumberIsPrime {

    public static void main(String[] args) {
        System.out.println(new NumberIsPrime().isPrime(13));
    }

    private boolean isPrime(int n) {
        if (n == 1 || n == 2) return true;

        for (int i = 2; i < Math.sqrt(n) + 1; i++) {
            if (n % i == 0) return false;
        }

        return true;
    }
}
