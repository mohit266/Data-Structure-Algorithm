package com.dsa.BinarySearchTree;

import com.sun.source.tree.Tree;

import java.util.List;
import java.util.Stack;

public class CreateBtFromPreOrder {

    public static void main(String[] args) {

        int[] arr = {1, 3};

        CreateBtFromPreOrder createBtFromPreOrder = new CreateBtFromPreOrder();
        TreeNode root = createBtFromPreOrder.bstFromPreorder(arr);
        System.out.println();
    }

    // Optimal
    public TreeNode bstFromPreorder(List<Integer> preorder) {
        return bstFromPreorderHelper(preorder, Integer.MAX_VALUE, new int[]{0});
    }

    private TreeNode bstFromPreorderHelper(List<Integer> preorder, int bound, int[] index) {
        if (index[0] == preorder.size() || preorder.get(index[0]) > bound) return null;

        TreeNode root = new TreeNode(preorder.get(index[0]++));

        root.left = bstFromPreorderHelper(preorder, root.data, index);

        root.right = bstFromPreorderHelper(preorder, bound, index);
        return root;
    }

    // Brute force
    public TreeNode bstFromPreorder(int[] preorder) {

        Stack<TreeNode> st = new Stack<>();

        TreeNode root = new TreeNode(preorder[0]);
        st.add(root);

        for (int n : preorder){
            if (n < st.peek().data){
                TreeNode top = st.peek();
                top.left = new TreeNode(n);
                st.add(top.left);
            } else {
                TreeNode prev = null;

                while (!st.isEmpty() && st.peek().data < n){
                    prev = st.pop();
                }

                if (prev != null){
                    prev.right = new TreeNode(n);
                    st.add(prev.right);
                }

            }
        }
        return root;
    }

}
