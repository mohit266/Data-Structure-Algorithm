package com.dsa.Graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DFSTraversal {

    public static void main(String[] args) {

        DFSTraversal dfs = new DFSTraversal();

        int V = 5;
        List<List<Integer>> edges = Arrays.asList(
                Arrays.asList(0, 1),
                Arrays.asList(0, 2),
                Arrays.asList(0, 3),
                Arrays.asList(2, 4)
        );

        System.out.println(dfs.dfsOfGraph(V, edges));
    }


    public List<Integer> dfsOfGraph(int V, List<List<Integer>> edges) {
        boolean[] visitedArr = new boolean[V];
        List<Integer> ans = new ArrayList<>();

        List<List<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < V; i++){
            adj.add(new ArrayList<>());
        }


        for (List<Integer> edge : edges){
            adj.get(edge.get(0)).add(edge.get(1));
            adj.get(edge.get(1)).add(edge.get(0));
        }

        for (int i = 0; i < V; i++){
            if (!visitedArr[i]){
                dfsRecursive(i, visitedArr, ans, adj);
            }
        }

        return ans;
    }

    public void dfsRecursive(int node, boolean[] visitedArray, List<Integer> ans, List<List<Integer>> adj){

        visitedArray[node] = true;
        ans.add(node);

        List<Integer> allNeighbourNodes = adj.get(node);

        for (int n : allNeighbourNodes){
            if (!visitedArray[n]){
                dfsRecursive(n, visitedArray, ans, adj);
            }
        }
    }
}
