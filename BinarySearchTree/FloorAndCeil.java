package com.dsa.BinarySearchTree;

import java.util.Arrays;
import java.util.List;

public class FloorAndCeil {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(8);
        root.left = new TreeNode(4);
        root.right = new TreeNode(12);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(6);
        root.right.left = new TreeNode(10);
        root.right.right = new TreeNode(14);

        System.out.println(floorCeilOfBST(root, 11));
    }

    public static List<Integer> floorCeilOfBST(TreeNode root, int key) {
        int floor = -1;
        int ceil = -1;

        TreeNode currentNode = root;

        // Floor Value
        while (currentNode != null){
            if (currentNode.data == key){
                floor = key;
                break;
            } else if (currentNode.data < key) {
                floor = currentNode.data;
                currentNode = currentNode.right;
            } else {
                currentNode = currentNode.left;
            }
        }

        currentNode = root;

        // Ceil Value
        while (currentNode != null){
            if (currentNode.data == key){
                ceil = key;
                break;
            } else if (currentNode.data > key) {
                ceil = currentNode.data;
                currentNode = currentNode.left;
            } else {
                currentNode = currentNode.right;
            }
        }
        return Arrays.asList(floor, ceil);
    }
}
