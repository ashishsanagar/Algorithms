package learn.ashish.algorithms.stackqueue;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @author Ashish Sanagar
 */
public class kLargestElementsFromStream {

    /**
     * Question: Find top 'k' elements from a list of 'n' elements.
     * input [100,20,30,40,50 ] k = 3 -> [40,50,100]
     */
    public static void main(String[] args) {
        List<Integer> list = new ArrayList();
        list.add(100);
        list.add(20);
        list.add(30);
        list.add(40);
        list.add(50);

        int k = 7;

        new kLargestElementsFromStream().find(list, k);
    }

    /**
     * Priority Queue
     *
     * @param list
     * @param k
     */
    public void find(List<Integer> list, int k) {
        if (list == null) return;
        if (list.size() < k) {
            list.stream().forEach(System.out::println);
            return;
        }

        PriorityQueue<Integer> queue = new PriorityQueue<>(k);

        list.stream().forEach(curr -> {
            if (queue.size() >= k && curr > queue.peek()) {
                queue.remove();
            }

            queue.add(curr);
        });

        queue.stream().forEach(System.out::println);
    }
}

