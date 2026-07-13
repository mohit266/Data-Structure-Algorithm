package com.dsa.Graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BridgesInGraph {

    public static void main(String[] args) {

        BridgesInGraph b = new BridgesInGraph();

        int V = 4;
        List<List<Integer>> E = Arrays.asList(
                List.of(0,1),
                List.of(1,2),
                List.of(2,0),
                List.of(1,3)
        );

        System.out.println(b.criticalConnections(V, E));

    }

    private int timer = 1;

    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {

        List<Integer>[] adj = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<>();
        }

        for (List<Integer> it : connections) {
            int u = it.get(0), v = it.get(1);
            adj[u].add(v);
            adj[v].add(u);
        }

        boolean[] vis = new boolean[n];

        int[] tin = new int[n];
        int[] low = new int[n];

        List<List<Integer>> bridges = new ArrayList<>();

        dfs(0, -1, vis, adj, tin, low, bridges);

        return bridges;
    }

    private void dfs(int node, int parent, boolean[] vis, List<Integer>[] adj,
                     int[] tin, int[] low, List<List<Integer>> bridges) {

        vis[node] = true;

        tin[node] = low[node] = timer;
        timer++;

        for (int child : adj[node]) {

            if (child == parent) continue;

            if (!vis[child]) {
                dfs(child, node, vis, adj, tin, low, bridges);

                low[node] = Math.min(low[child], low[node]);

                if (low[child] > tin[node]) {
                    bridges.add(Arrays.asList(child, node));
                }
            } else {
                low[node] = Math.min(low[node], tin[child]);
            }
        }
    }



}
