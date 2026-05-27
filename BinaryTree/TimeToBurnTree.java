package com.dsa.BinaryTree;

import java.util.*;

public class TimeToBurnTree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(5);
        root.right.right = new TreeNode(4);

        System.out.println(timeToBurnTree(root, 4));
    }

    public static int timeToBurnTree(TreeNode root, int start) {

        HashMap<TreeNode, TreeNode> parentMap = new HashMap<>();
        parentNodes(root, parentMap);

        TreeNode targetNode = getNodeFromValue(root, start);

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(targetNode);

        Set<TreeNode> visitedNode = new HashSet<>();
        visitedNode.add(targetNode);

        int seconds = 0;

        while (!queue.isEmpty()){
            int size = queue.size();

            for (int i = 0; i < size; i++){
                TreeNode node = queue.poll();

                if (node == null){
                    continue;
                }

                if (node.left != null && !visitedNode.contains(node.left)){
                    visitedNode.add(node.left);
                    queue.add(node.left);
                }

                if (node.right != null && !visitedNode.contains(node.right)){
                    visitedNode.add(node.right);
                    queue.add(node.right);
                }

                if (parentMap.containsKey(node) && !visitedNode.contains(parentMap.get(node))){
                    visitedNode.add(parentMap.get(node));
                    queue.add(parentMap.get(node));
                }
            }
            seconds++;
        }
        return seconds - 1;
    }

    public static TreeNode getNodeFromValue(TreeNode root, int val){
        if (root == null){
            return null;
        }

        if (root.data == val){
            return root;
        }

        TreeNode left = getNodeFromValue(root.left, val);

        if (left != null){
            return left;
        }

        return getNodeFromValue(root.right, val);
    }

    public static void parentNodes(TreeNode root, HashMap<TreeNode, TreeNode> parentMap){
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()){
            int size = queue.size();

            for (int i = 0; i < size; i++){
                TreeNode node = queue.poll();

                if (node == null){
                    continue;
                }

                if(node.left != null){
                    parentMap.put(node.left, node);
                    queue.add(node.left);
                }

                if(node.right != null){
                    parentMap.put(node.right, node);
                    queue.add(node.right);
                }
            }
        }
    }
}
