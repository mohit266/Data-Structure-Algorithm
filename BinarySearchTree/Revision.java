package com.dsa.BinarySearchTree;

import java.util.ArrayList;
import java.util.List;

public class Revision {
    public static void main(String[] args) {

        Revision r = new Revision();

        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(2);
        root.left.left.left = new TreeNode(1);


        System.out.println(r.kLargesSmall(root, 3));
    }


    public  List<Integer> kLargesSmall(TreeNode root, int k) {
        List<Integer> ls = new ArrayList<>();

        int[] arr = new int[2];

        arr[0] = Integer.MIN_VALUE;
        arr[1] = k;

        kSmallest(root, arr);
        ls.add(arr[0]);

        arr[0] = Integer.MAX_VALUE;
        arr[1] = k;

        kLargest(root, arr);
        ls.add(arr[0]);

        return ls;

    }

    public void kSmallest(TreeNode root, int[] arr){
        if (root == null){
            return;
        }
        kSmallest(root.left, arr);
        if (arr[0] < root.data && arr[1] >= 1){
            arr[0] = root.data;
            arr[1]--;
        }
        kSmallest(root.right, arr);
    }

    public void kLargest(TreeNode root, int[] arr){

        if (root == null){
            return;
        }

        kLargest(root.right, arr);
        if (arr[0] > root.data && arr[1] >= 1){
            arr[0] = root.data;
            arr[1]--;
        }
        kLargest(root.left, arr);
    }
}
