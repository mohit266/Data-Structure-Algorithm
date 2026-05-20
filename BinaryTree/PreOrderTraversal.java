package com.dsa.BinaryTree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PreOrderTraversal {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);

        List<Integer> ls = new ArrayList<>();
        preOrder(root, ls);

        System.out.println(ls);

        System.out.println(preOrderIterative(root));
    }

    public static void preOrder(TreeNode node, List<Integer> ls){
        if (node == null){
            return;
        }

        ls.add(node.data);
        preOrder(node.left, ls);
        preOrder(node.right, ls);
    }

    public static List<Integer> preOrderIterative(TreeNode root){
        Stack<TreeNode> st = new Stack<>();
        List<Integer> lst = new ArrayList<>();

        st.push(root);

        while (!st.isEmpty()){
            TreeNode node = st.peek();
            st.pop();

            lst.add(node.data);

            if(node.right != null){
                st.push(node.right);
            }

            if (node.left != null){
                st.push(node.left);
            }
        }
        return lst;
    }

}
