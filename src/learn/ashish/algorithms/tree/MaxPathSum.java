package learn.ashish.algorithms.tree;

public class MaxPathSum {
    int max = Integer.MIN_VALUE;

    /**
     * A path in a binary tree is a sequence of nodes where each pair of adjacent nodes in the sequence has an edge
     * connecting them. A node can only appear in the sequence at most once. Note that the path does not need to pass
     * through the root.
     */
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        System.out.println(new MaxPathSum().maxPathSum(root));
    }

    public int maxPathSum(TreeNode root) {
        recurse(root);

        return max;
    }

    private int recurse(TreeNode root) {
        if (root == null)
            return 0;

        int leftSum = Math.max(recurse(root.left), 0);
        int rightSum = Math.max(recurse(root.right), 0);

        max = Math.max(max, leftSum + rightSum + root.data);

        return root.data + Math.max(leftSum, rightSum);
    }
}
