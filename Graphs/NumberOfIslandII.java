package com.dsa.Graphs;

import java.util.*;


public class NumberOfIslandII {

    public static void main(String[] args) {

        NumberOfIslandII islandII = new NumberOfIslandII();

        int n = 4;
        int m = 5;

        int[][] A = {{1,1},{0,1},{3,3},{3,4}};
        System.out.println(islandII.numOfIslands(n, m, A));

    }



    public List<Integer> numOfIslands(int n, int m, int[][] A) {

        DisjointSet ds = new DisjointSet(n * m);

        boolean[][] vis = new boolean[n][m];
        List<Integer> ls = new ArrayList<>();

        int count = 0;

        for (int[] arr : A){
            int r = arr[0];
            int c = arr[1];

            int node = r * m + c;

            if (vis[r][c]){
                ls.add(count);
                continue;
            }

            count++;

            vis[r][c] = true;

            for (int i = - 1; i <= 1; i++){
                for (int j = -1; j <= 1; j++){
                    if (i == j || i == -j){
                        continue;
                    }

                    int row = r + i;
                    int col = c + j;

                    if (row >= 0 && row < n && col >= 0 && col < m && vis[row][col]){
                        int adjNode = row * m + col;

                        if (ds.findParent(node) != ds.findParent(adjNode)){
                            ds.unionBySize(node, adjNode);
                            count--;
                        }
                    }
                }
            }
            ls.add(count);
        }
        return ls;
    }

}
