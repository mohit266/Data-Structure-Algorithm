package com.dsa.BinaryTree;

import java.util.*;

public class ZigZagOrSpiralTraversal {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(8);
        root.right.right = new TreeNode(5);

        System.out.println(zigzagLevelOrder(root));
    }

    public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();

        if (root == null) return result;

        Queue<TreeNode> q = new LinkedList<>();
        boolean leftToRight = true;

        q.add(root);

        while (!q.isEmpty()){

            int size = q.size();
            List<Integer> ls = new ArrayList<>(Collections.nCopies(size,0));

            for (int i = 0; i < size; i++){
                TreeNode node = q.poll();

                if (node == null){
                    break;
                }

                int index = leftToRight ? i : size - 1 - i;

                ls.set(index, node.data);

                if (node.left != null){
                    q.add(node.left);
                }

                if (node.right != null){
                    q.add(node.right);
                }

            }
            leftToRight = !leftToRight;
            result.add(ls);
        }
        return result;
    }


}
