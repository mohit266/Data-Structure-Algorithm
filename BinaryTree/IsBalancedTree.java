package com.dsa.BinaryTree;

public class IsBalancedTree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        System.out.println(isBalanced(root));
    }


    public static int calculateLevel(TreeNode node){
        if (node == null){
            return 0;
        }

        int left = calculateLevel(node.left);
        int right = calculateLevel(node.right);

        return 1 + Math.max(left, right);
    }

    static  boolean isBalanced(TreeNode root) {
        if (root == null) return true;

        int leftHeight = calculateLevel(root.left);
        int rightHeight = calculateLevel(root.right);

        if (Math.abs(leftHeight - rightHeight) > 1) return false;

        return isBalanced(root.left) && isBalanced(root.right);
    }

}
