package com.dsa.Graphs;

import java.util.*;
import java.util.stream.IntStream;

public class NetworkDelayTime {

    public static void main(String[] args) {
        NetworkDelayTime net = new NetworkDelayTime();

        int[][] times = {{2,1,1},{2,3,1},{3,4,1}};
        int n = 4;
        int k = 2;

        System.out.println(net.networkDelayTime(times, n, k));

    }

    public int networkDelayTime(int[][] times, int n, int k) {

        List<List<int[]>> adj = new ArrayList<>();

        IntStream.range(0,n+1).forEach(i-> adj.add(new ArrayList<>()));

        for (int[] arr : times){
            int u = arr[0];
            int v = arr[1];
            int time = arr[2];

            adj.get(u).add(new int[] {v, time});
        }

        int[] dis = new int[n+1];
        Arrays.fill(dis, Integer.MAX_VALUE);

        PriorityQueue<int[]> q = new PriorityQueue<>(Comparator.comparingInt(a-> a[0]));
        q.offer(new int[] {0, k});
        dis[k] = 0;

        while(!q.isEmpty()){
            int[] cell = q.poll();
            int time = cell[0];
            int node = cell[1];

            for (int[] arr : adj.get(node)){
                int adjNode = arr[0];
                int adjTime = arr[1];

                if (adjTime + time < dis[adjNode]){
                    dis[adjNode] = adjTime + time;
                    q.offer(new int[] {dis[adjNode], adjNode});
                }
            }
        }

        int minVal = -1;
        for (int i = 1; i <= n; i++){
            if (dis[i] == Integer.MAX_VALUE){
                return -1;
            }
            minVal = Math.max(minVal, dis[i]);
        }

        return minVal;
    }
}
