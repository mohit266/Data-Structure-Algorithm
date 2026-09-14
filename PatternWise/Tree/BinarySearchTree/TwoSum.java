package com.dsa.PatternWise.Tree.BinarySearchTree;

import com.dsa.BinarySearchTree.TreeNode;
import com.sun.source.tree.Tree;

import java.util.HashSet;
import java.util.Stack;

// 653. Two Sum IV - Input is a BST
public class TwoSum {

    public Stack<TreeNode> asc = new Stack<>();
    public Stack<TreeNode> desc = new Stack<>();

    public static void main(String[] args) {

        TwoSum ts = new TwoSum();

        TreeNode root = new TreeNode(5);

        root.left = new TreeNode(3);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);
        root.right.right = new TreeNode(7);

        System.out.println(twoSumBST(root, 9));
        System.out.println(ts.findTarget(root, 9));

    }

    public int getSmall(){
        TreeNode small = asc.pop();

        TreeNode right = small.right;

        while (right != null){
            asc.push(right);
            right = right.left;
        }

        return small.data;
    }

    public int getGreater(){
        TreeNode greater = desc.pop();

        TreeNode left = greater.left;

        while (left != null){
            desc.push(left);
            left = left.right;
        }

        return greater.data;
    }

    public boolean findTarget(TreeNode root, int k) {

        TreeNode node = root;

        while (node != null){
            asc.push(node);
            node = node.left;
        }

        node = root;

        while (node != null){
            desc.push(node);
            node = node.right;
        }

        int s = getSmall();
        int g = getGreater();

        while (s < g){
            if (s + g == k){
                return true;
            } else if (s + g < k){
                s = getSmall();
            } else {
                g = getGreater();
            }
        }

        return false;

    }

    // Brute force
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
