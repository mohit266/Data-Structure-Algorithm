package com.dsa.BinaryTree;

import java.util.ArrayList;
import java.util.List;

public class MorrisPreOrderTraversal {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);

        List<Integer> ls = preorder(root);
        System.out.println(ls);
    }

    public static List<Integer> preorder(TreeNode root) {
        List<Integer> preOrderLs = new ArrayList<>();
        TreeNode cur = root;

        while (cur != null){
            if (cur.left == null){
                preOrderLs.add(cur.data);
                cur = cur.right;
            } else {
                TreeNode prev = cur.left;

                while (prev.right != null && prev.right != cur){
                    prev = prev.right;
                }

                if (prev.right == null){
                    prev.right = cur;
                    preOrderLs.add(cur.data);
                    cur = cur.left;
                } else {
                    prev.right = null;
                    cur = cur.right;
                }
            }
        }
        return preOrderLs;
    }
}
