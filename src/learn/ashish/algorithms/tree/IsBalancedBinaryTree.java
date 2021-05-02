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
        System.out.println("is balanced binary tree: " + helper.verify(root));

        //[1,2,3,4,5,6,null,8]
        root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.left.left.left = new TreeNode(8);
        
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
