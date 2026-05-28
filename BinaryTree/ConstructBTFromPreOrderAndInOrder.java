package com.dsa.BinaryTree;

import java.util.HashMap;

public class ConstructBTFromPreOrderAndInOrder {
    public static void main(String[] args) {
        int[] preOrder = {3, 9, 20, 15, 7};
        int[] inOrder = {9, 3, 15, 20, 7};

        TreeNode root = buildTree(preOrder, inOrder);

    }

    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        HashMap<Integer, Integer> inOrderMap = new HashMap<>();

        for (int i = 0; i < inorder.length; i++){
            inOrderMap.put(inorder[i], i);
        }

        TreeNode root = buildTree(preorder,0, preorder.length - 1, 0, inorder.length - 1, inOrderMap);
        return root;
    }

    public static TreeNode buildTree(int[] preOrder, int preStart, int preEnd, int inStart, int inEnd,
                                            HashMap<Integer, Integer> inOrderMap){

        if (preStart > preEnd || inStart > inEnd){
            return null;
        }

        TreeNode node = new TreeNode(preOrder[preStart]);

        int nodeIndexInOrder = inOrderMap.get(node.data);

        int numLeft = nodeIndexInOrder - inStart;

        node.left = buildTree(preOrder, preStart + 1, preStart + numLeft, inStart, nodeIndexInOrder - 1, inOrderMap);
        node.right = buildTree(preOrder, preStart + numLeft + 1, preEnd, nodeIndexInOrder + 1, inEnd, inOrderMap);

        return node;
    }
}
