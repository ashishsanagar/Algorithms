package learn.ashish.algorithms.linkedlist;

import java.util.HashSet;
import java.util.Set;

public class IntersectionOfTwoSinglyLinkedLists {

    /**
     * Given the heads of two singly linked-lists headA and headB, return the node at which the two lists intersect.
     * If the two linked lists have no intersection at all, return null.
     *
     * @param args
     */
    public static void main(String[] args) {
        Node common1 = new Node(10);
        Node common2 = new Node(11);

        //List 1
        Node list1 = new Node(1);
        list1.next = new Node(2);
        list1.next.next = new Node(3);
        list1.next.next.next = common1;
        list1.next.next.next.next = common2;

        //List 2
        Node list2 = new Node(3);
        list2.next = new Node(2);
        list2.next.next = common1;

        System.out.println(new IntersectionOfTwoSinglyLinkedLists().getIntersectionNode(list1, list2) == common1);
        System.out.println(new IntersectionOfTwoSinglyLinkedLists().getIntersectionNode(list1, list2) == common2);
    }

    public Node getIntersectionNode(Node headA, Node headB) {
        if (headA == null || headB == null)
            return null;

        Set<Node> set = new HashSet<>();

        while (headA != null) {
            set.add(headA);
            headA = headA.next;
        }

        while (headB != null) {
            if (set.contains(headB))
                return headB;
            else
                headB = headB.next;
        }

        return null;
    }

}
