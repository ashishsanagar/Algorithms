package learn.ashish.algorithms.tree;

public class BinaryTreeLongestConsecutiveSequence {

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
