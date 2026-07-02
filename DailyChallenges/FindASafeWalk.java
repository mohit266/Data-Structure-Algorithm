package com.dsa.DailyChallenges;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class FindASafeWalk {
    public static void main(String[] args) {
        FindASafeWalk f = new FindASafeWalk();

        List<List<Integer>> grid = Arrays.asList(
                Arrays.asList(0, 1, 0, 0, 0),
                Arrays.asList(0, 1, 0, 1, 0),
                Arrays.asList(0, 0, 0, 1, 0)
        );
        int health = 1;

        System.out.println(f.findSafeWalk(grid, health));
    }

    public boolean findSafeWalk(List<List<Integer>> grid, int health) {
        int m = grid.size();
        int n = grid.get(0).size();

        int[][] dis = new int[m][n];
        for (int[] row : dis) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }
        dis[0][0] = grid.get(0).get(0);

        PriorityQueue<int[]> q = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));

        q.offer(new int[] { dis[0][0], 0, 0 });

        while (!q.isEmpty()) {
            int[] cell = q.poll();

            int damage = cell[0];
            int i = cell[1];
            int j = cell[2];

            if (damage > dis[i][j]) {
                continue;
            }

            if (i == m - 1 && j == n - 1) {
                return damage < health;
            }

            for (int r = -1; r <= 1; r++) {
                for (int c = -1; c <= 1; c++) {
                    if (r == c || r == -c) {
                        continue;
                    }
                    int row = r + i;
                    int col = c + j;

                    if (row >= 0 && row < m && col >= 0 && col < n) {

                        int dmg = damage + grid.get(row).get(col);

                        if (dmg < dis[row][col]) {
                            dis[row][col] = dmg;
                            q.offer(new int[] { dmg, row, col });
                        }
                    }
                }
            }
        }
        return false;
    }
}
