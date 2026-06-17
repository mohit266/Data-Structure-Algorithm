package com.dsa.Graphs;

import java.util.LinkedList;
import java.util.Queue;

public class RottenOranges {
    public static void main(String[] args) {
        RottenOranges ro = new RottenOranges();
        int[][]grid = {{2,1,1},{1,1,0},{0,1,1}};

        System.out.println(ro.orangesRotting(grid));
    }

    public int orangesRotting(int[][] grid) {

        int n = grid.length;
        int m = grid[0].length;

        boolean[][] visitedMp = new boolean[n][m];

        int countNoOfOranges = 0;

        Queue<int[]> q = new LinkedList<>();


        for (int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(grid[i][j] != 0) countNoOfOranges++;

                if(grid[i][j] == 2) {
                    q.add(new int[]{i, j});
                }
            }
        }

        return bfsTraversal(countNoOfOranges, q, visitedMp, grid);
    }

    public int bfsTraversal(int orangesCount, Queue<int[]> q, boolean[][] visitedMp, int[][] grid){
        int timer = 0;
        int rottenOranges = 0;

        while (!q.isEmpty()){

            int k = q.size();
            rottenOranges += k;

            while (k > 0 && !q.isEmpty()){
                int[] cell = q.poll();

                int r = cell[0];
                int c = cell[1];

                for (int i = -1; i <= 1; i++){
                    for (int j = -1; j <= 1; j++){
                        if (i ==j || i == -j) continue;

                        int newRow = r + i;
                        int newCol = c + j;

                        if (newRow >= 0 && newRow < grid.length && newCol >= 0 && newCol < grid[0].length &&
                                grid[newRow][newCol] == 1 && !visitedMp[newRow][newCol]){
                            q.offer(new int[]{newRow, newCol});
                            visitedMp[newRow][newCol] = true;
                        }
                    }
                }
                k--;
            }
            if(!q.isEmpty()) timer++;
        }

        return (orangesCount == rottenOranges) ? timer : -1;
    }
}
