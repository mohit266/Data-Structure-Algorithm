package com.dsa.Graphs;

import java.util.HashSet;
import java.util.Set;

public class MakeALargeIsland {

    public static void main(String[] args) {
        MakeALargeIsland m = new MakeALargeIsland();

        int[][] grid = {{1,1},{1,0}};

        System.out.println(m.largestIsland(grid));

    }

    public int largestIsland(int[][] grid) {

        int n = grid.length;

        DisjointSet ds = new DisjointSet(n * n);

        for (int row = 0; row < n; row++){
            for (int col = 0; col < n; col++){

                if (grid[row][col] == 0) {
                    continue;
                }

                for (int i = -1; i <= 1; i++){
                    for (int j = -1; j <= 1; j++){
                        if (i == j || i == -j){
                            continue;
                        }

                        int r = row + i;
                        int c = col + j;

                        if (r >= 0 && r < n && c >= 0 && c < n && grid[r][c] == 1){
                            int node = row * n + col;
                            int adjNode = r * n + c;

                            ds.unionBySize(node, adjNode);
                        }
                    }
                }
            }
        }

        int max = 0;
        for (int row = 0; row < n; row++){
            for (int col = 0; col < n; col++){

                if (grid[row][col] == 1) {
                    continue;
                }

                Set<Integer> st = new HashSet<>();
                for (int i = -1; i <= 1; i++){
                    for (int j = -1; j <= 1; j++){
                        if (i == j || i== -j){
                            continue;
                        }

                        int r = row + i;
                        int c = col + j;

                        if (r >= 0 && r < n && c >= 0 && c < n && grid[r][c] == 1){
                            int adjNode = r * n + c;
                            st.add(ds.findParent(adjNode));
                        }
                    }
                }

                int sum = 0;
                for (int num : st){
                    sum = sum + ds.size[num];
                }

                max = Math.max(max, sum + 1);
            }
        }

        for (int cellNo = 0; cellNo < n * n; cellNo++) {
            max = Math.max(max, ds.size[ds.findParent(cellNo)]);
        }

        return max;

    }
}
