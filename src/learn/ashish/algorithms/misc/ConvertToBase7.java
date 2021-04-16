package learn.ashish.algorithms.misc;

/**
 * @author Ashish Sanagar
 */
public class ConvertToBase7 {

    /**
     * 10 -> 13
     */
    public static void main(String[] args) {
        int number = 0;
        System.out.print(new ConvertToBase7().convert(number));
    }

    public String convert(int number) {
        String result = "";

        while (number > 0) {
            result = (number % 7) + result;
            number = number / 7;
        }

        return result;
    }
}
