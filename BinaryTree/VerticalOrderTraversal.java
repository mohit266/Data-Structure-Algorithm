package com.dsa.BinaryTree;

import java.util.*;

public class VerticalOrderTraversal {
    private static class Tuple {
        TreeNode node;
        int x;
        int y;

        Tuple(TreeNode node, int x, int y) {
            this.node = node;
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        System.out.println(verticalTraversal(root));
    }

    public static List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();

        if (root == null) {
            return result;
        }

        TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> nodesMap = new TreeMap<>();

        Queue<Tuple> queue = new LinkedList<>();
        queue.offer(new Tuple(root, 0, 0));

        while (!queue.isEmpty()) {
            Tuple tuple = queue.poll();
            TreeNode node = tuple.node;
            int x = tuple.x;
            int y = tuple.y;

            nodesMap.putIfAbsent(x, new TreeMap<>());
            nodesMap.get(x).putIfAbsent(y, new PriorityQueue<>());
            nodesMap.get(x).get(y).offer(node.data);

            if (node.left != null) {
                queue.offer(new Tuple(node.left, x - 1, y + 1));
            }

            if (node.right != null) {
                queue.offer(new Tuple(node.right, x + 1, y + 1));
            }
        }

        for (TreeMap<Integer, PriorityQueue<Integer>> yMap : nodesMap.values()) {
            List<Integer> column = new ArrayList<>();
            for (PriorityQueue<Integer> nodes : yMap.values()) {
                while (!nodes.isEmpty()) {
                    column.add(nodes.poll());
                }
            }
            result.add(column);
        }

        return result;
    }

}
