package learn.ashish.algorithms.tree;

public class AddOneRow {

    /**
     * Given the root of a binary tree and two integers val and depth, add a row of nodes with value val at the given depth depth.
     * <p>
     * Note that the root node is at depth 1.
     * <p>
     * The adding rule is:
     * <p>
     * Given the integer depth, for each not null tree node cur at the depth depth - 1, create two tree nodes with value val as cur's left subtree root and right subtree root.
     * cur's original left subtree should be the left subtree of the new left subtree root.
     * cur's original right subtree should be the right subtree of the new right subtree root.
     * If depth == 1 that means there is no depth depth - 1 at all, then create a tree node with value val as the new root of the whole original tree, and the original tree is the new root's left subtree.
     */
    public static void main(String[] args) {
        TreeNode root = new TreeNode(12);
        root.left = new TreeNode(10);
        root.right = new TreeNode(17);
        root.left.left = new TreeNode(9);
        root.left.right = new TreeNode(23);

        new AddOneRow().addOneRow(root, 10, 2);
    }

    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        if (root == null)
            return root;

        if (depth == 1) {
            TreeNode curr = new TreeNode(val);
            curr.left = root;
            return curr;
        }

        if (depth == 2) {
            TreeNode left = new TreeNode(val);
            TreeNode right = new TreeNode(val);

            left.left = root.left;
            right.right = root.right;

            root.left = left;
            root.right = right;

            return root;
        }

        addOneRow(root.left, val, depth - 1);
        addOneRow(root.right, val, depth - 1);

        return root;
    }
}
