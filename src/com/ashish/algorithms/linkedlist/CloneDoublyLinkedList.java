package com.ashish.algorithms.linkedlist;

/**
 * @author Ashish Sanagar
 */
public class CloneDoublyLinkedList {

	public static void main(String[] args) {

		Node node1 = new Node(3);
		Node node2 = new Node(6);
		Node node3 = new Node(8);
		Node node4 = new Node(9);

		node1.next = node2;
		node2.pre = node1;
		node2.next = node3;
		node3.pre = node2;
		node3.next = node4;
		node4.pre = node3;

		Node head = node1;

		System.out.print("Original Linkedlist: ");
		while (head != null) {
			System.out.print(head.data + " ");

			head = head.next;
		}

		head = node1;
		Node newNodeHead = new Node(head.data);
		newNodeHead.pre = null;

		Node pre = newNodeHead;

		head = head.next;

		while (head != null) {
			Node newNode = new Node(head.data);
			newNode.pre = pre;
			pre.next = newNode;

			pre = newNode;

			head = head.next;
		}

		System.out.print("\nCopied LiniedList: ");
		while (newNodeHead != null) {

			System.out.print(newNodeHead.data + " ");

			newNodeHead = newNodeHead.next;
		}
	}
}
