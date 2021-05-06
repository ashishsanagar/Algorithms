package learn.ashish.algorithms.linkedlist;


public class SwapNodesInPairs {

    /**
     * Given a linked list, swap every two adjacent nodes and return its head.
     */
    public static void main(String[] args) {
        Node head = new Node(2);
        head.next = new Node(4);
        head.next.next = new Node(7);
        head.next.next.next = new Node(3);
        head.next.next.next.next = new Node(1);

        System.out.println("Before");
        Node dummy = new Node(-1);
        dummy.next = head;
        while (dummy.next != null) {
            System.out.print(dummy.next.data + " -> ");
            dummy.next = dummy.next.next;
        }

        head = new SwapNodesInPairs().swapPairs(head);

        System.out.println("\nAfter");
        while (head != null) {
            System.out.print(head.data + " -> ");
            head = head.next;
        }

    }

    public Node swapPairs(Node head) {
        if (head == null) return head;

        int pos = 0;
        Node dummy = new Node(-1);
        dummy.next = head;

        while (head.next != null) {
            if (pos == 0) {
                int temp = head.data;
                head.data = head.next.data;
                head.next.data = temp;
            }

            pos++;

            if (pos == 2)
                pos = 0;

            head = head.next;
        }

        return dummy.next;
    }
}
