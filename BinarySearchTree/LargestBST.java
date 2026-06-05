package com.dsa.BinarySearchTree;

public class LargestBST {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(4);
        root.left.left = new TreeNode(2);
        root.left.right  = new TreeNode(4);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(2);
        root.right.right = new TreeNode(5);
        root.right.right.left = new TreeNode(4);
        root.right.right.right = new TreeNode(6);

        System.out.println(maxBST(root));

    }

    public static int maxBST(TreeNode root) {
        NodeValue maxSum = largestBSTSubtree(root);
        return maxSum.maxSize;
    }


    private static NodeValue largestBSTSubtree(TreeNode node) {
        if (node == null) {
            return new NodeValue(Integer.MAX_VALUE, Integer.MIN_VALUE, 0);
        }

        NodeValue left = largestBSTSubtree(node.left);
        NodeValue right = largestBSTSubtree(node.right);

        if (left.maxNode < node.data && node.data < right.minNode) {
            return new NodeValue( Math.min(node.data, left.minNode),
                        Math.max(node.data, right.maxNode),
                    left.maxSize + right.maxSize + 1
            );
        }

        return new NodeValue(Integer.MIN_VALUE, Integer.MAX_VALUE, Math.max(left.maxSize, right.maxSize));
    }


}
