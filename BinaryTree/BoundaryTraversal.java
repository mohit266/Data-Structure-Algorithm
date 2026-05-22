package com.dsa.BinaryTree;

import com.sun.source.tree.Tree;

import java.util.ArrayList;
import java.util.List;

public class BoundaryTraversal {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.left.right.left = new TreeNode(8);
        root.left.right.right = new TreeNode(9);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        System.out.println(boundary(root));
    }

    public static List<Integer> boundary(TreeNode root) {

        List<Integer> result = new ArrayList<>();

        if (root == null) {
            return result;
        }
        if (!isLeafNode(root)) {
            result.add(root.data);
        }

        addLeftBoundary(root, result);
        addLeafNodes(root, result);
        addRightBoundary(root, result);

        return result;
    }

    public static void addLeftBoundary(TreeNode node, List<Integer> result){
        TreeNode current = node.left;

        while (current != null){
            if (!isLeafNode(current)) {
                result.add(current.data);
            }

            if (current.left != null){
                current = current.left;
            } else {
                current = current.right;
            }

        }
    }

    public static void addRightBoundary(TreeNode node, List<Integer> result){
        TreeNode current = node.right;

        List<Integer> ls = new ArrayList<>();
        while (current != null){
            if (!isLeafNode(current)) {
                ls.add(current.data);
            }
            if (current.right != null){
                current = current.right;
            } else {
                current = current.right;
            }
        }
        for (int i = ls.size(); i > 0; i--){
            result.add(ls.get(i - 1));
        }
    }

    public static void addLeafNodes(TreeNode node, List<Integer> result){
        if (isLeafNode(node)){
            result.add(node.data);
            return;
        }

        if (node.left != null){
            addLeafNodes(node.left, result);
        }

        if (node.right != null){
            addLeafNodes(node.right, result);
        }
    }

    public static boolean isLeafNode(TreeNode node){
        return node.left == null && node.right == null;
    }
}
