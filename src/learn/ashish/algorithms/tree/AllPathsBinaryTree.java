package learn.ashish.algorithms.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Ashish Sanagar
 */
public class AllPathsBinaryTree {

    public static void main(String[] a) {
        TreeNode root = new TreeNode(12);
        root.left = new TreeNode(10);
        root.right = new TreeNode(17);
        root.left.left = new TreeNode(9);
        root.left.right = new TreeNode(23);

        List<String> result = new AllPathsBinaryTree().find(root);
        result.forEach(System.out::println);
    }

    public List<String> find(TreeNode root) {
        List<String> result = new ArrayList<>();

        recurse(root, result, "");
        return result;
    }

    private void recurse(TreeNode root, List<String> result, String curr) {
        if (root == null) return;

        if (root.left == null && root.right == null) {
            curr += root.data;
            result.add(curr);
            return;
        }

        curr += root.data + "->";

        recurse(root.left, result, curr);
        recurse(root.right, result, curr);
    }
}
