package com.dsa.BinarySearchTree;

public class DeleteANode {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);
        root.right.right = new TreeNode(7);

        TreeNode nod = deleteNode(root, 5);
        System.out.println();
    }


    public static TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) return null;

        if (root.data == key) {
            return connector(root);
        }

        TreeNode node = root;
        while (node != null) {
            if (node.data > key) {
                if (node.left != null && node.left.data == key) {
                    node.left = connector(node.left);
                    break;
                } else {
                    node = node.left;
                }
            }
            else {
                if (node.right != null && node.right.data == key) {
                    node.right = connector(node.right);
                    break;
                } else {
                    node = node.right;
                }
            }
        }
        return root;
    }

    private static TreeNode connector(TreeNode root) {
        if (root.left == null) return root.right;
        if (root.right == null) return root.left;

        TreeNode leftChild = root.left;
        TreeNode leftmostChildInRightSubtree = root.right;

        while (leftmostChildInRightSubtree.left != null) {
            leftmostChildInRightSubtree = leftmostChildInRightSubtree.left;
        }

        leftmostChildInRightSubtree.left = leftChild;

        return root.right;
    }





}
