package com.dsa.Graphs;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class NearestCellHavingOne {
    public static void main(String[] args) {

        NearestCellHavingOne nco = new NearestCellHavingOne();

        int[][] grid = {
                    {0, 1, 1, 0},
                    {1, 1, 0, 0},
                    {0, 0, 1, 1}
                };

        System.out.println((Arrays.deepToString(nco.nearest(grid))));
    }

    public int[][] nearest(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        int[][] res = new int[n][m];

        boolean[][] visitedMp = new boolean[n][m];

        Queue<int[]> q = new LinkedList<>();

        for (int i = 0; i < n; i++){
            for (int j = 0; j < m; j++){
                if (grid[i][j] == 1){
                    q.offer(new int[]{i, j, 0});
                    visitedMp[i][j] = true;
                }
            }
        }
        bfsTraversal(q, visitedMp, res, grid);

        return res;
    }

    public void bfsTraversal(Queue<int[]> q, boolean[][] visitedMp ,int[][] res, int[][] grid){

        while (!q.isEmpty()){
            int[] cell = q.poll();

            int row = cell[0];
            int col = cell[1];

            int steps = cell[2];

            res[row][col] = steps;

            for (int i = - 1; i <= 1; i++){
                for (int j = -1; j <= 1; j++){
                    if (i == j || i == -j) continue;
                    int newRow = row + i;
                    int newCol = col + j;

                    if (newRow >= 0 && newRow < grid.length && newCol >= 0 && newCol < grid[0].length
                        && !visitedMp[newRow][newCol]) {
                        q.offer(new int[] {newRow, newCol, steps + 1});
                        visitedMp[newRow][newCol] = true;
                    }
                }
            }
        }
    }

}
