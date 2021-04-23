package learn.ashish.algorithms.misc;

import java.math.BigInteger;

public class Fibonacci1000Digit {

    public static void main(String[] args) {
        System.out.println(new Fibonacci1000Digit().findFirst1000Digit());
    }

    public int findFirst1000Digit() {

        // limit as 1000 digits, helps in comparison
        BigInteger limit = (new BigInteger("10")).pow(999);

        // to save space, we want to store only 3 last finonacci numbers in sequence
        BigInteger[] fibs = new BigInteger[3];

        //As we are storing only 3 numbers, and fibonacci next sequence numbers is addtion of last 2,
        //we will use i = (i + 1)%3 to get our next index to store result
        fibs[0] = BigInteger.ONE;
        fibs[1] = BigInteger.ZERO;
        fibs[2] = BigInteger.ONE;

        int count = 2; // this is n for nth fibonacci number calculated
        int i = 0; // values will be maintained 0,1,2 all the time

        while (fibs[i].compareTo(limit) < 0) {
            i = (i + 1) % 3;
            count++;
            fibs[i] = fibs[(i + 1) % 3].add(fibs[(i + 2) % 3]);
        }

        return count;
    }
}
