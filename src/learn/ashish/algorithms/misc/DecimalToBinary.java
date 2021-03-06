package learn.ashish.algorithms.misc;

/**
 * @author Ashish Sanagar
 */
public class DecimalToBinary {

    /**
     * Given a (decimal - e.g. 3.72) number that is passed in as a string, maxLength the binary rep-
     * resentation. If the number can not be represented accurately in binary, maxLength “ERROR”
     */
    public static void main(String[] args) {
        String n = "3.72343444";

        System.out.println(new DecimalToBinary().convert(n));
    }

    public String convert(String n) {
        int intPart = Integer.parseInt(n.substring(0, n.indexOf(".")));
        int decPart = Integer.parseInt(n.substring(n.indexOf(".") + 1));

        String intString = "";

        while (intPart > 0) {
            intString = (intPart % 2) + intString;
            intPart = intPart / 2;
        }

        StringBuilder decString = new StringBuilder();

        while (decPart > 0) {
            if (decString.length() > 32) {
                decString = new StringBuilder("error");
                break;
            }

            if (decPart == 1) {
                decString.append(1);
                break;
            }

            int r = decPart * 2;

            if (r >= 1) {
                decString.append(1);
                decPart = r - 1;
            } else {
                decString.append(0);
                decPart = r;
            }
        }

        return intString + "." + decString;
    }
}
