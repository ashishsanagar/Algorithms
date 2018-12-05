package com.ashish.algorithms.misc;

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

        int k = 3;

        new kLargestElementsFromStream().find(list, k);
    }

    public void find(List<Integer> list, int k) {
        PriorityQueue<Integer> q = new PriorityQueue<>(k);

        list.stream().forEach(curr -> {
            if (q.size() >= k && q.peek() < curr) {
                q.remove();
            }

            q.add(curr);
        });

        q.stream().forEach(System.out::println);
    }
}

