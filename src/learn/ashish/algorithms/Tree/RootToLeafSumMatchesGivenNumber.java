package learn.ashish.algorithms.Tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Ashish Sanagar
 */
public class RootToLeafSumMatchesGivenNumber {

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

        List<Integer> result = new ArrayList<>();
        System.out.println("Root To Leaf Sum: " + new RootToLeafSumMatchesGivenNumber().verify(root, 48, result));
        result.forEach(value -> System.out.print(" " + value));
    }

    public boolean verify(TreeNode root, int sum, List<Integer> result) {
        if (root == null) return false;

        if (root.left == null && root.right == null) {
            if (sum == root.data) {
                result.add(root.data);

                return true;
            }
            return false;
        }

        if (verify(root.left, (sum - root.data), result)
                || verify(root.right, (sum - root.data), result)) {
            result.add(root.data);
            return true;
        }

        return false;
    }
}
