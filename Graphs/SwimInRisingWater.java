package com.dsa.Graphs;

import java.util.Comparator;
import java.util.PriorityQueue;

public class SwimInRisingWater {

    public static void main(String[] args) {

        SwimInRisingWater swim = new SwimInRisingWater();

        int[][] grid = {{0,1,2,3,4},{24,23,22,21,5},{12,13,14,15,16},{11,17,18,19,20},{10,9,8,7,6}};

        System.out.println(swim.swimInWater(grid));

    }


    public int swimInWater(int[][] grid) {
        int n = grid.length;

        boolean[][] vis = new boolean[n][n];

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a-> a[0]));

        pq.offer(new int[]{0,0,0,grid[0][0]});
        vis[0][0] = true;

        while(!pq.isEmpty()){
            int[] cell = pq.poll();

            int t = cell[0];
            int r = cell[1];
            int c = cell[2];
            int maxT = cell[3];

            if (r == n -1 && c == n -1 ){
                return maxT;
            }

            for (int i = -1; i <= 1; i++){
                for (int j = -1; j <= 1; j++){
                    if (i == j || i == -j){
                        continue;
                    }

                    int newRow = r + i;
                    int newCol = c + j;

                    if (newRow >= 0 && newRow < n && newCol >= 0 && newCol < n &&
                            !vis[newRow][newCol]){
                        vis[newRow][newCol] = true;
                        int val = grid[newRow][newCol];
                        pq.offer(new int[] {val, newRow, newCol, Math.max(val, maxT)});
                    }
                }
            }
        }

        return -1;

    }
}
