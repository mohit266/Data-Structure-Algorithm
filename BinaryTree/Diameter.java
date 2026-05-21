package com.dsa.BinaryTree;

public class Diameter {

    public static void main(String[] args) {

    }

    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) return 0;

        int leftSubtree = calculateHeight(root.left);
        int rightSubtree = calculateHeight(root.right);

        int currentDiameter = leftSubtree +  rightSubtree;

        int leftDiameter = diameterOfBinaryTree(root.left);
        int rightDiameter = diameterOfBinaryTree(root.right);

        return Math.max(currentDiameter, Math.max(leftDiameter, rightDiameter));
    }

    public int calculateHeight(TreeNode node){
        if (node == null){
            return 0;
        }
        int left = calculateHeight(node.left);
        int right = calculateHeight(node.right);

        return 1 + Math.max(left, right);
    }
}
