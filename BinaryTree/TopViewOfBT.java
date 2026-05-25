package com.dsa.BinaryTree;

import java.util.*;

public class TopViewOfBT {
    private static class Tuple {
        TreeNode node;
        int x;

        Tuple(TreeNode node, int x) {
            this.node = node;
            this.x = x;
        }
    }

    public static void main(String[] args) {
         TreeNode root = new TreeNode(1);
         root.left = new TreeNode(2);
         root.right = new TreeNode(3);
         root.left.left = new TreeNode(4);
         root.left.right = new TreeNode(5);
         root.right.left = new TreeNode(6);
         root.right.right = new TreeNode(7);

        System.out.println(topView(root));
    }

    public static List<Integer> topView(TreeNode root) {

        TreeMap<Integer, Integer> nodesMap = new TreeMap<>();

        Queue<Tuple> queue = new LinkedList<>();

        queue.add(new Tuple(root, 0));

        while (!queue.isEmpty()){
            Tuple tuple = queue.poll();
            TreeNode node = tuple.node;
            int x = tuple.x;

            if (!nodesMap.containsKey(x)){
                nodesMap.putIfAbsent(x,  node.data);
            }

            if (node.left != null) {
                queue.offer(new Tuple(node.left, x - 1));
            }

            if (node.right != null) {
                queue.offer(new Tuple(node.right, x + 1));
            }
        }

        return new ArrayList<>(nodesMap.values());
    }
}
