package com.dsa.BinaryTree;

import java.util.*;

public class BottomVIewOfBT {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(20);
        root.left = new TreeNode(8);
        root.right = new TreeNode(22);
        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(3);
        root.left.right.left = new TreeNode(10);
        root.left.right.right = new TreeNode(14);
        root.right.right = new TreeNode(25);

        System.out.println(bottomView(root));

    }

    private static class Tuple {
        TreeNode node;
        int x;

        Tuple(TreeNode node, int x) {
            this.node = node;
            this.x = x;
        }
    }

    public static List<Integer> bottomView(TreeNode root) {

        TreeMap<Integer, Integer> mp = new TreeMap<>();

        Queue<Tuple> queue = new LinkedList<>();

        queue.add(new Tuple(root, 0));

        while (!queue.isEmpty()){

            Tuple tuple = queue.poll();
            TreeNode node = tuple.node;
            int x= tuple.x;

            mp.put(x, node.data);

            if (node.left != null){
                queue.add(new Tuple(node.left, x-1));
            }


            if (node.right != null){
                queue.add(new Tuple(node.right, x+1));
            }
        }

        List<Integer> ls = new ArrayList<>(mp.values());
        return ls;
    }


}
