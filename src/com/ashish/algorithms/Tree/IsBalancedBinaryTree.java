package com.ashish.algorithms.Tree;

/**
 * @author Ashish Sanagar
 */
public class IsBalancedBinaryTree {
	public static void main(String[] a) {
		BinaryTree tree = new BinaryTree();
		TreeNode root = new TreeNode(12);

		tree.insertNode(root, 10);
		tree.insertNode(root, 12);
		tree.insertNode(root, 9);
		tree.insertNode(root, -5);
		tree.insertNode(root, 6);
		tree.insertNode(root, 36);
		tree.insertNode(root, 5);

		IsBalancedBinaryTree obj = new IsBalancedBinaryTree();
		System.out.println("is balanced binary tree: " + obj.isBalanced(root));


		root = new TreeNode(12);
		tree.insertNode(root, 10);
		tree.insertNode(root, 13);
		tree.insertNode(root, 9);
		tree.insertNode(root, 15);
		System.out.println("is balanced binary tree: " + obj.isBalanced(root));
	}

	public boolean isBalanced(TreeNode root) {
		return ((findMaxHeightOfTree(root) - findMinHeightOfTree(root)) <= 1);
	}

	private int findMaxHeightOfTree(TreeNode root) {
		if (root == null) {
			return 0;
		}

		int leftHeight = findMaxHeightOfTree(root.left);
		int rightHeight = findMaxHeightOfTree(root.right);
		return 1 + Math.max(leftHeight, rightHeight);
	}

	private int findMinHeightOfTree(TreeNode root) {
		if (root == null) {
			return 0;
		}

		return 1 + Math.min(findMinHeightOfTree(root.left), findMinHeightOfTree(root.right));
	}
}
