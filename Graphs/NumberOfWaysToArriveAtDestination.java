package com.dsa.Graphs;

import java.util.*;
import java.util.stream.IntStream;

public class NumberOfWaysToArriveAtDestination {

    public static void main(String[] args) {
        NumberOfWaysToArriveAtDestination n = new NumberOfWaysToArriveAtDestination();

        int[][] roads= {{0,6,7},{0,1,2},{1,2,3},{1,3,3},{6,3,3},{3,5,1},{6,5,1},{2,5,1},{0,4,5},{4,6,2}};
        int m = 7;

        System.out.println(n.countPaths(m, roads));
    }

    public int countPaths(int n, int[][] roads) {
        int mod = 1000000007;
        List<List<int[]>> adj = new ArrayList<>();

        IntStream.range(0, n).forEach(i -> adj.add(new ArrayList<>()));

        for (int[] road : roads){
            int u = road[0];
            int v = road[1];
            int time = road[2];

            adj.get(u).add(new int[] {v, time});
            adj.get(v).add(new int[] {u, time});
        }

        PriorityQueue<long[]> pq = new PriorityQueue<>(Comparator.comparingLong(a -> a[0]));

        long[] dis = new long[n];
        Arrays.fill(dis, Long.MAX_VALUE);

        int[] ways = new int[n];

        pq.add(new long[]{0, 0});
        dis[0] = 0;
        ways[0] = 1;


        while (!pq.isEmpty()){

            long[] cell = pq.poll();

            long time = cell[0];
            int node = (int) cell[1];

            for (int[] num : adj.get(node)){
                int adjNode = num[0];
                int adjTime = num[1];

                if (time + adjTime < dis[adjNode]) {
                    dis[adjNode] = time + adjTime;

                    ways[adjNode] = ways[node];
                    pq.add(new long[]{dis[adjNode], adjNode});
                }
                else if (dis[adjNode] == time + adjTime) {
                    ways[adjNode] = (ways[adjNode] + ways[node]) % mod;
                }
            }
        }

        return ways[n - 1] % mod;

    }
}
