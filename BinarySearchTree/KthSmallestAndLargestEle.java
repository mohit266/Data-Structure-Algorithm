package com.dsa.BinarySearchTree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class KthSmallestAndLargestEle {

    public static void main(String[] args) {
        KthSmallestAndLargestEle obj = new KthSmallestAndLargestEle();

        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(1);
        root.right = new TreeNode(4);
        root.left.right = new TreeNode(2);

        System.out.println(obj.kthSmallest(root, 2));

    }

    public int kthSmallest(TreeNode root, int k) {
        if (root == null){
            return -1;
        }

        List<Integer> inOrderRes = getInOrderPath(root);

        return inOrderRes.get(k-1);

    }

    public List<Integer> getInOrderPath(TreeNode node){
        List<Integer> ls = new ArrayList<>();
        Stack<TreeNode> st = new Stack<>();

        while(true){
            if (node != null){
                st.push(node);
                node = node.left;
            } else {
                if (st.isEmpty()){
                    break;
                }
                node = st.pop();
                ls.add(node.data);
                node = node.right;
            }
        }
        return ls;
    }
}
