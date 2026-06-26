package com.dsa.Graphs;

import java.util.*;

public class PrintShortestPath {
    public static void main(String[] args) {
        int n = 5;
        int m= 6;
        int[][] edges = {{1,2,2}, {2,5,5}, {2,3,4}, {1,4,1},{4,3,3},{3,5,1}};

        PrintShortestPath p = new PrintShortestPath();

        System.out.println(p.shortestPath(n, m ,edges));
    }

    public List<Integer> shortestPath(int n, int m, int[][] edges) {

        List<List<int[]>> adj = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int [] edge : edges){
            int u = edge[0];
            int v = edge[1];
            int wt = edge[2];

            adj.get(u).add(new int[]{v, wt});
            adj.get(v).add(new int[]{u, wt});
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a-> a[0]));
        pq.offer(new int[]{0, 1});

        int[] dis = new int[n+1];
        Arrays.fill(dis, Integer.MAX_VALUE);

        dis[1] = 0;

        int[] parent = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            parent[i] = i;
        }

        while (!pq.isEmpty()){
            int[] cell = pq.poll();
            int adjNode = cell[1];
            int distance = cell[0];

            for (int[] nodeLs : adj.get(adjNode)){
                int node = nodeLs[0];
                int wt = nodeLs[1];

                if (distance + wt < dis[node]){
                    dis[node] = distance + wt;
                    pq.offer(new int[] {dis[node], node});
                    parent[node] = adjNode;
                }
            }
        }


        if (dis[n] == Integer.MAX_VALUE) {
            return List.of(-1);
        }

        List<Integer> path = new ArrayList<>();
        int node = n;

        while (parent[node] != node) {
            path.add(node);
            node = parent[node];
        }

        path.add(1);

        Collections.reverse(path);
        path.add(0, dis[n]);

        return path;
    }
}
