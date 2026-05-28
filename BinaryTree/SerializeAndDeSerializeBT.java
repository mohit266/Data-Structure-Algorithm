package com.dsa.BinaryTree;

import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;

public class SerializeAndDeSerializeBT {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(5);

        String s = serialize(root);

        TreeNode node = deserialize(s);

        System.out.println();
    }

    public static String serialize(TreeNode root) {
        if (root == null) return "";
        Queue<TreeNode> queue = new LinkedList<>();

        queue.add(root);

        StringBuilder str = new StringBuilder();

        while(!queue.isEmpty()){
            TreeNode node = queue.poll();

            if (node == null) {
                str.append("#,");
            } else {
                str.append(node.data).append(",");
                queue.add(node.left);
                queue.add(node.right);
            }
        }

        return String.valueOf(str);

    }


    public static TreeNode deserialize(String data) {
        if(data.isEmpty()) return null;
        String[] values = data.split(" ");

        Queue<TreeNode> queue = new LinkedList<>();

        TreeNode root = new TreeNode(Integer.parseInt(values[0]));
        queue.add(root);

        for (int i = 1; i < values.length; i++){
            TreeNode node = queue.poll();

            if (!values[i].equals("#")){
                TreeNode left = new TreeNode(Integer.parseInt(values[i]));
                node.left = left;
                queue.add(left);
            }
            if (!values[++i].equals("#")){
                TreeNode right = new TreeNode(Integer.parseInt(values[i]));
                node.right = right;
                queue.add(right);
            }
        }
        return root;
    }

}
