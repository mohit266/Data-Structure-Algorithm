package com.dsa.BinaryTree;

import java.util.LinkedList;
import java.util.Queue;

public class MaxWidthOfBT {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(3);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(3);
        root.right.right = new TreeNode(9);

        System.out.println(widthOfBinaryTree(root));
    }

    static class Pair {
        public TreeNode node;
        public Integer value;

        public Pair(TreeNode key, Integer value) {
            this.node = key;
            this.value = value;
        }
    }

    public static int widthOfBinaryTree(TreeNode root) {

        if (root == null) {
            return 0;
        }

        int ans = 0;

        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(root, 0));

        int left  = 0;
        int right = 0;

        while (!queue.isEmpty()){

            int size = queue.size();
            int minIndex = queue.peek().value;

            for (int i = 0; i < size; i++){
                Pair pair = queue.poll();

                TreeNode node = pair.node;
                int currentIndex = pair.value - minIndex;

                if (i == 0){
                    left = currentIndex;
                }

                if (i == size-1){
                    right = currentIndex;
                }

                if (node.left != null){
                    queue.add(new Pair(node.left, (2*currentIndex) + 1));
                }

                if (node.right != null){
                    queue.add(new Pair(node.right, (2*currentIndex) + 2));
                }
            }

            ans = Math.max(ans, right - left + 1);
        }
        return ans;

    }
}
