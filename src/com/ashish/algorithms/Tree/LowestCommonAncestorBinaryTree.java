package com.ashish.algorithms.Tree;

/**
 * @author Ashish Sanagar
 */
public class LowestCommonAncestorBinaryTree {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);

		TreeNode n1 = new TreeNode(10);
		TreeNode n2 = new TreeNode(2);
		TreeNode n3 = new TreeNode(5);
		TreeNode n4 = new TreeNode(34);
		TreeNode n5 = new TreeNode(12);

		root.left = n1;
		root.right = n2;

		n1.left = n3;
		n2.left = n4;
		n2.right = n5;

		TreeNode node = new LowestCommonAncestorBinaryTree().find(root, n5, n4);

		System.out.println(node.data);
	}

	public TreeNode find(TreeNode root, TreeNode p, TreeNode q) {
		if (root == null) {
			return null;
		}

		if ((root == p) || (root == q)) {
			return root;
		}

		TreeNode left = find(root.left, p, q);
		TreeNode right = find(root.right, p, q);

		return left != null && right != null ? root : left != null ? left : right;
	}
}
