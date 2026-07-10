package com.dsa.DailyChallenges;


import java.util.*;

// Giving TLE in LeetCode. Bcz its expecting to solve this question using DP.
public class PathExistenceQueriesInAGraphII {

    public static void main(String[] args) {
        int n = 3;
        int[] nums = {7,4,7};
        int maxDiff = 0;
        int[][] queries = {{2,0},{1,1},{2,1},{2,2}};

        PathExistenceQueriesInAGraphII p = new PathExistenceQueriesInAGraphII();

        System.out.println(Arrays.toString(p.pathExistenceQueries(n, nums, maxDiff, queries)));
    }

    public int[] pathExistenceQueries(int n, int[] nums, int maxDiff, int[][] queries) {

        int[] result = new int[queries.length];

        List<List<int[]>> adj = new ArrayList<>();

        for (int i = 0; i < n; i++){
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < n; i++){
            for (int j = 0; j < n; j++){
                if (i == j){
                    continue;
                }

                int diff = Math.abs(nums[i] - nums[j]);

                if (diff <= maxDiff){
                    adj.get(i).add(new int[] {j, 1});
                }
            }
        }

        for (int i = 0; i < queries.length; i++){
            result[i] = bfs(n, queries[i], adj, maxDiff);
        }

        return result;
    }

    public int bfs(int n, int[] query, List<List<int[]>> adj, int maxDiff){

        boolean[] vis = new boolean[n];

        int u = query[0];
        int v = query[1];

        PriorityQueue<int[]> q = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));

        q.offer(new int[]{0, u});
        vis[u] = true;

        while(!q.isEmpty()){
            int[] cell = q.poll();
            int node = cell[1];
            int wt = cell[0];

            if (node == v){
                return wt;
            }

            for (int [] neighbors : adj.get(node)){
                int adjNode = neighbors[0];
                int adjWt = neighbors[1];

                if (!vis[adjNode] ){
                    vis[adjNode] = true;
                    q.offer(new int[] {adjWt + wt, adjNode});
                }
            }
        }

        return -1;

    }

}
