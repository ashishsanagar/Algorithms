package com.ashish.algorithms.linkedlist;

/**
 * @author Ashish Sanagar
 */
public class FindNthLastElement {

	/**
	 * 1- -> 2 -> 3 -> 4 -> 5
	 * 2nd last element = 3
	 */
	public static void main(String[] args) {
		Node n1 = new Node(1);
		Node n2 = new Node(2);
		Node n3 = new Node(3);
		Node n4 = new Node(4);
		Node n5 = new Node(5);

		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n5;

		int n = 2;

		int value = new FindNthLastElement().findNthLastElement(n1, n);
		System.out.println("Nth last node is: " + value);
	}

	public int findNthLastElement(Node n1, int n) {

		Node follower = n1;
		Node curr = n1;

		for (int i = 0; i <= n; i++) {
			curr = curr.next;

			if (curr == null) return -1;
		}

		while (curr != null) {
			curr = curr.next;
			follower = follower.next;
		}

		return follower.value;
	}

	private static class Node {
		private int value;
		private Node next;

		private Node(int val) {
			value = val;
		}
	}
}
