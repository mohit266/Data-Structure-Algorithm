package com.dsa.Graphs;

import java.util.Arrays;

public class FindTheCityWIthSmallestNoOfNeighbors {
    public static void main(String[] args) {
        int[][] edges = {
                {0, 1, 3}, {1, 2, 1},
                {1, 3, 4}, {2, 3, 1}
        };
        int N = 4;
        int distanceThreshold = 4;

        FindTheCityWIthSmallestNoOfNeighbors sol = new FindTheCityWIthSmallestNoOfNeighbors();

        System.out.println(sol.findTheCity(N, edges, distanceThreshold));
    }

    public int findTheCity(int n, int[][] edges, int distanceThreshold) {

        int[][] adj = new int[n][n];

        for (int[] arr : adj){
            Arrays.fill(arr, (int)1e9);
        }

        for (int [] edge : edges){
            int u = edge[0];
            int v = edge[1];
            int wt = edge[2];

            adj[u][v] = wt;
            adj[v][u] = wt;
        }

        for (int k = 0; k < n; k++){
            for (int i = 0; i < n; i++){
                for (int j = 0; j < n; j++){
                    adj[i][j] = Math.min(adj[i][j], adj[i][k] + adj[k][j]);
                }
            }
        }

        int minCount = (int)1e9;
        int ans = -1;

        for(int i = 0; i < n; i++) {
            int count = 0;

            for(int j = 0; j < n; j++) {
                if(i != j && adj[i][j] <= distanceThreshold) {
                    count++;
                }
            }
            if(count < minCount) {
                minCount = count;
                ans = i;
            } else if(count == minCount) {
                ans = i;
            }
        }
        return ans;
    }
}
