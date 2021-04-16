package learn.ashish.algorithms.Tree;

/**
 * @author Ashish Sanagar
 */
public class IsBinarySearchTree {

    /**
     * Binary tree left nodes are smaller than root and right nodes are greater than root
     * <p>
     * root.left.data < root.data <= root.right.data
     */
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

        System.out.println("is BST?: " + new IsBinarySearchTree().verify(root, Integer.MIN_VALUE, Integer.MAX_VALUE));
    }

    public boolean verify(TreeNode root, int min, int max) {
        if (root == null) return true;

        if (root.data <= min || root.data > max) return false;

        return verify(root.left, min, root.data) && verify(root.right, root.data, max);
    }
}
