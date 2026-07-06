package com.dsa.Graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class KruskalAlgo {

    public static void main(String[] args) {
        List<List<List<Integer>>> adj = Arrays.asList(
                Arrays.asList(
                        List.of(1, 1),
                        List.of(3, 4)
                ),
                Arrays.asList(
                        List.of(0, 1),
                        List.of(2, 2)
                ),
                Arrays.asList(
                        List.of(1, 2),
                        List.of(3, 3)
                ),
                Arrays.asList(
                        List.of(0, 4),
                        List.of(2, 3)
                )
        );

        int v = 4;

        KruskalAlgo k = new KruskalAlgo();

        System.out.println(k.spanningTree(v, adj));

    }

    public int spanningTree(int V, List<List<List<Integer>>> adj) {
        List<int[]> edges = new ArrayList<>();

        for (int i = 0; i < V; i++) {
            for (List<Integer> it : adj.get(i)) {
                int v = it.get(0);
                int wt = it.get(1);
                int u = i;
                edges.add(new int[]{wt, u, v});
            }
        }

        DisjointSet ds = new DisjointSet(V);

        edges.sort(Comparator.comparingInt(a -> a[0]));

        int sum = 0;

        for (int[] it : edges) {
            int wt = it[0];
            int u = it[1];
            int v = it[2];

            if (ds.findParent(u) != ds.findParent(v)) {
                sum += wt;
                ds.unionBySize(u, v);
            }
        }
        return sum;
    }
}
