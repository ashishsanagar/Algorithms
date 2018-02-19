package com.ashish.algorithms.Tree;

import java.util.Stack;

/**
 * @author Ashish Sanagar
 */
public class IterativePreOrderTraversal {

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

		preOrderTraversal(root);

	}

	/**
	 * root - left - right
	 */
	private static void preOrderTraversal(TreeNode root) {
		if (root == null) {
			return;
		}

		Stack<TreeNode> stack1 = new Stack<>();

		stack1.push(root);

		while (stack1.isEmpty() == false) {
			TreeNode node = stack1.pop();

			System.out.print(node.data + " ");

			if (node.right != null) {
				stack1.push(node.right);
			}

			if (node.left != null) {
				stack1.push(node.left);
			}
		}
	}

}
