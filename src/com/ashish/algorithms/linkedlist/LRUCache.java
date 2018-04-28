package com.ashish.algorithms.linkedlist;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Ashish Sanagar
 */
public class LRUCache {

	int capacity;
	Map<Integer, Node> map;
	Node head = new Node(0, 0); // dummy
	Node tail = new Node(0, 0); // dummy

	public LRUCache(int capacity) {
		this.capacity = capacity;
		map = new HashMap<>(capacity);

		head.next = tail;
		tail.pre = head;
	}

	/**
	 * Least recently used cache. Add new elements to head of linkedlist and if cache size exceeds then remove from tail
	 */
	public static void main(String[] args) {

		LRUCache cache = new LRUCache(5);
		cache.put(1, 5);
		cache.put(3, 6);
		cache.put(2, 3);
		cache.put(4, 4);
		cache.put(5, 5); // at this point eviction starts
		cache.put(7, 7);
		cache.put(8, 7);
		cache.put(17, 7);

		//fetch and mark recently accessed
		cache.get(1);
	}

	//on put items is added at top and if map is at capacity remove least recently used
	public void put(int key, int value) {
		Node n = map.get(key);
		if (n != null) {
			n.value = value;

			remove(n);
			moveNodeToHead(n);
		} else {

			if (map.size() >= capacity) {
				//evictItem
				map.remove(tail.pre.key);
				remove(tail.pre);
			}
			n = new Node(key, value);
			map.put(key, n);
			moveNodeToHead(n);
		}

		System.out.println("Item added: " + key);
	}

	//on retrieval item should be moved to top as revcently accessed
	public Integer get(int key) {
		Integer value = null;
		Node n = map.get(key);
		if (n != null) {
			value = n.value;
			moveNodeToHead(n);
			System.out.println("Item retrieved: ");
		}
		return value;
	}

	private void remove(Node n) {
		n.pre.next = n.next;
		n.next.pre = n.pre;

		System.out.println("Item removed:" + n.key);
	}

	private void moveNodeToHead(Node newRecentNode) {
		Node currentRecent = head.next;
		head.next = newRecentNode;
		currentRecent.pre = newRecentNode;

		newRecentNode.pre = head;
		newRecentNode.next = currentRecent;

		System.out.println("Item moved to head:" + newRecentNode.key);
	}

	class Node {
		int key;
		int value;
		Node pre;
		Node next;

		public Node(int key, int value) {
			this.key = key;
			this.value = value;
		}
	}

}
