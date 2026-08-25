package com.dsa.BinaryTree;

// 129. Sum Root to Leaf Numbers
public class SumRootToLeafNumbers {

    public static void main(String[] args) {
        SumRootToLeafNumbers s = new SumRootToLeafNumbers();

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        System.out.println(s.sumNumbers(root));
    }

    public int sumNumbers(TreeNode root) {
        return traversal(root, 0);
    }

    public int traversal(TreeNode root, int sum){
        if (root == null){
            return 0;
        }

        sum = sum * 10 + root.data;

        if (root.left == null && root.right == null){
            return sum;
        }

        int leftSum = traversal(root.left, sum);
        int rightSum = traversal(root.right, sum);

        return leftSum + rightSum;
    }
}
