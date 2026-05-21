package com.dsa.BinaryTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelOrderTraversal {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        System.out.println(levelOrder(root));
    }

    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()){

            List<Integer> ls = new ArrayList<>();

            int size = q.size();

            for (int i = 0; i < size; i++){
                TreeNode node = q.peek();
                q.poll();

                if (node != null){
                    ls.add(node.data);
                }

                if (node !=null && node.left != null){
                    q.add(node.left);
                }

                if (node !=null && node.right != null){
                    q.add(node.right);
                }
            }

            if (!ls.isEmpty()){
                res.add(ls);
            }
        }
        return res;
    }
}
