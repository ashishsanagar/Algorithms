package learn.ashish.algorithms.tree;

/**
 * @author Ashish Sanagar
 */
public class PriorityQueue {

    /**
     * 8,7,5,4,2,1
     */
    static int[] heap;

    /**
     * Holds current size of heap
     */
    static int currSize = 0;

    public PriorityQueue(int size) {
        heap = new int[size];
    }

    /**
     * we can use max heap tree concept. in Max heap tree elements are added from left to right and root is always high
     * formulas:
     * leftChildIndex = 2 * parentIndex + 1
     * rightChildIndex = 2 * parentIndex + 2
     * parentIndex = (childIndex -1)/2
     */
    public static void main(String[] a) throws IllegalAccessException {
        PriorityQueue q = new PriorityQueue(8);
        q.push(5);
        q.push(14);
        q.push(8);
        q.push(6);
        q.push(3);
        q.push(6);
        q.push(23);

        for (int ele : heap) {
            System.out.print(ele + " ");
        }

        q.pop();
        System.out.println();

        for (int ele : heap) {
            System.out.print(ele + " ");
        }
    }

    private void swap(int i, int j) {
        int temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }

    /**
     * Element is added at the end of heap. Check with parent if its smaller than child then swap.
     *
     * @param ele
     * @throws IllegalAccessException
     */
    public void push(int ele) throws IllegalArgumentException {
        if (currSize == heap.length) throw new IllegalArgumentException();

        int pos = currSize;

        //node is inserted at end of heap.
        heap[pos] = ele;

        //Check with parent if its less then swap
        while (pos > 0) {
            int parent = (pos + 1) / 2 - 1;

            if (heap[parent] >= heap[pos]) {
                break;
            }

            swap(parent, pos);
            pos = parent;
        }

        currSize++;
    }

    /**
     * Always pop top item from queue. Move last element from heap to the top.
     * Check with children and swap if it does not follow heap tree constraints
     */
    public void pop() {
        int pos = 0;

        //move last element to the top
        heap[pos] = heap[currSize - 1];
        heap[currSize - 1] = 0;

        //needs log(n) iterations as there are log(n) leaf nodes
        while (pos < currSize / 2) {
            int leftChild = 2 * pos + 1;
            int rightChild = leftChild + 1;

            if (rightChild < currSize && heap[rightChild] > heap[leftChild]) {
                if (heap[rightChild] > heap[pos]) {
                    swap(rightChild, pos);
                    pos = rightChild;
                } else {
                    break;
                }
            } else {
                if (heap[leftChild] > heap[pos]) {
                    swap(leftChild, pos);
                    pos = leftChild;
                } else {
                    break;
                }
            }
        }

        currSize--;
    }
}
