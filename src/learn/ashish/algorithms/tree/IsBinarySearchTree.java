package learn.ashish.algorithms.tree;

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

        System.out.println(new IsBinarySearchTree().verify(root, null, null));
    }

    public boolean verify(TreeNode root, Integer min, Integer max) {
        if (root == null)
            return true;
        else if ((min != null && root.data <= min) || (max != null && root.data >= max))
            return false;
        else
            return verify(root.left, min, root.data)
                    && verify(root.right, root.data, max);
    }
}
