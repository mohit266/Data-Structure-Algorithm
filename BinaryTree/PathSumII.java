package com.dsa.BinaryTree;

import java.util.ArrayList;
import java.util.List;

// 113. Path Sum II
public class PathSumII {

    public static void main(String[] args) {

    }

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> rs = new ArrayList<>();
        traversal(root, targetSum, new ArrayList<>(), rs);
        return rs;
    }

    public void traversal(TreeNode root, int targetSum, List<Integer> ls, List<List<Integer>> rs){
        if (root == null){
            return;
        }

        ls.add(root.data);
        targetSum = targetSum - root.data;

        if (root.left == null && root.right == null){
            if (targetSum == 0){
                rs.add(new ArrayList<>(ls));
            }
            ls.remove(ls.size() - 1);
            return;

        }

        traversal(root.left, targetSum, ls ,rs);
        traversal(root.right, targetSum, ls ,rs);
        ls.remove(ls.size() - 1);

    }
}
