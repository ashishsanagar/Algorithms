package learn.ashish.algorithms.misc;

public class VerifyAlienDictionary {

    /**
     * In an alien language, surprisingly they also use english lowercase letters, but possibly in a different order.
     * The order of the alphabet is some permutation of lowercase letters.
     * Given a sequence of words written in the alien language, and the order of the alphabet,
     * return true if and only if the given words are sorted lexicographicaly in this alien language.
     * <p>
     * Example 1:
     * Input: words = ["hello","leetcode"], order = "hlabcdefgijkmnopqrstuvwxyz"
     * Output: true
     * Explanation: As 'h' comes before 'l' in this language, then the sequence is sorted.
     */
    public static void main(String[] args) {
        String order = "hlabcdefgijkmnopqrstuvwxyz";
        String[] words = {"hello", "leetcode"};

        System.out.println(new VerifyAlienDictionary().isAlienSorted(words, order));
    }

    public boolean isAlienSorted(String[] words, String order) {

        // for each character in order assign ith index for faster lookup of order of chars for comparison
        int[] dict = new int[26];
        for (int i = 0; i < order.length(); i++)
            dict[order.charAt(i) - 'a'] = i;

        for (int i = 0; i < words.length - 1; i++) {
            int min = Math.min(words[i].length(), words[i + 1].length());

            // get the length of shorter word and compare chars
            for (int k = 0; k < min; k++) {
                char left = words[i].charAt(k);
                char right = words[i + 1].charAt(k);

                // as work itself if in given order, if first letter between 2 words in comparison is in order, then break
                if (dict[left - 'a'] < dict[right - 'a'])
                    break;
                else if (dict[left - 'a'] > dict[right - 'a'])
                    return false; // if first letter between word is not in order.
                else if (k == min - 1 && words[i].length() > words[i + 1].length())
                    return false; // if we reached end of shorter word, means chars are equal till this point. return false
                //as first word is longer
            }
        }

        return true;
    }
}
