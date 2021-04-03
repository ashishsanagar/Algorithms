package com.ashish.algorithms.strings;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Ashish Sanagar
 */
public class SentenseMadeUpOfDictWords {

    List<String> dict = new ArrayList() {
        {
            add("do");
            add("dot");
            add("dog");
            add("dogmatic");
        }
    };

    /**
     * You have dictionary of words, for given phrase without spaces check if sentence is madeup of dictionary words
     */
    public static void main(String[] args) {
        System.out.println(new SentenseMadeUpOfDictWords().isMadeUpOf("dodogmatic"));
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
