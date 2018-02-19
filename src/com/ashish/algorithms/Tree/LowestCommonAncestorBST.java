package com.ashish.algorithms.Tree;

/**
 * @author Ashish Sanagar
 */
public class LowestCommonAncestorBST {

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

		System.out.println("lowestCommonAncestor: " + lowestCommonAncestor(root, new TreeNode(36), new TreeNode(17)).data);
	}

	/**
	 * 0 6 15 36 2 13 17 10 14 12
	 */
	private static TreeNode lowestCommonAncestor(TreeNode root, TreeNode node1, TreeNode node2) {
		if (root.data > Math.max(node1.data, node2.data)) {
			return lowestCommonAncestor(root.left, node1, node2);
		} else if (root.data < Math.min(node1.data, node2.data)) {
			return lowestCommonAncestor(root.right, node1, node2);
		} else {
			return root;
		}
	}
}
