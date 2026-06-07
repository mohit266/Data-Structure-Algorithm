package com.dsa.BinaryTree.LeetCodeDailyChallenge;

import com.dsa.BinaryTree.TreeNode;

import java.util.HashMap;

public class CreateBTFromDesc {

    public static void main(String[] args) {
        CreateBTFromDesc obj = new CreateBTFromDesc();

        int[][]  descriptions = {{1,2,1},{2,3,0},{3,4,1}};
        TreeNode root = obj.createBinaryTree(descriptions);

    }

    public TreeNode createBinaryTree(int[][] descriptions) {
        TreeNode root = null;

        HashMap<Integer, TreeNode> childNodes = new HashMap<>();
        HashMap<Integer, TreeNode> rootNodes = new HashMap<>();

        for (int[] desc : descriptions){
            TreeNode node = null;
            TreeNode child = null;
            boolean isChildNode = false;

            if (rootNodes.containsKey(desc[0])){
                node = rootNodes.get(desc[0]);
            } else if (childNodes.containsKey(desc[0])) {
                isChildNode = true;
                node = childNodes.get(desc[0]);
            } else {
                node = new TreeNode(desc[0]);
            }

            if (childNodes.containsKey(desc[1])){
                child = childNodes.get(desc[1]);
            } else if (rootNodes.containsKey(desc[1])) {
                child = rootNodes.get(desc[1]);
                rootNodes.remove(desc[1]);
            } else {
                child = new TreeNode(desc[1]);
            }

            if (desc[2] == 1) {
                node.left = child;
            } else {
                node.right = child;
            }

            childNodes.put(desc[1], child);

            if (!isChildNode) {
                rootNodes.put(desc[0], node);
            }
        }
        root = rootNodes.values().iterator().next();
        return root;
    }
}
