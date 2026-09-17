package com.dsa.PatternWise.Tree.BinaryTree;

import com.dsa.BinaryTree.TreeNode;

// 543. Diameter of Binary Tree
public class Diameter {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);


        Diameter d = new Diameter();

        System.out.println(d.diameterOfBinaryT(root));
    }

    public int diameterOfBinaryT(TreeNode root) {
        int[] dia = new int[1];
        height(root, dia);
        return dia[0];
    }

    public int height(TreeNode node, int[] dia){
        if (node == null){
            return 0;
        }
        int left = height(node.left, dia);
        int right = height(node.right, dia);

        dia[0] = Math.max(left + right, dia[0]);

        return 1 + Math.max(left, right);
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
