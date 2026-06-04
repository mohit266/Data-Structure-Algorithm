package com.dsa.BinarySearchTree;

import java.util.ArrayList;
import java.util.List;

public class InorderSuccessorAndPredecessor {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(2);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(4);
        root.left.right.left = new TreeNode(3);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(9);
        root.right.right.left = new TreeNode(8);
        root.right.right.right = new TreeNode(10);

        InorderSuccessorAndPredecessor in = new InorderSuccessorAndPredecessor();
        System.out.println(in.succPredBST(root, 3));
    }

    public List<Integer> succPredBST(TreeNode root, int key) {

        int predecessor = -1;
        int successor = -1;

        while (root != null){

            if (root.data == key){
                if (root.left != null){
                    TreeNode temp = root.left;
                    while (temp.right != null){
                        temp = temp.right;
                    }
                    predecessor = temp.data;
                }

                if (root.right != null) {
                    TreeNode temp = root.right;
                    while (temp.left != null){
                        temp = temp.left;
                    }
                    successor = temp.data;
                }

                break;

            } else if (root.data < key){
                predecessor = root.data;
                root = root.right;
            } else {
                successor = root.data;
                root = root.left;
            }
        }

        List<Integer> ls = new ArrayList<>();
        ls.add(predecessor);
        ls.add(successor);

        return ls;
    }
}
