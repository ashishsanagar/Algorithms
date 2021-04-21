package learn.ashish.algorithms.misc;

public class IsNumberPalindrome {
    public static void main(String[] args) {
        System.out.println(new IsNumberPalindrome().isPalindrome(1221));
    }

    public boolean isPalindrome(int n) {
        int reversed = 0;
        int n1 = n;

        while (n1 != 0) {
            int remainder = n1 % 10;
            reversed = reversed * 10 + remainder;
            n1 = n1 / 10;
        }

        return (n == reversed);
    }
}
