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

        int[] sum = new int[1];
        new SumOfLeftLeaves().find(root, false, sum);
        System.out.println(sum[0]);
    }

    public void find(TreeNode root, boolean left, int[] sum) {
        if (root == null)
            return;

        if (root.left == null && root.right == null) {
            if (left)
                sum[0] += root.data;
            return;
        }

        find(root.left, true, sum);
        find(root.right, false, sum);
    }
}
