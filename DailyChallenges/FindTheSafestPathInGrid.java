package com.dsa.DailyChallenges;

import java.util.*;
import java.util.stream.IntStream;

public class FindTheSafestPathInGrid {

    public static void main(String[] args) {
        FindTheSafestPathInGrid f = new FindTheSafestPathInGrid();

        List<List<Integer>> grid = Arrays.asList(
                Arrays.asList(0,1,1),
                Arrays.asList(0,1,1),
                Arrays.asList(1, 0, 1)
        );
//
//        List<List<Integer>> grid = Arrays.asList(
//                        Arrays.asList(0,0,0,1),
//                        Arrays.asList(0,0,0,0),
//                        Arrays.asList(0,0,0,0),
//                        Arrays.asList(1,0,0,0)
//                );

        System.out.println(f.maximumSafenessFactor(grid));
    }

    public int maximumSafenessFactor(List<List<Integer>> grid) {
        int r = grid.size();
        int c = grid.get(0).size();

        int[][] dist = new int[r][c];
        for (int[] row : dist) Arrays.fill(row, -1);

        Queue<int[]> pq = new LinkedList<>();

        for (int i = 0; i < r; i++){
            for (int j = 0; j < c; j++){
                if (grid.get(i).get(j) == 1){
                    dist[i][j] = 0;
                    pq.offer(new int[]{i, j});
                }
            }
        }


        while(!pq.isEmpty()){
            int [] cell = pq.poll();
            int row = cell[0];
            int col = cell[1];

            for (int i = -1; i <= 1; i++){
                for (int j = -1; j <= 1; j++){
                    if (i == j || i == -j){
                        continue;
                    }
                    int newRow = row + i;
                    int newCol = col + j;

                    if (newRow >= 0 && newRow < r && newCol >= 0 && newCol < c && dist[newRow][newCol] == -1){
                        dist[newRow][newCol] = dist[row][col] + 1;
                        pq.offer(new int[] {newRow, newCol});
                    }
                }
            }
        }

        int low = 0, high = 2 * r;

        while (low <= high) {
            int mid = (low + high) / 2;

            if (canReach(mid, dist, r, c)) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return high;
    }

    private boolean canReach(int limit, int[][] dist, int r, int c) {
        if (dist[0][0] < limit) return false;

        boolean[][] vis = new boolean[r][c];
        Queue<int[]> q = new LinkedList<>();

        q.offer(new int[]{0, 0});
        vis[0][0] = true;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int a = cur[0];
            int b = cur[1];

            if (a == r - 1 && b == c - 1) {
                return true;
            }

            for (int i = -1; i <= 1; i++){
                for (int j = -1; j <= 1; j++){
                    if (i == j || i == -j){
                        continue;
                    }
                    int newRow = a + i;
                    int newCol = b + j;

                    if (newRow >= 0 && newRow < r && newCol >= 0 && newCol < c &&  !vis[newRow][newCol]
                            && dist[newRow][newCol] >= limit){
                        vis[newRow][newCol] = true;
                        q.offer(new int[]{newRow, newCol});
                    }
                }
            }
        }

        return false;
    }

}











