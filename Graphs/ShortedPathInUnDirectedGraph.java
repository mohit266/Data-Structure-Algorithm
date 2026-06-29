package com.dsa.Graphs;

import java.util.*;

public class ShortedPathInUnDirectedGraph {
    public static void main(String[] args) {

        ShortedPathInUnDirectedGraph s = new ShortedPathInUnDirectedGraph();

        int n = 9;
        int m = 10;
        int[] [] edges = {{0,1},{0,3},{3,4},{4,5},{5, 6},{1,2},{2,6},{6,7},{7,8},{6,8}};

        System.out.println(Arrays.toString(s.shortestPath(edges, n, m)));
    }

    public int[] shortestPath(int[][] edges, int N, int M) {

        List<List<int[]>> adj = new ArrayList<>();

        for (int i = 0; i < N; i++){
            adj.add(new ArrayList<>());
        }

        for (int[] edge : edges){
            adj.get(edge[0]).add(new int[]{edge[1], 1});
        }

        boolean[] visitedMp = new boolean[N];

        Queue<Integer> q = new LinkedList<>();
        q.offer(0);
        visitedMp[0] = true;

        int[] distance = new int[N];
        Arrays.fill(distance, (int) 1e9);
        distance[0] = 0;

        while (!q.isEmpty()){
            int u = q.poll();

            for (int[] arr : adj.get(u)){
                int v = arr[0];
                int wt = arr[1];

                if (!visitedMp[v]){
                    if (distance[u] != 1e9 && distance[u] + wt  < distance[v]){
                        distance[v] = distance[u] + wt;
                        visitedMp[v] = true;
                        q.offer(v);
                    }
                }
            }
        }

        for (int i = 0; i < N; i++){
            if(distance[i] == 1e9){
                distance[i] = -1;
            }
        }
        return distance;
    }
}
