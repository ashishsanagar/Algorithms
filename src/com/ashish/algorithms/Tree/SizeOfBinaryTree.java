package com.ashish.algorithms.Tree;

/**
 * @author Ashish Sanagar
 */
public class SizeOfBinaryTree {

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

		System.out.println("Size of tree 1: " + findSizeOfTree(root));

	}

	private static int findSizeOfTree(TreeNode root) {
		if (root == null) {
			return 0;
		}

		int left = findSizeOfTree(root.left);
		int right = findSizeOfTree(root.right);

		return left + right + 1;
	}


}
