package learn.ashish.algorithms.strings;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Ashish Sanagar
 */
public class SentenseMadeUpOfDictWords {

    List<String> dict = new ArrayList() {{
        add("do");
        add("dot");
        add("dog");
        add("dogmatic");
    }};

    /**
     * You have dictionary of words, for given phrase without spaces check if sentence is madeup of dictionary words
     */
    public static void main(String[] args) {
        System.out.println(new SentenseMadeUpOfDictWords().isMadeUpOf("dodogmatic"));
        System.out.println(new SentenseMadeUpOfDictWords().findImproved("dodogmatic"));

    }

    public boolean findImproved(String phrase) {
        boolean[] result = new boolean[phrase.length() + 1];
        result[0] = true; // we added 0th position to hold empty char. Which is always part of dict

        for (int i = 1; i <= phrase.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (result[j] && dict.contains(phrase.substring(j, i))) {
                    result[i] = true;
                    break; // as string till jthe position was valid and remaining string between
                    // j and i is valid, string till i is valid
                }
            }
        }

//        for (boolean b : result) {
//            System.out.print(b + " ");
//        }
        return result[phrase.length()];
    }

    public boolean isMadeUpOf(String phrase) {
        if (phrase == null || phrase.length() == 0) return true;

        //sort descending order by word length
        Collections.sort(dict, (x, y) -> y.length() - x.length());

        for (String word : dict) {
            phrase = phrase.replaceAll(word, "");

            if (phrase.trim().length() == 0) {
                return true;
            }
        }

        return false;
    }
}
