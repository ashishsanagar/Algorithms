package learn.ashish.algorithms.strings;

public class NumberOfWaysDecodeString {

    /**
     * String is encoded by mappings a -> 1, b -> 2... z->26
     * Given a string input of all digits find number of ways it can be decoded
     * <p>
     * e.g. "12" can be "ab" or "l" -> there are 2 ways
     * 12345
     *
     * @param args
     */
    public static void main(String[] args) {
        String encoded = "12";
        System.out.println(new NumberOfWaysDecodeString().find(encoded));
    }

    public int find(String encoded) {
        if (encoded.startsWith("0")) return 0; // no mapping for 0 in encoding

        Integer[] memo = new Integer[encoded.length() + 1];
        return recursion(encoded.toCharArray(), encoded.length(), memo);
    }

    private int recursion(char[] encoded, int k, Integer[] memo) {
        if (k == 0) return 1;

        if (memo[k] != null) return memo[k];

        int s = encoded.length - k;
        if (encoded[s] == '0') return 0;

        int count = recursion(encoded, k - 1, memo);

        if ((k >= 2) && Integer.valueOf(encoded[s] + "" + encoded[s + 1]) <= 26) {
            count += recursion(encoded, k - 2, memo);
        }

        memo[k] = count;

        return count;
    }
}
