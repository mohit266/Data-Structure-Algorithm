package com.dsa.BinaryTree;

import java.util.*;

public class NodesAtKDistance {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(5);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(6);
        root.left.right = new TreeNode(2);
        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(8);
        root.left.right.left = new TreeNode(7);
        root.left.right.right = new TreeNode(4);

        System.out.println(distanceK(root, root.left, 2));

    }

    public static List<Integer> distanceK(TreeNode root, TreeNode target, int k) {

        HashMap<TreeNode, TreeNode> parentMap = new HashMap<>();
        mapParentNode(root, parentMap);

        Set<TreeNode> visitedNode = new HashSet<>();

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(target);

        visitedNode.add(target);

        int currentDistance = 0;

        while(!queue.isEmpty()){
            int size = queue.size();
            if (currentDistance == k) break;

            for (int i = 0; i < size; i++){
                TreeNode node = queue.poll();

                if(node == null){
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
            currentDistance++;
        }

        List<Integer> ls = new ArrayList<>();
        while (!queue.isEmpty()){
            ls.add(queue.poll().data);
        }
        return ls;
    }

    public static void mapParentNode(TreeNode root, HashMap<TreeNode, TreeNode> parentMap){
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while(!queue.isEmpty()){
            int size = queue.size();

            for (int i = 0; i < size; i++){
                TreeNode currentNode = queue.poll();

                if (currentNode == null){
                    continue;
                }

                if (currentNode.left != null){
                    parentMap.put(currentNode.left, currentNode);
                    queue.add(currentNode.left);
                }

                if (currentNode.right != null){
                    parentMap.put(currentNode.right, currentNode);
                    queue.add(currentNode.right);
                }
            }
        }
    }
}
