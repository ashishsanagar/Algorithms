package com.ashish.algorithms.misc;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Ashish Sanagar
 */
public class ListIsSubList {

	/**
	 * list1 = [1,2,3,4]
	 * list2 = [2,3]
	 * Print true and startingIndex = 1
	 */
	public static void main(String[] args) {
		List<Integer> list1 = new ArrayList<>();
		List<Integer> list2 = new ArrayList<>();

		list1.add(1);
		list1.add(5);
		list1.add(5);
		list1.add(5);
		list1.add(2);
		list1.add(3);
		list1.add(4);

		list2.add(2);
		list2.add(3);

		int index = checkIfSubList(list1, list2);

		System.out.println(index);
		System.out.println("Expected: " + Collections.indexOfSubList(list1, list2));
	}

	private static int checkIfSubList(List<Integer> list1, List<Integer> list2) {
		int index = -1;

		if (list2 == null || list2.size() == 0) {
			return 0;
		}

		int i = 0;
		int j = 0;

		while (i < list1.size()) {

			if (list1.get(i) == list2.get(j)) {
				j++;
				index = i;
				if (j == list2.size() - 1) {
					break;
				}
			} else {
				j = 0;
				index = -1;
			}

			i++;
		}

		return index;
	}
}
