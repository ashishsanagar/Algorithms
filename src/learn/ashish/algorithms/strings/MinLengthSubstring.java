package learn.ashish.algorithms.strings;

public class MinLengthSubstring {

    /**
     * You are given two strings s and t. You can select any substring of string s and rearrange the characters of
     * the selected substring. Determine the minimum length of the substring of s such that string t is a
     * substring of the selected substring.
     * <p>
     * s = "dcbefebce"
     * t = "fd"'
     * output = 5
     *
     * @param args
     */
    public static void main(String[] args) {
        String s = "dcbefebce";
        String t = "fd";

        System.out.println(new MinLengthSubstring().minLengthSubstring(s, t));
    }

    private boolean isAnagramModified(String s1, String s2) {
        if (s1 == null && s2 == null) return true;

        int[] a = new int[256];

        for (char c : s1.toCharArray()) {
            a[c]++;
        }

        for (char c : s2.toCharArray()) {
            a[c]--;
        }

        for (int c : a) {
            if (c > 0) return false;
        }

        return true;
    }

    int minLengthSubstring(String s, String t) {
        int min = Integer.MAX_VALUE;
        int i = 0;
        int j = 0;

        while (i < s.length()) {
            String temp = s.substring(i, j);

            if (isAnagramModified(t, temp)) {
                min = Math.min(temp.length(), min);
                i++;
            } else {
                j++;

                // this means we have found min length as j moving length+1
                if (j > s.length()) break;
            }
        }

        return min == Integer.MAX_VALUE ? -1 : min;
    }

}
