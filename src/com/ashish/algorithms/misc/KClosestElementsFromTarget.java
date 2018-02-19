package com.ashish.algorithms.misc;



// This is the text editor interface.
// Anything you type or change here will be seen by the other person in real time.

// find k-nearest neighbor
// data = new int[] {2, 3, 66, 66, 67, 90} // sorted
// target = 70;
// k = 3;
//return {66, 66, 67}
// k <= data.length

import java.util.*;

public class KClosestElementsFromTarget{

	public static void main(String[] args){
		int[] a = {2, 3, 66, 66, 67, 90};
		int target = 70;
		int k = 3;

		test(a, 70, k);

		test(a, target, 2);
	}

	private static void test(int[] a, int target, int k){

		System.out.println("Starting new  test...");

		int closest = findClosestIndex(a, target);

		List<Integer> result = findClosestKElements(a, closest, target, k);

		for(Integer val: result){
			System.out.println(val + " ");
		}
	}

	private static List<Integer> findClosestKElements(int[] a, int index, int target, int k){
		List<Integer> result = new ArrayList<>();

		int i = index;

		if(index > 0){
			i--;
		}

		int j = index;

		if(index < a.length - 1){
			j++;
		}

		boolean foundAll = false;

		result.add(a[index]);

		if(k ==1){
			return result;
		}

		while(foundAll == false){
			int iSide = 0;
			int jSide = 0;

			if(i > 0){
				iSide = Math.abs(target - a[i]);
			}
			if(j < a.length){
				jSide = Math.abs(target - a[j]);
			}

			if(iSide < jSide){
				result.add(a[i]);
				if(i > 0){
					i--;
				}
			}else{
				result.add(a[j]);
				if(j < a.length - 1){
					j++;
				}
			}

			if(result.size() == k){
				foundAll = true;
			}

		}


		return result;
	}

	private static int findClosestIndex(int[] a, int target){

		if(a == null && a.length < 1){
			System.out.println("invalid");
		}

		int min = Math.abs(target - a[0]);

		int closestIndex = 0;

		for(int i=1; i < a.length; i++){
			int diff = Math.abs(target - a[i]);
			if(diff < min){
				min = diff;
				closestIndex = i;
			}
		}

		System.out.println("Closest Index = "+ closestIndex + " | closestVal="+ a[closestIndex]);

		return closestIndex;
	}



}