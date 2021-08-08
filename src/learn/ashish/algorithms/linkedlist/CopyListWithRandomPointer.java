package learn.ashish.algorithms.linkedlist;

import java.util.HashMap;
import java.util.Map;

public class CopyListWithRandomPointer {
    static Map<Node, Node> visited = new HashMap<>();

    public static void main(String[] args) {
        Node node = new Node(10);
        Node node1 = new Node(5);
        Node node2 = new Node(3);

        node.next = node1;
        node.random = node2;

        node.next.next = node2;
        node.next.random = node;

        node.next.next.random = node;

        Node cloned = copyRandomList(node);
    }

    public static Node copyRandomList(Node head) {
        if (head == null)
            return null;

        if (visited.containsKey(head))
            return visited.get(head);

        Node node = new Node(head.val);

        visited.put(head, node);

        node.next = copyRandomList(head.next);
        node.random = copyRandomList(head.random);

        return node;
    }

    static class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            next = null;
            random = null;
        }
    }

}
