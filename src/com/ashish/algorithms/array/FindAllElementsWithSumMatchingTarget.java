package com.ashish.algorithms.array;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Ashish Sanagar
 */
public class FindAllElementsWithSumMatchingTarget {

	public static void main(String[] args) {
		int[] array = {1, 3, 4, 6, 7, 3, 7};
		int target = 7;

		Map<Integer, Integer> map = new HashMap<>();

		for (int i = 0; i < array.length; i++) {
			if (map.containsKey(array[i])) {
				System.out.println(array[map.get(array[i])] + " + " + array[i] + " = " + target);
			} else {
				map.put(target - array[i], i);
			}
		}
	}


}
