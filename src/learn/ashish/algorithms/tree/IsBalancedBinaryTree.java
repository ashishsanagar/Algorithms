package learn.ashish.algorithms.tree;

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
        System.out.println("is balanced binary tree: " + helper.isBalanced(root));

        //[1,2,3,4,5,6,null,8]
        root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.left.left.left = new TreeNode(8);

        System.out.println("is balanced binary tree: " + helper.isBalanced(root));
    }

    public static int height(TreeNode root) {
        if (root == null)
            return 0;

        int leftHeight = height(root.left);
        int rightHeight = height(root.right);

        return 1 + Math.max(leftHeight, rightHeight);
    }

    public boolean isBalanced(TreeNode root) {
        if (root == null)
            return true;

        return isBalanced(root.left)
                && isBalanced(root.right)
                && (Math.abs(height(root.left) - height(root.right)) <= 1);
    }
}
