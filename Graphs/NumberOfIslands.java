package com.dsa.Graphs;

import java.util.LinkedList;
import java.util.Queue;

public class NumberOfIslands {
    public static void main(String[] args) {
        char[][] grid =  {
                {'1', '1', '0', '0', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '1', '0', '0'},
                {'0', '0', '0', '1', '1'}};

        NumberOfIslands n = new NumberOfIslands();

        System.out.println(n.numIslands(grid));
    }

    public int numIslands(char[][] grid) {

        int n = grid.length;
        int m = grid[0].length;

        boolean[][] visitedMp = new boolean[n][m];

        int count = 0;
        for (int row = 0; row < n; row++){
            for (int col = 0; col < m; col++){
                if (grid[row][col] == '1'){
                    if (!visitedMp[row][col]){
                        count++;
                        bsfTraversal(row,col,visitedMp,grid);
                    }
                }
            }
        }
        return count;
    }

    private void bsfTraversal(int row, int col, boolean[][] visitedMp, char[][] grid) {

        Queue<int[]> q = new LinkedList<>();

        q.offer(new int[] {row, col});
        visitedMp[row][col] = true;

        while (!q.isEmpty()){
            int[] cell = q.poll();
            int newRow = cell[0];
            int newCol = cell[1];

            for (int i = -1; i <= 1; i++){
                for (int j = -1; j <= 1; j++){
                    int r = newRow + i;
                    int c = newCol + j;

                    if (r >= 0 && r < grid.length && c >= 0 && c < grid[0].length &&
                            grid[r][c] == '1' && !visitedMp[r][c] ){
                        visitedMp[r][c] = true;
                        q.offer(new int[]{r, c});
                    }
                }
            }
        }
    }
}
