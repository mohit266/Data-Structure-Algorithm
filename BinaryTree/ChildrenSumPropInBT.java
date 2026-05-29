package com.dsa.BinaryTree;

import com.sun.source.tree.Tree;

import java.util.LinkedList;
import java.util.Queue;

public class ChildrenSumPropInBT {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(4);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.right.left = new TreeNode(2);
        root.right.right = new TreeNode(4);

        System.out.println(backTrack(root));

    }

    static boolean backTrack(TreeNode root){
        if (root == null) {
            return true;
        }

        if (root.left == null && root.right == null){
            return true;
        }

        int sum = 0;

        if (root.left != null){
            sum += root.left.data;
        }

        if (root.right != null){
            sum += root.right.data;
        }

        if (root.data != sum){
            return false;
        }

        return backTrack(root.left) && backTrack(root.right);
    }

    static boolean checkChildrenSum(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()){
            TreeNode node = queue.poll();
            int sum = 0;
            if (node.left != null){
                sum += node.left.data;
                queue.add(node.left);
            }

            if (node.right != null){
                sum += node.right.data;
                queue.add(node.right);
            }

            if ((node.data != sum) && (node.left != null || node.right != null)){
                return false;
            }
        }
        return true;
    }
}
