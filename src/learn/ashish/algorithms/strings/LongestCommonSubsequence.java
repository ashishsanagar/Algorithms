package learn.ashish.algorithms.strings;

/**
 * @author Ashish Sanagar
 */
public class LongestCommonSubsequence {

    public static void main(String[] a) {
        String str1 = "abcdaf";
        String str2 = "acbcf";

        System.out.println("Longest seq: " + new LongestCommonSubsequence().getLongestCommonSequenceFromTwoStrings(str1.toCharArray(), str2.toCharArray()));
    }

    public int getLongestCommonSequenceFromTwoStrings(char[] str1, char[] str2) {
        int max = 0;
        int[][] dp = new int[str1.length + 1][str2.length + 1];

        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[i].length; j++) {

                //go thru row at a time,
                //if char in both arrays is same then get value from i-1 j-1 and add 1. Otherwise get max value from adjucent elements

                if (str1[i - 1] == str2[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
                }

                max = Math.max(max, dp[i][j]);
            }
        }

        StringBuilder sequence = new StringBuilder();
        for (int i = dp.length - 1; i >= 1; i--) {
            for (int j = dp[i].length - 1; j >= 1; j--) {

                if (dp[i][j] == dp[i][j - 1]) {
                    continue;
                } else if (dp[i][j] == dp[i - 1][j]) {
                    break;
                } else {
                    sequence.append(str1[i - 1]);
                    break;
                }
            }
        }

        System.out.println("Longest seq string: " + sequence.reverse());

        return max;
    }
}
