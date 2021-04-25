package learn.ashish.algorithms.tree;

/**
 * @author Ashish Sanagar
 */
public class DiameterBinaryTree {

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

        DiameterBinaryTree helper = new DiameterBinaryTree();
        System.out.println("Diameter of tree: " + helper.diameter(root));
    }

    private int height(TreeNode root) {
        if (root == null) return 0;

        int leftHeight = height(root.left);
        int rightHeight = height(root.right);

        return 1 + Math.max(leftHeight, rightHeight);
    }

    public int diameter(TreeNode root) {
        if (root == null) return 0;

        int leftHeight = height(root.left);
        int rightHeight = height(root.right);

        int leftDiameter = diameter(root.left);
        int rightDiameter = diameter(root.right);

        return Math.max((leftHeight + rightHeight + 1), Math.max(leftDiameter, rightDiameter));
    }
}
