package com.dsa.Graphs;

import java.util.*;

public class DetectCycleInUnidirectedGraph {
    public static void main(String[] args) {
        DetectCycleInUnidirectedGraph d = new DetectCycleInUnidirectedGraph();

        int V = 6;

        List<Integer>[] adj = new ArrayList[V];
        for (int i = 0; i < V; i++) {
            adj[i] = new ArrayList<>();
        }
        adj[0].addAll(Arrays.asList(1, 3));
        adj[1].addAll(Arrays.asList(0, 2, 4));
        adj[2].addAll(Arrays.asList(1, 5));
        adj[3].addAll(Arrays.asList(0, 4));
        adj[4].addAll(Arrays.asList(1, 3, 5));
        adj[5].addAll(Arrays.asList(2, 4));

        System.out.println(d.isCycle(V, adj));

    }

    public boolean isCycle(int V, List<Integer>[] adj) {

        boolean[] visited = new boolean[V];

        for (int i = 0; i < V; i++){
            if (!visited[i]){
                boolean res = dfsTraversal(i, -1, visited, adj);
                if (res) {
                    return true;
                }
            }
        }

        return false;
    }

    public boolean bfsTraversal(int V, boolean[] visited, List<Integer>[] adj){
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{V, -1});
        visited[V] = true;

        while (!q.isEmpty()){
            int[] cell = q.poll();
            int node = cell[0];
            int parent = cell[1];

            List<Integer> adjacentNodes = adj[node];
            for (int n : adjacentNodes){
                if (!visited[n]){
                    q.offer(new int[]{n, node});
                    visited[n] = true;
                } else if (parent != n){
                    return true;
                }
            }
        }
        return false;
    }

    public boolean dfsTraversal(int V, int parent, boolean[] visited, List<Integer>[] adj){
        visited[V] = true;
        List<Integer> adjacentNodes = adj[V];

        for (int n : adjacentNodes){
            if (!visited[n]){
                if (dfsTraversal(n, V, visited, adj)) {
                    return true;
                }
            } else if (parent != n){
                return true;
            }
        }
        return false;
    }
}
