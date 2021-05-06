package learn.ashish.algorithms.tree;

import java.util.Stack;

/**
 * @author Ashish Sanagar
 */
public class IterativeInOrderTraversal {

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

        new IterativeInOrderTraversal().traverse(root);
    }

    /**
     * left - root - right
     */
    public void traverse(TreeNode root) {
        if (root == null) return;

        Stack<TreeNode> stack = new Stack<>();

        while (true) {
            if (root != null) {
                stack.push(root);
                root = root.left;
            } else {
                if (stack.isEmpty())
                    break;

                root = stack.pop();

                System.out.print(root.data + " ");
                root = root.right;
            }
        }
    }
}
