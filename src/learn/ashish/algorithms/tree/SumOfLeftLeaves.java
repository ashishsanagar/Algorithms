package learn.ashish.algorithms.tree;

/**
 * @author Ashish Sanagar
 */
public class SumOfLeftLeaves {

    public static void main(String[] a) {
        TreeNode root = new TreeNode(12);
        root.left = new TreeNode(10);
        root.right = new TreeNode(13);

        root.right.left = new TreeNode(5);

        System.out.println(new SumOfLeftLeaves().find(root, false));
    }

    public int find(TreeNode root, boolean left) {
        if (root == null) return 0;

        if (root.left == null && root.right == null) {
            if (left)
                return root.data;
            return 0;
        }

        return find(root.left, true) +
                find(root.right, false);
    }
}
