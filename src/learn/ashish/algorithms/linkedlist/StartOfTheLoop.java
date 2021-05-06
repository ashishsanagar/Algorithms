package learn.ashish.algorithms.linkedlist;

/**
 * @author Ashish Sanagar
 */
public class StartOfTheLoop {

    public static void main(String[] args) {
        StartOfTheLoop obj = new StartOfTheLoop();

        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);

        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n3;

        //LOOP exists use case
        Node loopStartNode = obj.findStartOfTheLoop(n1);

        if (loopStartNode == null)
            System.out.println("No loop");
        else
            System.out.println("Loop starts at: " + loopStartNode.data);

        //NO LOOP use case
        n4.next = null;
        loopStartNode = obj.findStartOfTheLoop(n1);

        if (loopStartNode == null)
            System.out.println("No loop");
        else
            System.out.println("Loop starts at: " + loopStartNode.data);

    }

    /**
     * 2 pointers, slow pointers move one node at a time, fast pointer moves 2 nodes at a time.
     * If they reach same node, loop exists. Move both pointers one at a time.
     * Next time they meet is the start of the loop
     *
     * @param head
     * @return
     */
    public Node findStartOfTheLoop(Node head) {
        if (head == null)
            return null;

        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast)
                break;
        }

        if (fast != null && fast.next != null) {
            slow = head;

            while (slow != fast) {
                slow = slow.next;
                fast = fast.next;
            }
        } else
            return null;

        return fast;
    }
}
