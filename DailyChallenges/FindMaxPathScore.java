package com.dsa.DailyChallenges;

import java.util.*;
import java.util.stream.IntStream;

public class FindMaxPathScore {

    public static void main(String[] args) {
        FindMaxPathScore f = new FindMaxPathScore();
        int[][] edges = {{0,2,70},{1,2,27},{0,1,32}};
        boolean[] online = {true,true,true};
        int k = 118;

        System.out.println(f.findMaxPathScore(edges, online, k));
    }

    public int findMaxPathScore(int[][] edges, boolean[] online, long k) {
        int n = online.length;

        List<List<int[]>> adj = new ArrayList<>();

        IntStream.range(0, n).forEach(i -> adj.add(new ArrayList<>()));

        int low = 0;
        int high = 0;

        for (int[] edge : edges){
            int u = edge[0];
            int v = edge[1];
            int wt = edge[2];

            high = Math.max(high, wt);
            adj.get(u).add(new int[] {v, wt});
        }

        if (!online[0] || !online[n - 1])
            return -1;

        int ans = -1;
        while (low <= high){
            int mid = (low+high)/2;

            if (check(online, adj, k, mid)){
                ans = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return ans;
    }

    public boolean check(boolean[] online, List<List<int[]>> adj, long k, int minEdge){
        int n = online.length;

        long[] dist = new long[n];
        Arrays.fill(dist, Long.MAX_VALUE);

        PriorityQueue<long[]> q = new PriorityQueue<>(Comparator.comparingLong(a-> a[0]));

        dist[0] = 0;
        q.offer(new long[]{0, 0});

        while (!q.isEmpty()){
            long[] cell = q.poll();
            long distance = cell[0];
            int node = (int) cell[1];

            if (distance > dist[node]) {
                continue;
            }

            if (node == n - 1){
                return distance <= k;
            }

            for (int[] neighbors : adj.get(node)){
                int neighborNode = neighbors[0];
                int neighborDistance = neighbors[1];

                if (!online[neighborNode]){
                    continue;
                }

                if (neighborDistance < minEdge)
                    continue;

                long totalDis = neighborDistance + distance;

                if (totalDis < dist[neighborNode]){
                    dist[neighborNode] = totalDis;
                    q.offer(new long[] {dist[neighborNode], neighborNode});
                }
            }
        }
        return false;
    }

}
