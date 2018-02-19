package com.ashish.algorithms.misc;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author asanagar
 */
public class BalancedParenthesisCheck {

	public static void main(String args[]) {
		String goodCode = "{}[]{}";
		System.out.println(goodCode + ": " + isbalanced(goodCode));

		String badCode = "{}[{]{}";
		System.out.println(badCode + ": " + isbalanced(badCode));
	}

	public static boolean isbalanced(String code) {
		Stack<Character> stack = new Stack<>();

		for (int i = 0; i < code.length(); i++) {
			char charValue = code.charAt(i);

			if (charValue == '[' || charValue == '(' || charValue == '{') {
				stack.push(new Character(charValue));
			} else if (charValue == ']') {
				if (stack.isEmpty() || stack.pop() != '[') {
					return false;
				}
			} else if (charValue == ')') {
				if (stack.isEmpty() || stack.pop() != '(') {
					return false;
				}
			} else if (charValue == '}') {
				if (stack.isEmpty() || stack.pop() != '{') {
					return false;
				}
			}

		}
		return stack.isEmpty();
	}

	static class KLargestElementsSolution{

		public static void main(String[] args){
			int[] a = {2, 3, 66, 66, 67, 90};
			int target = 70;
			int k = 3;

			test(a, 91, k);

			test(a, target, 5);
		}

		private static void test(int[] a, int target, int k){

			System.out.println("Starting new  test...");

			int closest = findClosestIndex(a, target);

			List<Integer> result = findClosestKElements(a, closest, target, k);

			for(Integer val: result){
				System.out.println(val + " ");
			}
		}

		// {2, 3, 66, 66, 67, 90}
		// 4
		// i = 2
		// j = 5
		//result = 67, 66, 66
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
			//int closestVal = a[0];
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
}
