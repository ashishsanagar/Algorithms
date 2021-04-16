package learn.ashish.algorithms.strings;

/**
 * @author Ashish Sanagar
 */
public class NumberToString {
    public static void main(String[] args) {
        int num = 20;

        System.out.println(new NumberToString().convert(num));
    }

    public String convert(int num) {
        String[] tens = {"Twenty", "Thirty", "Fourty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
        String[] ones = {"One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};

        String hundredStr = "";
        String tenStr = "";
        String oneStr = "";

        if (num >= 0 && num < 1000) {
            int hundred = num / 100;
            if (hundred > 0) {
                hundredStr = ones[hundred - 1] + " Hundred";
                num = num % 100;
            }

            int ten = num / 10;
            if (ten == 1) {
                tenStr = ones[num - 1];
                num = 0;
            } else if (ten > 1) {
                tenStr = tens[ten - 2];
                num = num % 10;
            }

            if (num > 0) {
                oneStr = ones[(num % 10) - 1];
            }
        } else
            throw new IllegalArgumentException("Range no suported");

        return hundredStr + " " + tenStr + " " + oneStr;
    }
}
