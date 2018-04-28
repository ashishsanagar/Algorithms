package com.ashish.algorithms.Tree;

/**
 * @author Ashish Sanagar
 */
public class HeightOfBinaryTree {

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

		System.out.println("Height of tree: " + new HeightOfBinaryTree().findHeightOfTree(root));
	}

	public int findHeightOfTree(TreeNode root) {
		if (root == null) {
			return 0;
		}

		int leftHeight = findHeightOfTree(root.left);
		int rightHeight = findHeightOfTree(root.right);
		return 1 + Math.max(leftHeight, rightHeight);
	}

}
