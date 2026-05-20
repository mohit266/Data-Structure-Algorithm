package com.dsa.BinaryTree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class PostOrderTraversal {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);

        List<Integer> ls = new ArrayList<>();
        postOrder(root, ls);

        System.out.println(ls);

        System.out.println(postOrderIterative(root));
    }

    public static void postOrder(TreeNode node, List<Integer> ls){
        if (node == null){
            return;
        }

        postOrder(node.left, ls);
        postOrder(node.right, ls);
        ls.add(node.data);
    }

    public static List<Integer> postOrderIterative(TreeNode root){
        Stack<TreeNode> st = new Stack<>();
        List<Integer> lst = new ArrayList<>();

        st.push(root);

        while (!st.isEmpty()){

            TreeNode node = st.pop();

            lst.add(node.data);

            if (node.left != null) {
                st.push(node.left);
            }

            if (node.right != null) {
                st.push(node.right);
            }
        }
        Collections.reverse(lst);

        return lst;
    }
}
