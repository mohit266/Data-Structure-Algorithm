package com.dsa.DailyChallenges;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.stream.IntStream;

public class CountNumberOfCompleteComponents {
    public static void main(String[] args) {
        int n = 6;
        int[] [] edges = {{0,1},{0,2},{1,2},{3,4},{3,5}};

        CountNumberOfCompleteComponents c = new CountNumberOfCompleteComponents();

        System.out.println(c.countCompleteComponents(n,edges));
    }

    public int countCompleteComponents(int n, int[][] edges) {

        List<List<Integer>> adj = new ArrayList<>();

        IntStream.range(0, n).forEach(a-> adj.add(new ArrayList<>()));

        for (int[] edge : edges){
            int u = edge[0];
            int v = edge[1];

            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        boolean[] vis = new boolean[n];

        int totalCount = 0;
        for (int i = 0; i < n; i++){
            if (!vis[i]){
                if (bfs(i, adj, vis) > 0){
                    totalCount++;
                }
            }
        }
        return totalCount;
    }

    public int bfs(int node, List<List<Integer>>adj, boolean[] vis){

        Queue<Integer> q = new LinkedList<>();
        q.offer(node);
        vis[node] = true;

        int nodeCount = 0;
        int edgeCount = 0;

        while (!q.isEmpty()){
            int n = q.poll();
            nodeCount++;
            edgeCount += adj.get(n).size();

            for (int adjNode : adj.get(n)){
                if (!vis[adjNode]){
                    vis[adjNode] = true;
                    q.offer(adjNode);
                }
            }
        }

        edgeCount = edgeCount / 2;

        if (edgeCount == (nodeCount * (nodeCount - 1) / 2)){
            return 1;
        }
        return 0;
    }
}
