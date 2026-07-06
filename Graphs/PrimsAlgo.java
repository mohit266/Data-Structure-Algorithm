package com.dsa.Graphs;

import java.util.*;

public class PrimsAlgo {

    public static void main(String[] args) {

        List<List<List<Integer>>> adj = Arrays.asList(
                Arrays.asList(
                    List.of(1, 5),
                    List.of(2, 15)
                ),
                Arrays.asList(
                    List.of(0, 5),
                    List.of(2, 10)
                ),
                Arrays.asList(
                    List.of(0, 15),
                    List.of(1, 10)
                )
        );

        int v = 3;

        PrimsAlgo p = new PrimsAlgo();

        System.out.println(p.spanningTree(v, adj));
    }

    public int spanningTree(int V, List<List<List<Integer>>> adj) {

        List<int[]> misSpanningTree = new ArrayList<>();

        boolean[] vis = new boolean[V];

        PriorityQueue<int[]> p = new PriorityQueue<>(Comparator.comparingInt(a->a[0]));
        p.offer(new int[]{0,0,-1});

        int sum = 0;

        while(!p.isEmpty()){
            int[] cell = p.poll();
            int weight = cell[0];
            int node = cell[1];
            int parent = cell[2];

            if (vis[node]) continue;

            vis[node] = true;

            sum += weight;

            if (parent != -1){
                misSpanningTree.add(new int[]{parent, node});
            }

            for (List<Integer> edge : adj.get(node)){

                int adjNode = edge.get(0);
                int adjWt = edge.get(1);

                if (!vis[adjNode]){
                    p.offer(new int[] {adjWt, adjNode, node});
                }
            }
        }

        for (int[] arr : misSpanningTree){
            System.out.println(Arrays.toString(arr));
        }

        return sum;
    }


}
