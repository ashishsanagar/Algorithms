package com.ashish.algorithms.Tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @author Ashish Sanagar
 */
public class LevelOrderTraversalReverse {

	public static void main(String[] a) {
		BinaryTree tree = new BinaryTree();
		TreeNode root = new TreeNode(12);

		tree.insertNode(root, 10);
		tree.insertNode(root, 14);
		tree.insertNode(root, 13);
		tree.insertNode(root, 2);
		tree.insertNode(root, 0);
		tree.insertNode(root, 17);
		tree.insertNode(root, 6);
		tree.insertNode(root, 36);
		tree.insertNode(root, 15);

		new LevelOrderTraversalReverse().traverse(root);
	}

	/**
	 * 0 6 15 36 2 13 17 10 14 12
	 */
	public void traverse(TreeNode root) {
		if (root == null) {
			return;
		}

		Queue<TreeNode> queue = new LinkedList<>();
		Stack<TreeNode> stack = new Stack<>();

		queue.add(root);

		while (queue.isEmpty() == false) {
			TreeNode node = queue.poll();

			if (node.right != null) {
				queue.add(node.right);
			}

			if (node.left != null) {
				queue.add(node.left);
			}

			stack.push(node);
		}

		while (stack.isEmpty() == false) {
			System.out.print(stack.pop().data + " ");
		}
	}
}