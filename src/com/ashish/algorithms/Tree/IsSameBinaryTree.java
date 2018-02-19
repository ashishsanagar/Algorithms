package com.ashish.algorithms.Tree;

/**
 * @author Ashish Sanagar
 */
public class IsSameBinaryTree {


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

		TreeNode root2 = new TreeNode(12);

		tree.insertNode(root2, 10);
		tree.insertNode(root2, 2);
		tree.insertNode(root2, 0);
		tree.insertNode(root2, -5);
		tree.insertNode(root2, 6);
		tree.insertNode(root2, 36);
		tree.insertNode(root2, 5);
		//tree.insertNode(root2, 5);

		System.out.println("is Same Tree: " + isSameTree(root, root2));


	}


	private static boolean isSameTree(TreeNode root1, TreeNode root2) {

		if (root1 == null && root2 == null) {
			return true;
		}

		if (root1 == null || root2 == null) {
			return false;
		}

		return root1.data == root2.data && isSameTree(root1.left, root2.left) && isSameTree(root1.right
				, root2.right);

	}


}




