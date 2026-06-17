package com.dsa.Graphs;

import java.util.LinkedList;
import java.util.Queue;

public class NumberOfEnclaves {
    public static void main(String[] args) {
        NumberOfEnclaves enclaves = new NumberOfEnclaves();

        int[][] grid = {{0,1,1,0},{0,0,1,0},{0,0,1,0},{0,0,0,0}};
        System.out.println(enclaves.numEnclaves(grid));

    }

    public int numEnclaves(int[][] grid) {

        int n = grid.length;
        int m = grid[0].length;

        boolean[][] visitedMp = new boolean[n][m];
        Queue<int[]> q = new LinkedList<>();

        for(int i=0; i < n; i++) {
            for(int j=0; j < m; j++) {
                if((i == 0 || i == n-1 || j == 0 || j == m-1) && grid[i][j] == 1) {
                    visitedMp[i][j] = true;
                    q.add(new int[]{i, j});
                }
            }
        }

        bfsTraversal(q, grid, visitedMp);

        int count = 0;

        for(int i=0; i < n; i++) {
            for(int j=0; j < m; j++){
                if(grid[i][j] == 1 && !visitedMp[i][j])
                    count++;
            }
        }

        return count;

    }

    public void bfsTraversal(Queue<int[]> q, int[][] grid, boolean[][] visitedMp){

        while(!q.isEmpty()){
            int[] cell = q.poll();
            int r = cell[0];
            int c = cell[1];

            for (int i = -1; i <= 1; i++){
                for (int j = -1; j <= 1; j++){
                    if (i == j || i == -j) continue;

                    int newRow = r + i;
                    int newCol = c + j;

                    if (newRow >= 0 && newRow < grid.length && newCol >=0 && newCol < grid[0].length &&
                            grid[newRow][newCol] == 1 && !visitedMp[newRow][newCol]){
                        q.offer(new int[]{newRow, newCol});
                        visitedMp[newRow][newCol] = true;
                    }
                }
            }
        }
    }

}
