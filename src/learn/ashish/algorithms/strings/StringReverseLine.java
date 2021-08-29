package learn.ashish.algorithms.strings;

/**
 * @author asanagar
 */
public class StringReverseLine {
    public static void main(String[] args) {
        System.out.println(reverseSentence("Friday is Today"));
    }

    public static String reverseSentence(String sentence) {
        if (sentence == null || sentence.length() == 0)
            return sentence;

        int i = 0;
        int j = sentence.length() - 1;

        while (i < j) {
            sentence = swapChars(sentence, i++, j--);
        }

        i = 0;
        j = 0;
        int k = 0;

        while (i < sentence.length() || j < sentence.length()) {
            if (j < sentence.length() && sentence.charAt(j) != ' ') {
                j++;
                continue;
            }

            k = j;
            j--;

            while (i < j) {
                sentence = swapChars(sentence, i++, j--);
            }

            i = k + 1;
            j = k + 1;
        }

        return sentence;
    }

    private static String swapChars(String s, int i, int j) {
        char left = s.charAt(i);
        char right = s.charAt(j);

        s = s.substring(0, i) + right + s.substring(i + 1);
        s = s.substring(0, j) + left + s.substring(j + 1);

        return s;
    }
}
