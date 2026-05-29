package com.dsa.BinaryTree;

import java.util.Stack;

public class FlattenBTToLL {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.right = new TreeNode(6);

        flatten(root);
        System.out.println();
    }

    public static void flatten(TreeNode root) {
        Stack<TreeNode> st = new Stack<>();

        st.add(root);

        TreeNode temp = root;

        while(!st.isEmpty()){
            TreeNode node = st.pop();

            if (node != root){
                temp.left = null;
                temp.right = node;
                temp = temp.right;
            }

            if (node.right != null){
                st.add(node.right);
            }
            if (node.left != null){
                st.add(node.left);
            }
        }
    }
}
