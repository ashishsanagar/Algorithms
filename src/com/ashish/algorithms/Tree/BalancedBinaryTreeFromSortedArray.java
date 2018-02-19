package com.ashish.algorithms.Tree;

/**
 * @author Ashish Sanagar
 */
public class BalancedBinaryTreeFromSortedArray {

	public static void main(String[] args) {
		int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9};

		TreeNode node = createBalancedBinaryTree(array, 0, array.length - 1);

		//verify by inorder traversal
		traverseBinaryTreeInOrder(node);
	}

	private static TreeNode createBalancedBinaryTree(int[] array, int start, int end) {
		if (end < start) {
			return null;
		}

		int mid = (start + end) / 2;
		TreeNode root = new TreeNode(array[mid]);

		root.left = createBalancedBinaryTree(array, start, mid - 1);
		root.right = createBalancedBinaryTree(array, mid + 1, end);

		return root;
	}

	private static void traverseBinaryTreeInOrder(TreeNode root) {
		if (root == null) {
			return;
		}

		traverseBinaryTreeInOrder(root.left);
		System.out.println(root.data + " ");
		traverseBinaryTreeInOrder(root.right);

	}
}
