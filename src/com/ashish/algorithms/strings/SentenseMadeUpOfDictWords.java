package com.ashish.algorithms.strings;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author Ashish Sanagar
 */
public class SentenseMadeUpOfDictWords {

	/**
	 * You have dictionary of words, for given sentense without spaces check if sentence is madeup of dictionary words
	 */
	public static void main(String[] args) {
		String[] dict = {"do", "dot", "dog", "dogmatic"};

		System.out.println(new SentenseMadeUpOfDictWords().isMadeUpOf(dict, "dodogmatic"));
	}

	public boolean isMadeUpOf(String[] dict, String phrase) {
		List<String> dictList = Arrays.asList(dict);

		Collections.sort(dictList);

		for (int i = dictList.size() - 1; i >= 0; i--) {

			phrase = phrase.replaceAll(dictList.get(i), "");

			if (phrase.length() == 0) {
				return true;
			}
		}

		return false;
	}
}