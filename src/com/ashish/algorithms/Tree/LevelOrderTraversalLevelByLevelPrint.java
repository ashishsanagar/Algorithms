package com.ashish.algorithms.Tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Ashish Sanagar
 */
public class LevelOrderTraversalLevelByLevelPrint {

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

        new LevelOrderTraversalLevelByLevelPrint().traverse(root);
    }

    public void traverse(TreeNode root) {
        if (root == null) return;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        // this placeholder helps in finding the level change
        queue.add(null);

        while (true) {
            TreeNode node = queue.poll();

            if (node == null) {
                System.out.println(); // go to new line

                if (queue.isEmpty()) break;

                queue.add(null);
            } else {
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
}
