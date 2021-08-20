package learn.ashish.algorithms.tree;

public class BinaryTreeLongestConsecutiveSequence {

    /**
     * Given the root of a binary tree, return the length of the longest consecutive sequence path.
     * <p>
     * The path refers to any sequence of nodes from some starting node to any node in the tree along the parent-child
     * connections. The longest consecutive path needs to be from parent to child (cannot be the reverse).
     * <p>
     * Input: root = [1,null,3,2,4,null,null,null,5]
     * Output: 3
     * Explanation: Longest consecutive sequence path is 3-4-5, so return 3.
     */
    public static void main(String[] args) {
        TreeNode root = new TreeNode(12);
        root.left = new TreeNode(10);
        root.right = new TreeNode(17);
        root.left.left = new TreeNode(11);
        root.left.right = new TreeNode(23);
        root.left.left.right = new TreeNode(12);

        System.out.println(new BinaryTreeLongestConsecutiveSequence().longestConsecutive(root));
    }

    public int longestConsecutive(TreeNode root) {
        int[] max = new int[1];
        recurse(root, 0, 0, max);
        return max[0];
    }

    private void recurse(TreeNode root, int count, int target, int[] max) {
        if (root == null)
            return;
        else if (target == root.data)
            count++;
        else
            count = 1;

        max[0] = Math.max(max[0], count);

        recurse(root.left, count, root.data + 1, max);
        recurse(root.right, count, root.data + 1, max);
    }
}
