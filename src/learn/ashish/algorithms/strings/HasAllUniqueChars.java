package learn.ashish.algorithms.strings;

/**
 * @author Ashish Sanagar
 */
public class HasAllUniqueChars {

    public static void main(String[] args) {
        HasAllUniqueChars obj = new HasAllUniqueChars();

        System.out.println(obj.hasAllUniqueChars("abcdef"));
        System.out.println(obj.hasAllUniqueChars("aaabbs"));

        System.out.println(obj.hasAllUniqueCharsImproved("abcc"));
    }

    /**
     * no additional data structure. Assumes string is lowercase
     * keep setting bits and that bit is already set then there is duplicate char
     * e.g. aa
     * index 0, checker becomes 0001
     * index 1, 0001 & (1 << 0) = 0001, means bit is already set and there is duplicate
     */
    public boolean hasAllUniqueCharsImproved(String str) {
        int checker = 0;

        for (char c : str.toCharArray()) {
            int value = c - 'a';

            if ((checker & (1 << value)) > 0)
                return false;

            checker = checker | (1 << value);

            System.out.println("checker (" + c + ")=" + checker);
        }

        return true;
    }

    public boolean hasAllUniqueChars(String str) {
        boolean[] visited = new boolean[256];

        for (char c : str.toCharArray()) {
            if (!visited[c])
                visited[c] = true;
            else
                return false;
        }

        return true;
    }

}
