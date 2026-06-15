package com.dsa.Graphs;

import java.util.*;

public class BFSTraversal {
    public static void main(String[] args) {
        BFSTraversal bfs = new BFSTraversal();
        int V = 5;
        List<List<Integer>> edges = Arrays.asList(
                Arrays.asList(0, 1),
                Arrays.asList(0, 2),
                Arrays.asList(0, 3),
                Arrays.asList(2, 4)
        );

        System.out.println(bfs.bfsOfGraph(V, edges));
    }

    public List<Integer> bfsOfGraph(int V, List<List<Integer>> edges) {
        boolean[] vistedArr = new boolean[V];
        List<Integer> ans = new ArrayList<>();

        List<List<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < V; i++){
            adj.add(new ArrayList<>());
        }

        for (List<Integer> edge : edges){
            adj.get(edge.get(0)).add(edge.get(1));
            adj.get(edge.get(1)).add(edge.get(0));
        }

        for (int i = 0; i < V; i++) {
            if (!vistedArr[i]) {
                bfsTraversal(i, ans, vistedArr, adj);
            }
        }
        return ans;
    }

    public void bfsTraversal(int node, List<Integer> ans, boolean[] visitedArray, List<List<Integer>> adj){

        Queue<Integer> queue = new LinkedList<>();
        queue.add(node);

        visitedArray[node] = true;

        while(!queue.isEmpty()){
            int vertex = queue.poll();
            ans.add(vertex);

            List<Integer> allNeighbourVertices = adj.get(vertex);

            for (int ver : allNeighbourVertices){
                if (!visitedArray[ver]){
                    visitedArray[ver] = true;
                    queue.add(ver);
                }
            }
        }
    }
}
