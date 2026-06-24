package com.dsa.Graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class ShortedPathInDAG {
    // DAG -> Directed Acyclic Graph

    public static void main(String[] args) {
        ShortedPathInDAG s = new ShortedPathInDAG();
        int N = 4;
        int M = 2;
        int[][] edge = {{0,1,2},{0,2,1}};

        System.out.println(Arrays.toString(s.shortestPath(N, M, edge)));
    }

    public int[] shortestPath(int N, int M, int[][] edges) {

        List<List<int[]>> adj = new ArrayList<>();

        for (int i = 0; i < N; i++){
            adj.add(new ArrayList<>());
        }

        for (int[] edge : edges){
            adj.get(edge[0]).add(new int[] {edge[1],edge[2]});
        }

        Stack<Integer> st = new Stack<>();
        boolean[] visitedMp = new boolean[N];

        for (int i = 0; i < N; i++){
            if (!visitedMp[i]){
                dfsTopoSort(i, visitedMp, st, adj);
            }
        }

        int[] distance = new int[N];
        Arrays.fill(distance, (int)1e9);

        distance[0] = 0;

        while (!st.isEmpty()){
            int node = st.pop();

            for (int[] arr : adj.get(node)){
                // arr[0] --> Adjacent node, arr[1] --> Weight of node.
                int adjacentNode = arr[0];
                int weight = arr[1];
                if (distance[node] != 1e9 && distance[node] + weight < distance[adjacentNode]){
                    distance[adjacentNode] = distance[node] + weight;
                }
            }
        }

        for (int i = 0; i < N; i++) {
            if (distance[i] == (int)1e9)
                distance[i] = -1;
        }

        // Return the result
        return distance;
    }

    public void dfsTopoSort(int node, boolean[] visitedMp, Stack<Integer> st, List<List<int[]>> adj){
        visitedMp[node] = true;

        for (int[] arr : adj.get(node)){
            int vertex = arr[0];
            if (!visitedMp[vertex]){
                dfsTopoSort(vertex, visitedMp, st,adj);
            }
        }
        st.add(node);
    }

}
