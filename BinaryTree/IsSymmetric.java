package com.dsa.BinaryTree;

public class IsSymmetric {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(3);

        System.out.println(isSymmetric(root));

    }

    public static boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        return checkSymmetric(root.left, root.right);
    }


    public static boolean checkSymmetric(TreeNode leftNode, TreeNode rightNode) {
        if (leftNode == null || rightNode == null){
            return leftNode == rightNode;
        }

        if (leftNode.data != rightNode.data){
            return false;
        }

        return checkSymmetric(leftNode.left, rightNode.right) && checkSymmetric(leftNode.right, rightNode.left);
    }
}
