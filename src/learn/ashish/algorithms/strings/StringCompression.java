package learn.ashish.algorithms.strings;

public class StringCompression {

    /**
     * Input: chars = ["a","a","b","b","c","c","c"]
     * Output: Return 6, and the first 6 characters of the input array should be: ["a","2","b","2","c","3"]
     * Explanation: The groups are "aa", "bb", and "ccc". This compresses to "a2b2c3".
     * <p>
     * Input: chars = ["a","b","b","b","b","b","b","b","b","b","b","b","b"]
     * Output: Return 4, and the first 4 characters of the input array should be: ["a","b","1","2"].
     * Explanation: The groups are "a" and "bbbbbbbbbbbb". This compresses to "ab12".
     */
    public static void main(String[] args) {
        char[] chars = {'a', 'a', 'b', 'b', 'c', 'c', 'c'};

        int count = new StringCompression().compress(chars);
        System.out.println(count);

        for (int i = 0; i < count; i++)
            System.out.print(chars[i] + ", ");
    }

    public int compress(char[] chars) {
        int i = 0;
        int index = 0;

        while (i < chars.length) {
            int j = i;

            while (j < chars.length && chars[i] == chars[j])
                j++;

            chars[index++] = chars[i];

            if (j - i > 1) {
                String num = (j - i) + "";
                for (char c : num.toCharArray()) {
                    chars[index++] = c;
                }
            }

            i = j;
        }

        return index;
    }

}
