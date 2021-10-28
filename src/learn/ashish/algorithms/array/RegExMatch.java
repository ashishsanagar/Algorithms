package learn.ashish.algorithms.array;

public class RegExMatch {

    public static void main(String[] args) {
        System.out.println(new RegExMatch().match("aaa".toCharArray(), "a*".toCharArray()));
        System.out.println(new RegExMatch().match("ashish".toCharArray(), "a.sh*..*".toCharArray()));
        System.out.println(new RegExMatch().match("ashish".toCharArray(), "a.sh*..sa".toCharArray()));
    }

    public boolean match(char[] text, char[] pattern) {
        boolean[][] result = new boolean[text.length + 1][pattern.length + 1];
        result[0][0] = true; // base case,  empty string matches empty pattern

        // handles a*, a*b* etc
        for (int j = 2; j < result[0].length; j++)
            if (pattern[j - 1] == '*')
                result[0][j] = result[0][j - 2];

        for (int i = 1; i < result.length; i++) {
            for (int j = 1; j < result[0].length; j++) {

                // char matches pattern char, or pattern is '.', which matches any char
                if ((text[i - 1] == pattern[j - 1]) || pattern[j - 1] == '.')
                    result[i][j] = true;
                else if (pattern[j - 1] == '*') {
                    result[i][j] = result[i][j - 2];

                    if (pattern[j - 2] == '.' || pattern[j - 2] == text[i - 1])
                        result[i][j] = result[i][j] | result[i - 1][j];
                } else
                    result[i][j] = false;
            }
        }

        return result[text.length][pattern.length];
    }
}
