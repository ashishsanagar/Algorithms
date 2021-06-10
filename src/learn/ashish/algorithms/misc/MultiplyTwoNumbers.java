package learn.ashish.algorithms.misc;

/**
 * @author Ashish Sanagar
 */
public class MultiplyTwoNumbers {
    public static void main(String[] args) {
        int x = 20;
        int y = -10;

        int product = new MultiplyTwoNumbers().multiply(x, y);
        System.out.println(product);
    }

    public int multiply(int x, int y) {
        if (x < y)
            return multiply(y, x);

        boolean xSign = x < 0;
        boolean ySign = y < 0;

        int sum = 0;

        for (int i = 0; i < Math.abs(y); i++)
            sum += Math.abs(x);

        if ((xSign || ySign) && !(xSign && ySign))
            sum = sum - sum - sum;

        return sum;
    }
}

