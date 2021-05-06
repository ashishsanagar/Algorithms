package learn.ashish.algorithms.tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Ashish Sanagar
 */
public class LevelOrderTraversalLevelByLevelPrint {

    public static void main(String[] a) {
        BinaryTree tree = new BinaryTree();
        TreeNode root = new TreeNode(12);

        tree.insertNode(root, 10);
        tree.insertNode(root, 14);
        tree.insertNode(root, 13);
        tree.insertNode(root, 2);
        tree.insertNode(root, 0);
        tree.insertNode(root, 17);
        tree.insertNode(root, 6);
        tree.insertNode(root, 36);
        tree.insertNode(root, 15);

        new LevelOrderTraversalLevelByLevelPrint().traverse(root);
    }

    public void traverse(TreeNode root) {
        if (root == null) return;

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {
            int size = q.size(); // size is equal to nodes at a level

            for (int i = 0; i < size; i++) {
                TreeNode node = q.poll();

                System.out.print(node.data + " ");

                if (node.left != null)
                    q.add(node.left);
                if (node.right != null)
                    q.add(node.right);
            }

            System.out.println();
        }
    }
}
