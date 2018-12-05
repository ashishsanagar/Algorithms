package com.ashish.algorithms.strings;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author Ashish Sanagar
 */
public class SentenseMadeUpOfDictWords {

    String[] dict = {"do", "dot", "dog", "dogmatic"};

    /**
     * You have dictionary of words, for given phrase without spaces check if sentence is madeup of dictionary words
     */
    public static void main(String[] args) {

        System.out.println(new SentenseMadeUpOfDictWords().isMadeUpOf("dodogmatic"));
    }

    public boolean isMadeUpOf(String phrase) {

        if (phrase == null || phrase.length() == 0) return true;

        List<String> dictList = Arrays.asList(dict);

        //sort descending order by word length
        Collections.sort(dictList, (x, y) -> y.length() - x.length());

        //dictList.stream().forEach(System.out::println);

        for (String word : dictList) {
            phrase = phrase.replaceAll(word, "");

            if (phrase.trim().length() == 0) {
                return true;
            }
        }

        return false;
    }
}