package com.ashish.algorithms.strings;

import java.util.*;

/**
 * @author Ashish Sanagar
 */
public class NthMostFrequentStringFromArray {
	public static void main(String[] args) {
		String[] array = {"ab", "bc", "bc", "ab", "bc", "as", "abc", "cd"};

		Map<String, Integer> map = new HashMap<>();

		for (int i = 0; i < array.length; i++) {
			Integer frequency = map.get(array[i]);

			if (frequency == null) frequency = 0;

			map.put(array[i], ++frequency);
		}

		List<Map.Entry> list = new ArrayList<>(map.entrySet());

		Collections.sort(list, new Comparator<Map.Entry>() {
			@Override
			public int compare(Map.Entry o1, Map.Entry o2) {
				Integer value1 = (Integer) o1.getValue();
				Integer value2 = (Integer) o2.getValue();

				return value1.compareTo(value2);
			}
		});

		System.out.println("2nd: " + list.get(4));
	}
}
