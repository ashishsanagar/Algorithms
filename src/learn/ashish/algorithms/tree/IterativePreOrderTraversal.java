package learn.ashish.algorithms.tree;

import java.util.Stack;

/**
 * @author Ashish Sanagar
 */
public class IterativePreOrderTraversal {

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

        new IterativePreOrderTraversal().traverse(root);
    }

    /**
     * root - left - right
     */
    public void traverse(TreeNode root) {
        if (root == null) return;

        Stack<TreeNode> stack = new Stack<>();

        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();

            System.out.print(node.data + " ");

            if (node.right != null)
                stack.push(node.right);

            if (node.left != null)
                stack.push(node.left);
        }
    }
}
