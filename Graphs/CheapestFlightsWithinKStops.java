package com.dsa.Graphs;

import java.util.*;
import java.util.stream.IntStream;

public class CheapestFlightsWithinKStops {

    public static void main(String[] args) {

        CheapestFlightsWithinKStops c = new CheapestFlightsWithinKStops();

        int[][] flights = {{0,1,100},{1,2,100},{2,0,100},{1,3,600},{2,3,200}};
        int n = 4;
        int src = 0;
        int dst = 3;
        int k = 1;

        System.out.println(c.CheapestFlight(n, flights, src, dst, k));
    }

    public int CheapestFlight(int n, int[][] flights, int src, int dst, int K) {


        List<List<int[]>> adj = new ArrayList<>();

        for (int i = 0; i < n; i++){
            adj.add(new ArrayList<>());
        }
        IntStream.range(0, n)
                .forEach(i -> adj.add(new ArrayList<>()));

        for (int[] arr : flights){
            int u = arr[0];
            int v = arr[1];
            int fare = arr[2];

            adj.get(u).add(new int[] {v, fare});
        }


        PriorityQueue<int[]> pq = new PriorityQueue<>(
                Comparator.comparingInt((int[] a) -> a[0])
                        .thenComparingInt(a -> a[1])
        );

        pq.add(new int[] {0, 0, src});

        int[] fares = new int[n];
        Arrays.fill(fares, Integer.MAX_VALUE);
        fares[src] = 0;

        while (!pq.isEmpty()){
            int[] cell = pq.poll();

            int steps = cell[0];
            int fare = cell[1];
            int node = cell[2];

            if (node == dst){
                return fare;
            }

            for (int[] arr : adj.get(node)){
                int adjNode = arr[0];
                int adjFare = arr[1];

                if (fare + adjFare < fares[adjNode] && steps <= K){
                    fares[adjNode] = fare + adjFare;
                    pq.offer(new int[]{steps + 1, fare + adjFare, adjNode});
                }
            }
        }

        return -1;
    }

}
