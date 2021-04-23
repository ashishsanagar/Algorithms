package learn.ashish.algorithms.misc;

import java.math.BigInteger;

public class FactorialDigitSum {

    public static void main(String[] args) {
        System.out.println(new FactorialDigitSum().solve(100));
    }

    public int solve(int n) {
        int sum = 0;

        String fact = factorial(n);

        for (char c : fact.toCharArray()) {
            sum += c - '0';
        }

        return sum;
    }

    private String factorial(int n) {
        BigInteger fact = BigInteger.ONE;

        for (int i = 1; i <= n; i++)
            fact = fact.multiply(BigInteger.valueOf(i));

        return fact.toString();
    }
}
