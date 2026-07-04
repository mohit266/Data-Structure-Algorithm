package com.dsa.DailyChallenges;

import java.util.*;
import java.util.stream.IntStream;

public class MinimumScoreOfAPathBetweenTwoCities {
    public static void main(String[] args) {
        int n = 4;
        int[][] roads = {{1,2,9},{2,3,6},{2,4,5},{1,4,7}};

        MinimumScoreOfAPathBetweenTwoCities m = new MinimumScoreOfAPathBetweenTwoCities();

        System.out.println(m.minScore(n, roads));

    }

    public int minScore(int n, int[][] roads) {

        List<List<int[]>> adj = new ArrayList<>();

        IntStream.range(0, n + 1).forEach(i-> adj.add(new ArrayList<>()));


        for (int[] road: roads){
            int u = road[0];
            int v = road[1];
            int wt = road[2];

            adj.get(u).add(new int[] {v, wt});
            adj.get(v).add(new int[] {u, wt});
        }

        int[] dist = new int[n+1];
        Arrays.fill(dist, Integer.MAX_VALUE);

        Queue<int[]> q = new LinkedList<>();

        q.offer(new int[] {1, Integer.MAX_VALUE});
        dist[1] = Integer.MAX_VALUE;

        while(!q.isEmpty()){
            int[] cell = q.poll();

            int node = cell[0];
            int minDis = cell[1];

            for (int[] neighbors : adj.get(node)){
                int neiNode = neighbors[0];
                int neiDis = neighbors[1];

                int minDistance = Math.min(neiDis, minDis);

                if (minDistance < dist[neiNode]){
                    dist[neiNode] = minDistance;
                    q.offer(new int[] {neiNode, minDistance});
                }
            }
        }


        return dist[n];

    }


}
