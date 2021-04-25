package learn.ashish.algorithms.tree;

public class MaxPathSumBinaryTree {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(12);
        root.left = new TreeNode(10);
        root.right = new TreeNode(11);

        root.left.left = new TreeNode(18);
        root.left.right = new TreeNode(3);

        root.right.left = new TreeNode(7);
        root.right.right = new TreeNode(17);

        System.out.println(new MaxPathSumBinaryTree().find(root));
    }

    public int find(TreeNode root) {
        if (root == null)
            return 0;

        int left = find(root.left);
        int right = find(root.right);

        return Math.max(left, right) + root.data;
    }
}
