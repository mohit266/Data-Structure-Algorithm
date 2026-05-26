package com.dsa.BinaryTree;

import java.util.*;

public class LeftViewOfBT {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.right.right = new TreeNode(4);
        root.left.right = new TreeNode(5);

        System.out.println(getLeftViewIterativeApproach(root));
        System.out.println(leftSideView(root));
    }

    public static List<Integer> leftSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        treeTraversal(root, 0, result);
        return result;
    }

    public static void treeTraversal(TreeNode node, int level, List<Integer> result){
        if (node == null){
            return;
        }

        if (level == result.size()){
            result.add(node.data);
        }

        treeTraversal(node.left, level+1, result);
        treeTraversal(node.right, level+1, result);
    }

    public static List<Integer> getLeftViewIterativeApproach(TreeNode root){

        HashMap<Integer, Integer> mp = new HashMap<>();

        int level = 0;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()){
            int size = queue.size();

            for (int i = 0; i < size; i++){
                TreeNode node = queue.poll();

                if(node == null){
                    continue;
                }
                mp.put(level, node.data);

                if (node.right != null){
                    queue.add(node.right);
                }

                if (node.left != null){
                    queue.add(node.left);
                }
            }
            level++;
        }
        return new ArrayList<>(mp.values());
    }
}
