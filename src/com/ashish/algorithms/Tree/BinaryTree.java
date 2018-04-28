package com.ashish.algorithms.Tree;

/**
 * @author Ashish Sanagar
 */
public class BinaryTree {

	/**
	 * Insert nodes in Binary tree
	 * Traverse binary tree
	 */
	public static void main(String[] a) {
		BinaryTree tree = new BinaryTree();
		TreeNode root = new TreeNode(5);

		tree.insertNode(root, 3);
		tree.insertNode(root, 2);
		tree.insertNode(root, 4);
		tree.insertNode(root, 6);
		tree.insertNode(root, 7);

		tree.traverseBinaryTree(root);

		tree.deleteNode(root, 3);

		System.out.println("\nAfter deletion: ");
		tree.traverseBinaryTree(root);
	}

	private void traverseBinaryTree(TreeNode root) {
		if (root == null) {
			return;
		}

		traverseBinaryTree(root.left);
		System.out.print(root.data + " -> ");
		traverseBinaryTree(root.right);
	}

	public TreeNode insertNode(TreeNode root, int data) {

		TreeNode newNode = new TreeNode(data);

		if (root == null) {
			return newNode;
		}

		TreeNode head = root;
		TreeNode parent = head;

		while (head != null) {
			parent = head;
			if (data < parent.data) {
				head = parent.left;
			} else {
				head = parent.right;
			}
		}

		if (data < parent.data) {
			parent.left = newNode;
		} else {
			parent.right = newNode;
		}

		return newNode;
	}

	/**
	 * when you found the node to delete,
	 * replace the value of the node with the available minimum value (min),
	 * then recursively delete that min value.
	 */
	public TreeNode deleteNode(TreeNode root, int key) {
		if (root == null) {
			return root;
		}

		if (root.data > key) {
			root.left = deleteNode(root.left, key);
		} else if (root.data < key) {
			root.right = deleteNode(root.right, key);
		} else {
			// found node to be deleted
			if (root.left == null) {
				return root.right;
			} else if (root.right == null) {
				return root.left;
			}
			// node with two children, replace with the inOrder successor(minVal) in the right subtree
			root.data = getMinSuccessorInOrder(root.right);
			System.out.println("Min: " + root.data);
			root.right = deleteNode(root.right, root.data);
		}
		return root;
	}

	/**
	 * To find successor, go to right and pic left most child.
	 */
	private int getMinSuccessorInOrder(TreeNode root) {
		while (root.left != null) {
			root = root.left;
		}
		return root.data;
	}
}