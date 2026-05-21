package com.dsa.BinaryTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class MaxDepth {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.right.right = new TreeNode(6);

        System.out.println(levelCount(root));
    }

    public static int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        return 1 + Math.max(left, right);
    }

    public static int levelCount(TreeNode root) {
        int level = 0;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()){

            int size = q.size();

            for (int i = 0; i < size; i++){
                TreeNode node = q.peek();
                q.poll();

                if (node !=null && node.left != null){
                    q.add(node.left);
                }

                if (node !=null && node.right != null){
                    q.add(node.right);
                }
            }
            level++;
        }
        return level;
    }

}
