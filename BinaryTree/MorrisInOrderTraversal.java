package com.dsa.BinaryTree;

import java.util.ArrayList;
import java.util.List;

public class MorrisInOrderTraversal {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);

        List<Integer> ls = getInorder(root);
        System.out.println(ls);
    }

    public static List<Integer> getInorder(TreeNode root) {
        List<Integer> inorder = new ArrayList<>();
        TreeNode cur = root;

        while (cur != null){
            if (cur.left == null){
                inorder.add(cur.data);
                cur = cur.right;
            } else {
                TreeNode prev = cur.left;

                while (prev.right != null && prev.right != cur){
                    prev = prev.right;
                }

                if (prev.right == null){
                    prev.right = cur;
                    cur = cur.left;
                } else {
                    prev.right = null;
                    inorder.add(cur.data);
                    cur = cur.right;
                }
            }
        }
        return inorder;
    }
}
