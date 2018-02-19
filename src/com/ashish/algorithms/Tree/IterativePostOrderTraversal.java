package com.ashish.algorithms.Tree;

import java.util.Stack;

/**
 * @author Ashish Sanagar
 */
public class IterativePostOrderTraversal {

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

		postOrderTraversal(root);

	}

	/**
	 * left - right - root
	 */
	private static void postOrderTraversal(TreeNode root) {
		if (root == null) {
			return;
		}

		Stack<TreeNode> stack1 = new Stack<>();
		Stack<TreeNode> stack2 = new Stack<>();

		stack1.push(root);

		while (stack1.isEmpty() == false) {
			TreeNode node = stack1.pop();

			stack2.add(node);

			if (node.left != null) {
				stack1.push(node.left);
			}
			if (node.right != null) {
				stack1.push(node.right);
			}

		}

		while (stack2.isEmpty() == false) {
			System.out.print(stack2.pop().data + " ");
		}
	}

}
