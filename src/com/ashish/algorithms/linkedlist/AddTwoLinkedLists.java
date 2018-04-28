package com.ashish.algorithms.linkedlist;

/**
 * @author Ashish Sanagar
 */
public class AddTwoLinkedLists {

	/**
	 * [1 -> 2 -> 3] + [3 -> 2 -> 1] = [4 -> 4 -> 4]
	 */
	public static void main(String[] args) {

		//List 1
		Node list1 = new Node(1);
		Node node2 = new Node(2);
		Node node3 = new Node(3);
		list1.next = node2;
		node2.next = node3;

		//List 2
		Node list2 = new Node(3);
		Node n2 = new Node(2);
		Node n3 = new Node(1);
		list2.next = n2;
		n2.next = n3;

		Node result = new AddTwoLinkedLists().addTwoLinkedLists(list1, list2);

		while (result != null) {
			System.out.print(result.data + " -> ");
			result = result.next;
		}
	}

	public Node addTwoLinkedLists(Node list1, Node list2) {
		Node dummy = new Node(0);

		Node p = list1;
		Node q = list2;
		Node curr = dummy;
		int carry = 0;

		while (p != null || q != null) {

			int x = p != null ? p.data : 0;
			int y = q != null ? q.data : 0;
			int sum = carry + x + y;

			carry = sum / 10;

			curr.next = new Node(sum % 10);
			curr = curr.next;

			if (p != null) p = p.next;
			if (q != null) q = q.next;
		}

		if (carry > 0) {
			curr.next = new Node(carry);
		}
		return dummy.next;
	}
}
