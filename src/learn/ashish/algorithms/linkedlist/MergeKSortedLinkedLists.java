package learn.ashish.algorithms.linkedlist;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class MergeKSortedLinkedLists {

    /**
     * There are k sorted singly linked lists, merge and return single sorted singly linked list
     *
     * @param args
     */
    public static void main(String[] args) {
        Node list1 = new Node(1);
        list1.next = new Node(12);
        list1.next.next = new Node(33);

        Node list2 = new Node(3);
        list2.next = new Node(5);
        list2.next.next = new Node(79);

        Node list3 = new Node(3);
        list3.next = new Node(15);
        list3.next.next = new Node(10);

        List<Node> list = new ArrayList() {{
            add(list1);
            add(list2);
            add(list3);
        }};

        Node sorted = new MergeKSortedLinkedLists().sort(list);

        while (sorted != null) {
            System.out.print(sorted.data + " -> ");
            sorted = sorted.next;
        }
    }

    private Node sort(List<Node> list) {
        if (list == null || list.size() == 0) return null;

        PriorityQueue<Integer> q = new PriorityQueue<>();
        for (Node head : list) {
            while (head != null) {
                q.add(head.data);
                head = head.next;
            }
        }

        Node dummy = new Node(-1);
        Node head = dummy;

        while (!q.isEmpty()) {
            head.next = new Node(q.poll());
            head = head.next;
        }

        return dummy.next;
    }


}
