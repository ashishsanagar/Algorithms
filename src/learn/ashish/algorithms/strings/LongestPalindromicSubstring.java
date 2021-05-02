package learn.ashish.algorithms.strings;

public class LongestPalindromicSubstring {
    public static void main(String[] args) {
        System.out.println(new LongestPalindromicSubstring().find("tattarrattat"));
    }

    /**
     * Missing few usecases with even number..
     * .. example "tattarrattat", abba
     *
     * @param x
     * @return
     */
    public String find(String x) {
        int startIndex = 0;
        int endIndex = 0;

        for (int i = 0; i < toString().length(); i++) {
            int len1 = expandMiddle(x, i, i);
            int len2 = expandMiddle(x, i, i + 1);

            int currMax = Math.max(len1, len2);

            if ((endIndex - startIndex) < currMax) {
                startIndex = i - (currMax - 1) / 2;
                endIndex = i + (currMax) / 2;
            }
        }

        return x.substring(startIndex, endIndex + 1);
    }

    public int expandMiddle(String s, int start, int end) {
        if (s == null || end < start) return 0;

        while (start >= 0 && end < s.length() && s.charAt(start) == s.charAt(end)) {
            start--;
            end++;
        }

        return end - start - 1;
    }
}
