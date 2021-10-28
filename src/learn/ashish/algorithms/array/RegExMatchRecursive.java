package learn.ashish.algorithms.array;

public class RegExMatchRecursive {

    public static void main(String[] args) {
        System.out.println(new RegExMatchRecursive().isMatch("aaa", "a*"));
        System.out.println(new RegExMatchRecursive().isMatch("ashish", "a.sh*..*"));
        System.out.println(new RegExMatchRecursive().isMatch("ashish", "a.sh*..sa"));
    }

    public boolean isMatch(String text, String pattern) {
        if (pattern.isEmpty())
            return text.isEmpty();

        boolean first = !text.isEmpty() && (text.charAt(0) == pattern.charAt(0) || '.' == pattern.charAt(0));

        if (pattern.length() >= 2 && pattern.charAt(1) == '*') {
            return isMatch(text, pattern.substring(2)) ||
                    (first && isMatch(text.substring(1), pattern));
        } else
            return first && isMatch(text.substring(1), pattern.substring(1));
    }
}
