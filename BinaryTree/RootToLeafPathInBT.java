package com.dsa.BinaryTree;

import java.util.ArrayList;
import java.util.List;

public class RootToLeafPathInBT {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        System.out.println(allRootToLeaf(root));
    }

    public static List<List<Integer>> allRootToLeaf(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        traverse(root, new ArrayList<>(), res);
        return res;
    }

    public static void traverse(TreeNode node, List<Integer> current, List<List<Integer>>  result){
        if (node == null){
            return;
        }

        current.add(node.data);

        if (node.left == null && node.right == null){
            result.add(new ArrayList<>(current));
        }

        traverse(node.left, current, result);
        traverse(node.right, current, result);
        current.remove(current.size() - 1);

    }
}
