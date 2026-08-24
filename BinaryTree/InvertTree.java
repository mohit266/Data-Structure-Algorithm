package com.dsa.BinaryTree;

// 226. Invert Binary Tree
public class InvertTree {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        InvertTree in = new InvertTree();
        TreeNode invertedTree = in.invertTree(root);
        System.out.println(invertedTree);
    }


    public TreeNode invertTree(TreeNode root) {
        if (root == null){
            return root;
        }

        TreeNode right = root.right;
        TreeNode left = root.left;

        root.left = right;
        root.right = left;

        invertTree(root.left);
        invertTree(root.right);

        return root;
    }

}
