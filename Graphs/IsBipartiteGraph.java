package com.dsa.Graphs;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class IsBipartiteGraph {
    public static void main(String[] args) {
        IsBipartiteGraph bipartite = new IsBipartiteGraph();

        int[][] graph = {{1,2,3},{0,2},{0,1,3},{0,2}};
        System.out.println(bipartite.isBipartite(graph));
    }

    public boolean isBipartite(int[][] graph) {
        int V = graph.length;

        int[] color = new int[V];
        Arrays.fill(color, -1);

        for (int i = 0; i < V; i++){
            if (color[i] == -1){
                boolean res = dfsTraversal(i, 0, color, graph);
                if (!res){
                    return false;
                }
            }
        }
        return true;

    }

    public boolean bfsTraversal(int V, int[] color, int[][] grid){
        Queue<Integer> q = new LinkedList<>();
        q.offer(V);
        color[V] = 0;

        while(!q.isEmpty()){
            int node = q.poll();
            int prevColor = color[node];

            int[] adjacentNode = grid[node];

            for (int n : adjacentNode){
                if (color[n] == -1){
                    q.offer(n);
                    color[n] = 1 - prevColor;
                } else if (color[n] == prevColor){
                    return false;
                }
            }
        }
        return true;
    }

    public boolean dfsTraversal(int node, int col, int[] color, int[][] grid){
        color[node] = col;
        int[] adjacentNode = grid[node];

        for (int n : adjacentNode){
            if (color[n] == -1){
                if (!dfsTraversal(n, 1 - col, color, grid)){
                    return false;
                }
            } else if (color[n] == col){
                return false;
            }
        }
        return true;
    }
}
