package com.dsa.Graphs;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class DistinctNumOfIslands {

    public static void main(String[] args) {

        DistinctNumOfIslands d = new DistinctNumOfIslands();

        int[][]  grid = {{1, 1, 0, 0, 0}, {1, 1, 0, 0, 0}, {0, 0, 0, 1, 1},{0, 0, 0, 1, 1}};
        System.out.println(d.countDistinctIslands(grid));
    }

    public int countDistinctIslands(int[][] grid) {

        Set<String> shapes = new HashSet<>();

        int n = grid.length;
        int m = grid[0].length;

        boolean[][] visitedMp = new boolean[n][m];


        for (int i = 0; i < n; i++){
            for (int j = 0; j < m; j++){
                if (!visitedMp[i][j] && grid[i][j] == 1){
                    StringBuilder s = new StringBuilder();
                    bfsTraversal(i, j, s, visitedMp, grid);
                    shapes.add(s.toString());
                }
            }
        }

        return shapes.size();
    }

    public void bfsTraversal(int row, int col, StringBuilder s, boolean[][] visitedMp, int[][] grid){


        Queue<int[]> q = new LinkedList<>();

        q.offer(new int[]{row, col});
        visitedMp[row][col] = true;

        while (!q.isEmpty()){
            int[] cell = q.poll();
            int r = cell[0];
            int c = cell[1];

            s.append(r - row) .append(",") .append(c- col).append(";");

            for (int i = -1; i<= 1; i++){
                for (int j = -1; j <= 1; j++){
                    if(i==j || i==-j) continue;
                    int newRow = r + i;
                    int newCol = c + j;

                    if (newRow >=0 && newRow < grid.length && newCol >= 0 && newCol < grid[0].length &&
                            !visitedMp[newRow][newCol] && grid[newRow][newCol] == 1){
                        q.offer(new int[]{newRow, newCol});
                        visitedMp[newRow][newCol] = true;
                    }
                }
            }
        }
    }
}
