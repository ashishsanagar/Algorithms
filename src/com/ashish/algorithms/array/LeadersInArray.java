package com.ashish.algorithms.array;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Ashish Sanagar
 */
public class LeadersInArray {

	/**
	 * element is leader if there are no elements larger on right side. last element is always a leader
	 */
	public static void main(String[] args) {
		int[] array = {88, 32, 44, 23, 57, 22, 33, 44, 55};

		printLeaders(array);
	}

	private static void printLeaders(int[] array) {
		if (array == null || array.length == 0) {
			return;
		}

		int currentLeader = array[array.length - 1];
		List<Integer> leaders = new ArrayList<>();
		leaders.add(currentLeader);

		for (int i = array.length - 2; i >= 0; i--) {

			if (array[i] > currentLeader) {
				currentLeader = array[i];
				leaders.add(currentLeader);
			}
		}

		leaders.forEach(leader -> System.out.println(leader));
	}
}
