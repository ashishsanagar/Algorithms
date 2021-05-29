package learn.ashish.algorithms.misc;

public class ExcelSheetColumnNumber {
    /**
     * Given a string columnTitle that represents the column title as appear in an Excel sheet, return its corresponding column number.
     * A -> 1
     * B -> 2
     * C -> 3
     * ...
     * Z -> 26
     * AA -> 27
     * AB -> 28
     * <p>
     * Input: columnTitle = "A"
     * Output: 1
     */
    public static void main(String[] args) {
        System.out.println(new ExcelSheetColumnNumber().titleToNumber("AB"));
    }

    public int titleToNumber(String columnTitle) {
        int sum = 0;
        int strlen = columnTitle.length();

        for (int i = strlen - 1; i >= 0; i--) {
            sum += Math.pow(26, strlen - 1 - i) * (((int) columnTitle.charAt(i)) - 'A' + 1); // adding one as 'A' - 'A'= 0
        }

        return sum;
    }
}
