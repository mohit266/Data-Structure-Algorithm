package com.dsa.BinarySearchTree;

public class InsertIntoBST {
    public static void main(String[] args) {
        InsertIntoBST ins = new InsertIntoBST();

        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);

        TreeNode newTree = ins.insertIntoBST(root, 5);
        System.out.println();
    }

    public TreeNode insertIntoBST(TreeNode root, int val) {
        TreeNode currentNode = root;
        TreeNode prev = null;

        while (currentNode != null){
            if (currentNode.data < val){
                prev = currentNode;
                currentNode = currentNode.right;
            } else {
                prev = currentNode;
                currentNode = currentNode.left;
            }
        }

        if (prev != null){
            if (prev.data < val){
                prev.right = new TreeNode(val);
            } else {
                prev.left = new TreeNode(val);
            }
        }
        return root;
    }

    // Using recursion
    private TreeNode solve(TreeNode node, int val) {
        if (node == null) {
            return new TreeNode(val);
        }

        if (val < node.data) {
            node.left = solve(node.left, val);
        } else if (val > node.data) {
            node.right = solve(node.right, val);
        }

        return node;
    }
}
