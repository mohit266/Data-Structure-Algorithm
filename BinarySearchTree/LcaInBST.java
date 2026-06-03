package com.dsa.BinarySearchTree;

public class LcaInBST {
    public static void main(String[] args) {
        LcaInBST obj = new LcaInBST();

        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);
        root.right.right = new TreeNode(7);

        TreeNode node = obj.lca(root, 2, 4);

        System.out.println(node.data);
    }

    public TreeNode lca(TreeNode root, int p, int q) {
        if (root == null){
            return null;
        }

        int curr = root.data;

        if (curr < p && curr < q){
            return lca(root.right, p, q);
        }

        if (curr > p && curr > q){
            return lca(root.left, p, q);
        }
        return root;
    }
}
