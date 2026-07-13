package com.dsa.Graphs;

import java.util.*;

public class KosarajuAlgo {

    public static void main(String[] args) {

        KosarajuAlgo k = new KosarajuAlgo();

        int V=5;

        List<List<Integer>> adj = List.of(
                List.of(2, 3),
                List.of(0),
                List.of(1),
                List.of(4),
                List.of()
        );

        System.out.println(k.kosaraju(V, adj));

    }

    public int kosaraju(int V, List<List<Integer>> adj) {
        boolean[] vis = new boolean[V];

        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < V; i++) {
            if (!vis[i]) {
                dfs(i, vis, adj, st);
            }
        }

        List<List<Integer>> adjT = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adjT.add(new ArrayList<>());
        }

        for (int i = 0; i < V; i++) {
            vis[i] = false;

            for (int it : adj.get(i)) {
                adjT.get(it).add(i);
            }
        }

        int count = 0;

        while (!st.isEmpty()) {
            int node = st.pop();

            if (!vis[node]) {
                count += 1;
                helperDFS(node, vis, adjT);
            }
        }

        return count;
    }

    private void dfs(int node, boolean[] vis,  List<List<Integer>> adj, Stack<Integer> st) {
        vis[node] = true;

        for (int it : adj.get(node)) {
            if (!vis[it]) {
                dfs(it, vis, adj, st);
            }
        }

        st.push(node);
    }

    private void helperDFS(int node, boolean[] vis, List<List<Integer>> adjT) {
        vis[node] = true;

        for (int it : adjT.get(node)) {
            if (!vis[it]) {
                helperDFS(it, vis, adjT);
            }
        }
    }

}
