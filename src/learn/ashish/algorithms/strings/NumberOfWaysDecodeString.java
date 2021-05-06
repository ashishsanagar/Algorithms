package learn.ashish.algorithms.strings;

public class NumberOfWaysDecodeString {

    /**
     * String is encoded by mappings a -> 1, b -> 2... z->26
     * Given a string input of all digits find number of ways it can be decoded
     * <p>
     * e.g. "12" can be "ab" or "l" -> there are 2 ways
     * 12345
     */
    public static void main(String[] args) {
        String encoded = "12";
        System.out.println("recursive: " + new NumberOfWaysDecodeString().find(encoded));
        System.out.println("DP: " + new NumberOfWaysDecodeString().dp(encoded));
    }

    public int dp(String encoded) {
        if (encoded == null || encoded.length() == 0 || encoded.charAt(0) == '0')
            return 0;

        int dp[] = new int[encoded.length() + 1];
        dp[0] = 1;
        dp[1] = 1;

        for (int i = 2; i < dp.length; i++) {
            int oneDigit = Integer.valueOf(encoded.substring(i - 1, i));
            int twoDigit = Integer.valueOf(encoded.substring(i - 2, i));

            if (oneDigit > 0)
                dp[i] += dp[i - 1];
            if (twoDigit >= 10 && twoDigit <= 26)
                dp[i] += dp[i - 2];
        }

        return dp[encoded.length()];
    }

    public int find(String encoded) {
        if (encoded.startsWith("0"))
            return 0; // no mapping for 0 in encoding

        Integer[] memo = new Integer[encoded.length() + 1];
        return recursion(encoded.toCharArray(), encoded.length(), memo);
    }

    private int recursion(char[] encoded, int k, Integer[] memo) {
        if (k == 0)
            return 1;

        if (memo[k] != null)
            return memo[k];

        int index = encoded.length - k;

        if (encoded[index] == '0')
            return 1;

        int count = recursion(encoded, k - 1, memo);

        if (k >= 2 && Integer.valueOf(encoded[index] + "" + encoded[index + 1]) <= 26)
            count += recursion(encoded, k - 2, memo);

        memo[k] = count;

        return count;
    }
}
