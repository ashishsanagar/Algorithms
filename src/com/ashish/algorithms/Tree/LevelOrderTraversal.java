package com.ashish.algorithms.Tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Ashish Sanagar
 */
public class LevelOrderTraversal {

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

		levelOrderTraversal(root);
	}

	private static void levelOrderTraversal(TreeNode root) {
		if (root == null) {
			return;
		}

		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(root);

		while (queue.isEmpty() == false) {
			TreeNode node = queue.poll();
			System.out.print(node.data + " ");

			if (node.left != null) {
				queue.add(node.left);
			}

			if (node.right != null) {
				queue.add(node.right);
			}
		}

	}
}
