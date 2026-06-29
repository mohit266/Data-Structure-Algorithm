package com.dsa.Graphs;

import java.util.*;

public class ShortestPathInBinaryMatrix {
    public static void main(String[] args) {
        ShortestPathInBinaryMatrix s = new ShortestPathInBinaryMatrix();
        int[][] grid = {{0,0,0},{1,1,0},{1,1,0}};

        System.out.println(s.shortestPathBinaryMatrix(grid));
    }

    public int shortestPathBinaryMatrix(int[][] grid) {

        if (grid[0][0] != 0){
            return -1;
        }

        int r = grid.length;
        int c = grid[0].length;

        int[][] distance = new int[r][c];

        for (int[] arr : distance){
            Arrays.fill(arr, Integer.MAX_VALUE);
        }

        Queue<int[]> q = new LinkedList<>();

        q.offer(new int[]{0,0});
        distance[0][0] = 1;

        while (!q.isEmpty()){

            int[] cell = q.poll();

            int row = cell[0];
            int col = cell[1];

            for (int i = -1; i <= 1; i++){
                for (int j = -1; j <= 1; j++){
                    int newRow = row + i;
                    int newCol = col + j;

                    if (newRow >= 0 && newRow < r && newCol >= 0 && newCol < c
                            && grid[newRow][newCol] == 0){

                        int previousDistance = distance[row][col];

                        if (previousDistance + 1 < distance[newRow][newCol]){
                            distance[newRow][newCol] = previousDistance + 1;
                            q.offer(new int[] {newRow, newCol});
                        }
                    }
                }
            }
        }

        if (distance[r-1][c-1] == Integer.MAX_VALUE){
            return -1;
        }

        return distance[r-1][c-1];

    }
}
