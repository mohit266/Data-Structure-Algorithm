package com.dsa.Graphs;

public class NumberOfOperationsToMakeNetworkConnected {
    public static void main(String[] args) {
        int n = 9;
        int[][] Edge =  {{0,1},{0,2},{0,3},{1,2},{2,3},{4,5},{5,6},{7,8}};

        NumberOfOperationsToMakeNetworkConnected no = new NumberOfOperationsToMakeNetworkConnected();

        System.out.println(no.solve(n, Edge));
    }

    public int solve(int n, int[][] Edge) {

        int totalEdges = Edge.length;
        if(totalEdges < n-1) return -1;

        DisjointSet ds = new DisjointSet(n);

        for (int[] edge : Edge){
            ds.unionBySize(edge[0], edge[1]);
        }

        int count = -1;

        for (int i = 0; i < n; i++){
            if (ds.parent[i] == i){
                count++;
            }
        }

        return count;
    }

}
