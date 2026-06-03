package com.dsa.BinarySearchTree;

public class CheckIfTreeIsBST {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);
        root.right.right = new TreeNode(7);

        CheckIfTreeIsBST obj = new CheckIfTreeIsBST();

        System.out.println(obj.isValidBST(root));
    }

    public boolean isValidBST(TreeNode root) {
        return validate(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean validate(TreeNode node, long min, long max) {
        if (node == null)
            return true;

        if (node.data <= min || node.data >= max)
            return false;

        boolean leftIsValid = validate(node.left, min, node.data);
        boolean rightIsValid = validate(node.right, node.data, max);

        return leftIsValid && rightIsValid;
    }
}
