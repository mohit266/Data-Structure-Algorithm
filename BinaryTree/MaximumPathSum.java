package com.dsa.BinaryTree;

public class MaximumPathSum {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(-3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        System.out.println(maxPathSum(root));
    }

    public static int maxPathSum(TreeNode root) {

        int[] maxi = {Integer.MIN_VALUE};

        findMaxPathSum(root, maxi);

        return maxi[0];
    }


    static int findMaxPathSum(TreeNode root, int[] maxi) {
        if (root == null) {
            return 0;
        }

        int leftMaxPath = Math.max(0, findMaxPathSum(root.left, maxi));
        int rightMaxPath = Math.max(0, findMaxPathSum(root.right, maxi));

        maxi[0] = Math.max(maxi[0], leftMaxPath + rightMaxPath + root.data);

        return Math.max(leftMaxPath, rightMaxPath) + root.data;
    }


}
