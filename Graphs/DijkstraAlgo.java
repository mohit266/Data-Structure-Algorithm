package com.dsa.Graphs;

import java.util.*;

public class DijkstraAlgo {
    public static void main(String[] args) {
        int V = 3;
        List<List<Integer>> edges = Arrays.asList(
                List.of(0, 1, 1),
                List.of(0, 2, 6),
                List.of(1, 2, 3)
        );
        int S = 2;

        DijkstraAlgo di = new DijkstraAlgo();

        System.out.println(Arrays.toString(di.dijkstra(V, edges, S)));
    }

    public  int[] dijkstra(int V, List<List<Integer>> edges, int S) {

        List<List<List<Integer>>> adj = new ArrayList<>();
        for(int i = 0; i < V; i++) adj.add(new ArrayList<>());

        for(List<Integer> e : edges) {
            int u = e.get(0);
            int v = e.get(1);
            int wt = e.get(2);

            adj.get(u).add(new ArrayList<>(Arrays.asList(v, wt)));
            adj.get(v).add(new ArrayList<>(Arrays.asList(u, wt)));
        }

        PriorityQueue<int[]> q = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        q.offer(new int[]{0, S});

        int[] dis = new int[V];
        Arrays.fill(dis, (int)1e9);

        dis[S] = 0;

        while (!q.isEmpty()){
            int[] cell = q.poll();

            int distance = cell[0];
            int node = cell[1];

            for (List<Integer> it : adj.get(node)) {
                int adjNode = it.get(0);
                int edgeWt = it.get(1);

                if (distance + edgeWt < dis[adjNode]){
                    dis[adjNode] = distance + edgeWt;
                    q.offer(new int[]{dis[adjNode], adjNode});
                }
            }
        }

        return dis;
    }

    // Using set
    public int[] dijkstra(int V, ArrayList<ArrayList<Integer>> edges, int S) {

        ArrayList<ArrayList<ArrayList<Integer>>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
        for (ArrayList<Integer> e : edges) {
            int u = e.get(0);
            int v = e.get(1);
            int wt = e.get(2);

            adj.get(u).add(new ArrayList<>(Arrays.asList(v, wt)));
            adj.get(v).add(new ArrayList<>(Arrays.asList(u, wt))); // assuming undirected graph
        }

        TreeSet<int[]> set = new TreeSet<>((a, b) -> {
            if (a[0] != b[0]) return Integer.compare(a[0], b[0]); // Compare by distance
            return Integer.compare(a[1], b[1]); // If distances are equal, compare by node
        });

        int[] dist = new int[V];
        Arrays.fill(dist, (int)1e9);

        dist[S] = 0;

        set.add(new int[]{0, S});

        while (!set.isEmpty()) {

            int[] current = set.pollFirst();
            int dis = current[0];
            int node = current[1];

            for (ArrayList<Integer> neighbor : adj.get(node)) {
                int adjNode = neighbor.get(0);
                int edgeWt = neighbor.get(1);

                if (dis + edgeWt < dist[adjNode]) {

                    set.remove(new int[]{dist[adjNode], adjNode});

                    dist[adjNode] = dis + edgeWt;

                    set.add(new int[]{dist[adjNode], adjNode});
                }
            }
        }
        return dist;
    }

}
