package com.dsa.BinaryTree;

public class MaximumPathSum {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(-3);
//        root.left = new TreeNode(9);
//        root.right = new TreeNode(20);
//        root.right.left = new TreeNode(15);
//        root.right.right = new TreeNode(7);

        System.out.println(maxPathSum(root));
    }

    public static int maxPathSum(TreeNode root) {
        if (root == null){
            return Integer.MIN_VALUE;
        }

        int leftSum = calculateSum(root.left);
        int rightSum = calculateSum(root.right);

        int currentSum = root.data + leftSum + rightSum;

        int leftPath = maxPathSum(root.left);
        int rightPath = maxPathSum(root.right);

        return Math.max(currentSum, Math.max(leftPath, rightPath));
    }

    public static int calculateSum(TreeNode node){
        if (node == null){
            return 0;
        }
        return node.data + calculateSum(node.left) + calculateSum(node.right);
    }

    int findMaxPathSum(TreeNode root, int[] maxi) {
        if (root == null) {
            return 0;
        }

        int leftMaxPath = Math.max(0, findMaxPathSum(root.left, maxi));
        int rightMaxPath = Math.max(0, findMaxPathSum(root.right, maxi));

        maxi[0] = Math.max(maxi[0], leftMaxPath + rightMaxPath + root.data);

        return Math.max(leftMaxPath, rightMaxPath) + root.data;
    }

    public int maxPathSum(TreeNode root) {

        int[] maxi = {Integer.MIN_VALUE};

        findMaxPathSum(root, maxi);

        return maxi[0];
    }

}
