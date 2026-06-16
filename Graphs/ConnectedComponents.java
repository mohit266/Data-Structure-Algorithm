package com.dsa.Graphs;

import java.util.*;

public class ConnectedComponents {
    public static void main(String[] args) {

        ConnectedComponents c = new ConnectedComponents();

        int V=4;

        List<List<Integer>> edges= Arrays.asList(
                Arrays.asList(0, 1),
                Arrays.asList(1, 2)
        );

        System.out.println(c.findNumberOfComponent(V, edges));

    }

    public int findNumberOfComponent(int V, List<List<Integer>> edges) {

        List<List<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < V; i++){
            adj.add(new ArrayList<>());
        }


        for (List<Integer> edge : edges){
            adj.get(edge.get(0)).add(edge.get(1));
            adj.get(edge.get(1)).add(edge.get(0));
        }

        boolean[] visitedArr = new boolean[V];

        int count = 0;

        for (int i = 0; i < V; i++){
            if (!visitedArr[i]){
                count++;
                bfsTraversal(i, visitedArr, adj);
            }
        }

        return count;

    }

    public void bfsTraversal(int V, boolean[] visitedArr, List<List<Integer>> adj){

        Queue<Integer> q = new LinkedList<>();
        q.offer(V);
        visitedArr[V] = true;

        while (!q.isEmpty()){
            int node = q.poll();

            List<Integer> getNeighbourNodes = adj.get(node);

            for (int n : getNeighbourNodes){
                if (!visitedArr[n]){
                    q.offer(n);
                    visitedArr[n] = true;
                }
            }
        }
    }

    public void dfsTraversal(int V, boolean[] visitedArr, List<List<Integer>> adj){
        visitedArr[V] = true;

        List<Integer> getNeighbourNodes = adj.get(V);

        for (int n : getNeighbourNodes){
            if (!visitedArr[n]){
                dfsTraversal(n, visitedArr, adj);
            }
        }
    }

}
