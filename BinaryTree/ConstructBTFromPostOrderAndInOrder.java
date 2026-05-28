package com.dsa.BinaryTree;

import java.util.HashMap;
import java.util.Map;

public class ConstructBTFromPostOrderAndInOrder {

    public static void main(String[] args) {
        int[] postOrder = {9, 15, 7, 20, 3};
        int[] inOrder = {9, 3, 15, 20, 7};

    }

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        Map<Integer, Integer> inOrderMap = new HashMap<>();

        for (int i = 0; i < inorder.length; i++){
            inOrderMap.put(inorder[i], i);
        }

        TreeNode root = buildTree(postorder, 0, postorder.length - 1, 0, inorder.length - 1, inOrderMap);

        return root;
    }

    public TreeNode buildTree(int[] postOrder, int postStart, int postEnd, int inStart, int inEnd, Map<Integer,Integer> inOrderMap){
        if (postStart > postEnd || inStart > inEnd){
            return null;
        }
        TreeNode node = new TreeNode(postOrder[postEnd]);

        int indexOfRoot = inOrderMap.get(node.data);
        int numLeft = indexOfRoot - inStart;

        node.left = buildTree(postOrder, postStart, postStart + numLeft - 1, inStart, indexOfRoot - 1, inOrderMap);
        node.right = buildTree(postOrder, postStart + numLeft, postEnd - 1, indexOfRoot + 1, inEnd, inOrderMap);
        return node;
    }
}
