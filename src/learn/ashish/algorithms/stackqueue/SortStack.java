package learn.ashish.algorithms.stackqueue;

import java.util.Stack;

/**
 * @author Ashish Sanagar
 */
public class SortStack {
    public static void main(String[] args) {
        Stack<Integer> s1 = new Stack<>();
        s1.push(3);
        s1.push(2);
        s1.push(9);

        Stack<Integer> sorted = new SortStack().sort(s1);

        while (!sorted.isEmpty()) {
            System.out.print(sorted.pop() + " ");
        }
    }

    private static Stack<Integer> sort(Stack<Integer> unsorted) {
        Stack<Integer> sorted = new Stack<>();

        while (!unsorted.isEmpty()) {
            int temp = unsorted.pop();

            while (!sorted.isEmpty() && temp > sorted.peek()) {
                unsorted.push(sorted.pop());
            }

            sorted.push(temp);
        }

        return sorted;
    }
}
