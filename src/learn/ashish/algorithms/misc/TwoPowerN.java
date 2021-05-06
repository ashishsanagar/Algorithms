package learn.ashish.algorithms.misc;

import java.math.BigInteger;

public class TwoPowerN {

    /**
     * 215 = 32768 and the sum of its digits is 3 + 2 + 7 + 6 + 8 = 26.
     */
    public static void main(String[] args) {
        System.out.println(new TwoPowerN().solve(1000));
    }

    public int solve(int b) {
        int a = 2;

        BigInteger number = new BigInteger(String.valueOf(a));
        BigInteger power = number.pow(b);

        String powerInString = String.valueOf(power);
        int length = powerInString.length();

        int sum = 0;

        for (int i = 0; i < length; i++)
            sum += powerInString.charAt(i) - '0';

        return sum;
    }
}
