package com.dsa.BinaryTree;

import com.sun.source.tree.Tree;

import java.util.*;

public class Revision {

    public static class Tuple {
        TreeNode node;
        int x;
        int y;

        Tuple(TreeNode node, int x, int y){
            this.node = node;
            this.x = x;
            this.y = y;
        }
    }

    public List<Integer> majorityElementTwo(int[] nums) {
        int len = nums.length;
        Map<Integer,Integer> mp = new HashMap<>();

        for (int n : nums){
            mp.put(n, mp.getOrDefault(n,0) + 1);
        }

        List<Integer> ls = new ArrayList<>();
        for (Integer key : mp.keySet()){
            if (mp.get(key) > (len/3)){
                ls.add(key);
            }
        }
        return ls;
    }

    public static void main(String[] args) {
        Revision rev = new Revision();

        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

//        System.out.println(rev.verticalTraversal(root));

        int[] arr = {1, 2, 1, 1, 3, 2};
        System.out.println(rev.majorityElementTwo(arr));
    }

    public List<List<Integer>> verticalTraversal(TreeNode root) {

        List<List<Integer>> res = new ArrayList<>();
        Queue<Tuple> q = new LinkedList<>();

        TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> tp = new TreeMap<>();

        q.add(new Tuple(root, 0, 0));

        while (!q.isEmpty()){
            Tuple tuple = q.poll();
            TreeNode node = tuple.node;
            int x = tuple.x;
            int y = tuple.y;

            tp.putIfAbsent(x, new TreeMap<>());
            tp.get(x).putIfAbsent(y, new PriorityQueue<>());
            tp.get(x).get(y).add(node.data);

            if (node.left != null){
                q.add(new Tuple(node.left, x - 1, y + 1));
            }

            if (node.right != null){
                q.add(new Tuple(node.right, x + 1, y + 1));
            }
        }

        for (TreeMap<Integer, PriorityQueue<Integer>> data : tp.values()){
            List<Integer> ls = new ArrayList<>();

            for (PriorityQueue<Integer> pq : data.values()){
                while(!pq.isEmpty()){
                    ls.add(pq.poll());
                }
            }
            res.add(ls);
        }

        return res;
    }

}