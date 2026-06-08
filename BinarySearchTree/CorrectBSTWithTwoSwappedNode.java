package com.dsa.BinarySearchTree;

public class CorrectBSTWithTwoSwappedNode {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(8);
        root.left = new TreeNode(7);
        root.right = new TreeNode(15);
        root.left.left = new TreeNode(25);
        root.left.left.left =  new TreeNode(3);

        root.right.left = new TreeNode(10);
        root.right.right = new TreeNode(20);
        root.right.right.right = new TreeNode(5);

        CorrectBSTWithTwoSwappedNode obj = new CorrectBSTWithTwoSwappedNode();
        obj.recoverTree(root);

    }

    private TreeNode first = null, middle = null, last = null, prev = null;

    public void recoverTree(TreeNode root) {
        inorder(root);

        if (first != null && last != null) {
            int temp = first.data;
            first.data = last.data;
            last.data = temp;
        } else if (first != null && middle != null) {
            int temp = first.data;
            first.data = middle.data;
            middle.data = temp;
        }
    }

    private void inorder(TreeNode node) {
        if (node == null) return;

        inorder(node.left);

        if (prev != null && prev.data > node.data) {
            if (first == null) {
                first = prev;
                middle = node;
            } else {
                last = node;
            }
        }

        prev = node;

        inorder(node.right);
    }
}
