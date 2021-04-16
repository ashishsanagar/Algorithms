package learn.ashish.algorithms.Tree;

/**
 * @author Ashish Sanagar
 */
public class IsBalancedBinaryTree {
    public static void main(String[] a) {
        BinaryTree tree = new BinaryTree();
        TreeNode root = new TreeNode(12);
        tree.insertNode(root, 10);
        tree.insertNode(root, 12);
        tree.insertNode(root, 9);
        tree.insertNode(root, -5);
        tree.insertNode(root, 6);
        tree.insertNode(root, 36);
        tree.insertNode(root, 5);

        IsBalancedBinaryTree helper = new IsBalancedBinaryTree();
        System.out.println("is balanced binary tree: " + helper.verify(root));

        root = new TreeNode(12);
        tree.insertNode(root, 10);
        tree.insertNode(root, 13);
        tree.insertNode(root, 9);
        tree.insertNode(root, 15);
        System.out.println("is balanced binary tree: " + helper.verify(root));
    }

    public boolean verify(TreeNode root) {
        return ((maxHeight(root) - minHeight(root)) <= 1);
    }

    private int maxHeight(TreeNode root) {
        if (root == null) return 0;

        return 1 + Math.max(maxHeight(root.left), maxHeight(root.right));
    }

    private int minHeight(TreeNode root) {
        if (root == null) return 0;

        return 1 + Math.min(minHeight(root.left), minHeight(root.right));
    }
}
