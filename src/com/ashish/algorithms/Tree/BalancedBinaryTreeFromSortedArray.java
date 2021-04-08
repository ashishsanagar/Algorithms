package com.ashish.algorithms.Tree;

/**
 * @author Ashish Sanagar
 */
public class BalancedBinaryTreeFromSortedArray {

    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9};

        BalancedBinaryTreeFromSortedArray obj = new BalancedBinaryTreeFromSortedArray();
        TreeNode node = obj.create(array, 0, array.length - 1);

        //verify by inorder traversal
        obj.traverseInOrder(node);
    }

    public TreeNode create(int[] array, int start, int end) {
        if (end < start) return null;

        int mid = (start + end) / 2;
        TreeNode root = new TreeNode(array[mid]);

        root.left = create(array, start, mid - 1);
        root.right = create(array, mid + 1, end);

        return root;
    }

    public void traverseInOrder(TreeNode root) {
        if (root == null) return;

        traverseInOrder(root.left);
        System.out.println(root.data + " ");
        traverseInOrder(root.right);
    }
}
