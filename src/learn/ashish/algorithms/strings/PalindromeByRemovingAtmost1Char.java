package learn.ashish.algorithms.strings;

public class PalindromeByRemovingAtmost1Char {

    /**
     * remove atmost one char from string and return true new sting is palindrome
     * "abc" -> true
     * "abca" -> true
     * "abcda" -> false
     */
    public static void main(String[] args) {
        String input = "tcaac";

        System.out.println(new PalindromeByRemovingAtmost1Char().find(input));
    }

    public boolean find(String str) {
        if (str == null || str.isEmpty() || str.length() == 1) return true;

        int i = 0;
        int j = str.length() - 1;

        while (i < j) {
            if (str.charAt(i) != str.charAt(j))
                return isPalindrome(str, i, j - 1) || isPalindrome(str, i + 1, j);
            
            i++;
            j--;
        }


        return true;
    }

    private boolean isPalindrome(String str, int i, int j) {
        if (str == null || str.isEmpty() || str.length() == 1)
            return true;

        while (i < j) {
            if (str.charAt(i++) != str.charAt(j--))
                return false;
        }

        return true;
    }
}
