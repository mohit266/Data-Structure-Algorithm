package com.dsa.BinarySearchTree;

import java.util.Stack;

public class BSTIterator {

    Stack<TreeNode> st;

    public static void main(String[] args) {
        TreeNode root = new TreeNode(7);
        root.left = new TreeNode(3);
        root.right = new TreeNode(15);
        root.right.left = new TreeNode(9);
        root.right.right = new TreeNode(20);


        BSTIterator bstIterator = new BSTIterator(root);
        System.out.println(bstIterator.hasNext());
        System.out.println(bstIterator.next());
    }

    public BSTIterator(TreeNode root) {
        st = new Stack<>();
        pushAll(root);
    }

    public boolean hasNext() {
        return !st.isEmpty();
    }

    public int next() {
        TreeNode node = st.pop();
        pushAll(node.right);
        return node.data;

    }

    private void pushAll(TreeNode node) {
        while (node != null) {
            st.push(node);
            node = node.left;
        }
    }

}
