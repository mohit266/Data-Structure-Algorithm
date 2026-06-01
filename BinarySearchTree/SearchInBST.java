package com.dsa.BinarySearchTree;

public class SearchInBST {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);

        TreeNode node = searchBST(root, 2);

        System.out.println(node.data);
    }

    public static TreeNode searchBST(TreeNode root, int val) {
        while (root != null && root.data != val){
            root = val < root.data ? root.left : root.right;
        }
        return root;
    }

    public static TreeNode searchBSTUsingRecursion(TreeNode root, int val) {
        return backTrack(root, val);
    }

    public static TreeNode backTrack(TreeNode root, int val){
        if (root == null){
            return null;
        }

        if (val == root.data){
            return root;
        }

        if (val < root.data) {
            return backTrack(root.left, val);
        }
        return backTrack(root.right, val);
    }
}
