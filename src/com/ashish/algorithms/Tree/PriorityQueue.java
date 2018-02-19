package com.ashish.algorithms.Tree;

/**
 * @author Ashish Sanagar
 */
public class PriorityQueue {

	static int[] heap = {0, 0, 0, 0, 0, 0, 0};
	//8,7,5,4,2,1
	static int size = 0;

	/**
	 * we can use heap tree concept. in Max heap tree elements are added from left to right and root is always high
	 * formulas:
	 * leftChildIndex = 2 * parentIndex + 1
	 * leftChildIndex = 2 * parentIndex + 2
	 * oarentIndex = (childIndex -1)/2
	 */
	public static void main(String[] a) throws IllegalAccessException {

		push(5);
		push(14);
		push(8);
		push(6);
		push(3);
		push(6);
		push(23);

		for (int ele : heap) {
			System.out.print(ele + " ");
		}

		pop();
		System.out.println();

		for (int ele : heap) {
			System.out.print(ele + " ");
		}
	}

	//always pop top item from queue as its priority queue
	private static void pop() {
		int pos = 0;
		heap[pos] = heap[size - 1];
		heap[size - 1] = 0;

		while (pos < size / 2) {
			int leftChild = 2 * pos + 1;
			int rightChild = leftChild + 1;

			if (rightChild < size && heap[rightChild] > heap[leftChild]) {
				if (heap[rightChild] > heap[pos]) {
					swapElements(rightChild, pos);
					pos = rightChild;
				} else {
					break;
				}
			} else {
				if (heap[leftChild] > heap[pos]) {
					swapElements(leftChild, pos);
					pos = leftChild;
				} else {
					break;
				}
			}
		}

		size--;
	}

	private static void push(int node) throws IllegalAccessException {
		if (size == heap.length) throw new IllegalAccessException();

		int pos = size;
		heap[pos] = node;

		//node is inserted at end of heap. Check with parent if its less then swap
		while (pos > 0) {
			int parent = (pos + 1) / 2 - 1;

			if (heap[parent] >= heap[pos]) {
				break;
			}
			swapElements(parent, pos);
			pos = parent;
		}

		size++;
	}

	private static void swapElements(int i, int j) {
		int temp = heap[i];
		heap[i] = heap[j];
		heap[j] = temp;
	}
}
