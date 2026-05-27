package com.dsa.BinaryTree;

class CountNodeOfTree {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);

        System.out.println(countNodes(root));

    }

    public static int countNodes(TreeNode root) {

        if (root == null) {
            return 0;
        }

        int lh = findHeightLeft(root);
        int rh = findHeightRight(root);

        if (lh == rh) {
            return (1 << lh) - 1; 
        }

        return 1 + countNodes(root.left) + countNodes(root.right);
    }

    public static int countNodesBruteForce(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int[] count = {0};
        inorder(root, count);
        return count[0];
    }

    private static int findHeightLeft(TreeNode node) {
        int height = 0;
        while (node != null) {
            height++;
            node = node.left;
        }
        return height;
    }
    
    private static int findHeightRight(TreeNode node) {
        int height = 0;
        while (node != null) {
            height++;
            node = node.right;
        }
        return height;
    }



    public static void inorder(TreeNode root, int[] count) {

        if (root == null) {
            return;
        }

        count[0]++;
        inorder(root.left, count);
        inorder(root.right, count);
    }


}