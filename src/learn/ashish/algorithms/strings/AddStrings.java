package learn.ashish.algorithms.strings;

public class AddStrings {

    /**
     * Given two non-negative integers, num1 and num2 represented as string, return the sum of num1 and num2 as a string.
     */
    public static void main(String[] args) {
        System.out.println(new AddStrings().addStrings("121", "200"));
    }

    public String addStrings(String num1, String num2) {
        if (num1 == null || num2 == null) return null;

        int i = num1.length() - 1;
        int j = num2.length() - 1;
        int carry = 0;
        StringBuilder result = new StringBuilder();

        while (i >= 0 || j >= 0) {
            int sum = carry;

            if (i >= 0)
                sum += num1.charAt(i--) - '0';

            if (j >= 0)
                sum += num2.charAt(j--) - '0';

            result.insert(0, sum % 10);

            carry = sum / 10;
        }

        if (carry == 1) {
            result.insert(0, "1");
        }
        return result.toString();
    }
}
