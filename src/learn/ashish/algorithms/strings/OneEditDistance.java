package learn.ashish.algorithms.strings;

public class OneEditDistance {
    /**
     * Given two strings s and t, return true if they are both one edit distance apart, otherwise return false.
     * <p>
     * Input: s = "ab", t = "acb"
     * Output: true
     * Explanation: We can insert 'c' into s to get t.
     */
    public static void main(String[] args) {
        System.out.println(isOneEditDistance("ab", "acb"));
        System.out.println(isOneEditDistance("ab", "Ab"));
        System.out.println(isOneEditDistance("ab", "Aba"));
    }

    public static boolean isOneEditDistance(String s, String t) {
        if (s == null && t == null) return true;

        int len1 = s.length();
        int len2 = t.length();

        if (s.equals(t)) return false;

        if (len1 > len2)
            return isOneEditDistance(t, s);

        for (int i = 0; i < len1; i++) {
            // if current chars not same, for same len string, we can exclude these chars and rest of the string should match
            // Otherwise, as first string is smaller than second one, we just need to skip char from second string
            // and match with current remaining string
            if (s.charAt(i) != t.charAt(i)) {
                if (len1 == len2)
                    return s.substring(i + 1).equals(t.substring(i + 1));
                else
                    return s.substring(i).equals(t.substring(i + 1));
            }
        }

        return true;
    }

}
