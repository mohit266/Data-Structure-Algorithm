package com.dsa.BinaryTree;

import java.util.ArrayList;
import java.util.List;

public class LCAInBT {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.left.right.left = new TreeNode(6);
        root.left.right.right = new TreeNode(7);
        root.right.left = new TreeNode(8);
        root.right.right = new TreeNode(9);

        TreeNode q = root.left.right.right;
        TreeNode p = root.left.left;
        TreeNode res = lowestCommonAncestor(root, p, q);
        System.out.println(res.data);
    }

    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q){
            return root;
        }

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        if (left == null){
            return right;
        } else if (right == null){
            return left;
        } else {
            return root;
        }
    }

    public static TreeNode lowestCommonAncestorBruteForce(TreeNode root, TreeNode p, TreeNode q) {
        List<TreeNode> pList = traverse(root, p, new ArrayList<>());
        List<TreeNode> qList = traverse(root, q, new ArrayList<>());

        TreeNode result = null;
        int i = 0;
        int j = 0;

        while (i < pList.size() && j < qList.size()){
            if (pList.get(i).data == qList.get(j).data){
                result = pList.get(i);
            }
            i++;
            j++;
        }
        return result;
    }

    public static List<TreeNode> traverse(TreeNode node, TreeNode p,
                                               ArrayList<TreeNode> current) {

        if (node == null) {
            return null;
        }

        current.add(node);

        if (node == p) {
            return new ArrayList<>(current);
        }

        List<TreeNode> left = traverse(node.left, p, current);
        if (left != null) {
            return left;
        }

        List<TreeNode> right = traverse(node.right, p, current);
        if (right != null) {
            return right;
        }

        current.remove(current.size() - 1);

        return null;
    }
}
