package com.dsa.Graphs;

import java.util.*;

public class PathWithMinimumEffort {
    public static void main(String[] args) {
        PathWithMinimumEffort p = new PathWithMinimumEffort();
        int[][] heights = {{1,2,2},{3,8,2},{5,3,5}};

        System.out.println(p.minimumEffortPath(heights));
    }

    public int minimumEffortPath(int[][] heights) {

        int r = heights.length;
        int c = heights[0].length;

        int[][] dis = new int[r][c];

        for (int[] arr : dis){
            Arrays.fill(arr, Integer.MAX_VALUE);
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a->a[0]));

        pq.offer(new int[]{0,0,0});
        dis[0][0] = heights[0][0];

        while (!pq.isEmpty()){
            int[] cell = pq.poll();

            int diff = cell[0];
            int row = cell[1];
            int col = cell[2];

            if (row == r - 1 && col == c - 1)
                return diff;

            for (int i = -1; i <= 1; i++){
                for (int j = -1; j <= 1; j++){
                    if (i == j || i == -j){
                        continue;
                    }

                    int newRow = row + i;
                    int newCol = col + j;

                    if (newRow >= 0 && newRow < r && newCol >= 0 && newCol < c){
                        int currentValue = heights[newRow][newCol];
                        int prevValue = heights[row][col];

                        int currDiff = Math.abs(currentValue - prevValue);

                        if (Math.max(currDiff, diff) < dis[newRow][newCol]){
                            dis[newRow][newCol] = Math.max(currDiff, diff);
                            pq.add(new int[]{Math.max(currDiff, diff), newRow, newCol});
                        }
                    }
                }
            }
        }
        return -1;
    }
}
