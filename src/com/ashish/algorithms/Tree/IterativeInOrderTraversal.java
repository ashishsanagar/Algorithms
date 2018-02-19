package com.ashish.algorithms.Tree;

import java.util.Stack;

/**
 * @author Ashish Sanagar
 */
public class IterativeInOrderTraversal {

	public static void main(String[] a) {
		BinaryTree tree = new BinaryTree();
		TreeNode root = new TreeNode(12);

		tree.insertNode(root, 10);
		tree.insertNode(root, 2);
		tree.insertNode(root, 0);
		tree.insertNode(root, -5);
		tree.insertNode(root, 6);
		tree.insertNode(root, 36);
		tree.insertNode(root, 5);

		inOrderTraversal(root);

	}

	/**
	 * root - left - right
	 */
	private static void inOrderTraversal(TreeNode root) {
		if (root == null) {
			return;
		}

		Stack<TreeNode> stack1 = new Stack<>();

		while (true) {
			if (root != null) {
				stack1.push(root);
				root = root.left;
			} else {
				if (stack1.isEmpty()) {
					break;
				}

				root = stack1.pop();

				System.out.print(root.data + " ");
				root = root.right;
			}

		}
	}

}
