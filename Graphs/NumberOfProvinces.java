package com.dsa.Graphs;

import java.util.ArrayList;
import java.util.List;

public class NumberOfProvinces {
    public static void main(String[] args) {
        NumberOfProvinces n = new NumberOfProvinces();
        int[][] matrix = {{1, 0, 0, 1}, {0, 1, 1, 0}, {0, 1, 1, 0}, {1, 0, 0, 1}};

        System.out.println(n.numProvinces(matrix));
    }

    public int numProvinces(int[][] matrix) {

        int V = matrix.length;

        List<List<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < V; i++){
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < V; i++){
            for (int j = 0; j < V; j++){
                if (matrix[i][j] == 1 && i != j){
                    adj.get(i).add(j);
                    adj.get(j).add(i);
                }
            }
        }
        boolean[] visitedArr = new boolean[V];
        int count = 0;

        for (int i = 0; i < V; i++){
            if (!visitedArr[i]){
                count++;
                dfsTraversal(i, visitedArr, adj);
            }
        }

        return count;
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
