package learn.ashish.algorithms.linkedlist;

/**
 * @author Ashish Sanagar
 */
public class ReverseSinglyLinkedList {

    /**
     * input: 1 -> 2 -> 3 -> null (head at 1)
     * output: 3 -> 2 -> 1-> null (head at 3)
     */
    public static void main(String[] args) {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);

        node1.next = node2;
        node2.next = node3;

        Node head = new ReverseSinglyLinkedList().reverseLinkedList(node1);

        while (head != null) {
            System.out.print(head.data + " ");
            head = head.next;
        }
    }

    public Node reverseLinkedList(Node head) {
        Node pre = null;
        Node curr = null;
        Node next = head;

        while (next != null) {
            curr = next;

            next = curr.next;

            curr.next = pre;

            pre = curr;
        }

        return curr;
    }
}
