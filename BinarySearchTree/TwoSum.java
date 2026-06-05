package com.dsa.BinarySearchTree;

import java.util.HashSet;
import java.util.Iterator;

public class TwoSum {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        root.right = new TreeNode(3);
//        root.right = new TreeNode(6);
//        root.left.left = new TreeNode(2);
//        root.left.right = new TreeNode(4);
//        root.right.right = new TreeNode(7);

        System.out.println(twoSumBST(root, 6));

    }

    public static boolean twoSumBST(TreeNode root, int k) {
        HashSet<Integer> hs = new HashSet<>();

        inOrderTraversal(root, hs);

        for (Integer h : hs) {
            int complement = k - h;

            if (complement != h && hs.contains(complement)) {
                return true;
            }
        }
        return false;
    }

    public static void inOrderTraversal(TreeNode node, HashSet<Integer> res){
        if (node == null){
            return;
        }

        inOrderTraversal(node.left, res);
        res.add(node.data);
        inOrderTraversal(node.right, res);
    }

}
