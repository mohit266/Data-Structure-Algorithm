package com.dsa.BinaryTree;


import java.util.*;

// PreOrder, InOrder and PostOrder in one traversal.
public class TreeTraversal {

    class NodeState {
        TreeNode node;
        int state;

        NodeState(TreeNode node, int state) {
            this.node = node;
            this.state = state;
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        TreeTraversal t = new TreeTraversal();
        System.out.println(t.treeTraversal(root));
    }

    public List<List<Integer>> treeTraversal(TreeNode root) {
        List<Integer> pre = new ArrayList<>();
        List<Integer> in = new ArrayList<>();
        List<Integer> post = new ArrayList<>();

        if (root == null) return Arrays.asList(pre, in, post);

        Stack<NodeState> st = new Stack<>();

        st.push(new NodeState(root, 1));

        while (!st.isEmpty()) {
            NodeState top = st.pop();
            TreeNode node = top.node;
            int state = top.state;

            if (state == 1) {
                pre.add(node.data);
                st.push(new NodeState(node, 2));

                if (node.left != null) {
                    st.push(new NodeState(node.left, 1));
                }
            } else if (state == 2) {
                in.add(node.data);
                st.push(new NodeState(node, 3));

                if (node.right != null) {
                    st.push(new NodeState(node.right, 1));
                }
            } else {
                post.add(node.data);
            }
        }
        return Arrays.asList(in, pre, post);
    }
}
