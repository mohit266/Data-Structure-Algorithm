package com.dsa.BinaryTree;

import com.sun.source.tree.Tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class InOrderTraversal {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);

        List<Integer> ls = new ArrayList<>();
        inOrder(root, ls);

        System.out.println(ls);

        System.out.println(inOrderIterative(root));

    }

    // Recursive Approach.
    public static void inOrder(TreeNode node, List<Integer> ls){
        if (node == null){
            return;
        }

        inOrder(node.left, ls);
        ls.add(node.data);
        inOrder(node.right, ls);
    }

    // Iterative Approach
    public static List<Integer> inOrderIterative(TreeNode root){
        Stack<TreeNode> st = new Stack<>();
        List<Integer> lst = new ArrayList<>();
        TreeNode node = root;

        while (true){
            if (node != null){
                st.push(node);
                node = node.left;
            } else {
                if (st.isEmpty()){
                    break;
                }
                node = st.peek();
                st.pop();
                lst.add(node.data);
                node = node.right;
            }
        }
        return lst;
    }

}
