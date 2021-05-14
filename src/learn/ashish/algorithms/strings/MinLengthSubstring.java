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
     */
    public static void main(String[] args) {
        String s = "dcbefebmce";
        String t = "fdm";

        System.out.println(new MinLengthSubstring().minLengthSubstring(s, t));
    }

    private boolean isAnagramModified(String t, String temp) {
        if (t == null && temp == null)
            return true;

        int[] a = new int[256];

        for (char c : t.toCharArray())
            a[c]++;

        for (char c : temp.toCharArray())
            a[c]--;

        for (int c : a)
            if (c > 0) // this makes a difference. as we are deducting t from temp, extra chars will be in negative.
                return false;

        return true;
    }

    public int minLengthSubstring(String s, String t) {
        int min = Integer.MAX_VALUE;
        int i = 0;
        int j = t.length();

        while (i < s.length()) {
            String temp = s.substring(i, j);

            if (isAnagramModified(t, temp)) {
                min = Math.min(temp.length(), min);
                i++;
            } else {
                j++;

                // this means we have found min length as j moving length+1
                if (j > s.length())
                    break;
            }
        }

        return min == Integer.MAX_VALUE ? -1 : min;
    }

}
