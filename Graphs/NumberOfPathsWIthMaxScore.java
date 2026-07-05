package com.dsa.Graphs;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// TODO : This is a DP questions , using graph its giving TLE.
public class NumberOfPathsWIthMaxScore {
    public static void main(String[] args) {
        List<String> board = Arrays.asList("E23","2X2","12S");

        NumberOfPathsWIthMaxScore n = new NumberOfPathsWIthMaxScore();
        System.out.println(Arrays.toString(n.pathsWithMaxScore(board)));

    }

    int[][] dir = {
            {-1, 0},
            {0, -1},
            {-1, -1}
    };

    public int[] pathsWithMaxScore(List<String> board) {
        int MOD = 1_000_000_007;

        int n = board.size();
        int m = board.get(0).length();

        char[][] adj = new char[n][m];


        for (int i = 0; i < n; i++){
            String s = board.get(i);
            char[] chars = s.toCharArray();

            for (int j = 0; j < m; j++){
                adj[i][j] = chars[j];
            }
        }

        if (adj[0][0] != 'E' || adj[n-1][m-1] != 'S'){
            return new int[] {0, 0};
        }

        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{n-1, m-1, 0});

        int maxValue = 0;
        int path = 0;

        while (!q.isEmpty()){
            int[] cell = q.poll();
            int r = cell[0];
            int c = cell[1];
            int dis = cell[2];

            if (r == 0 && c == 0){

                if (dis == maxValue){
                    path++;
                }

                if (maxValue < dis){
                    maxValue = dis % MOD;
                    path = 1;
                }
                continue;
            }

            for (int[] d : dir){
                int newRow = r + d[0];
                int newCol = c + d[1];

                if (newRow >= 0 && newRow < n && newCol >= 0 && newCol < m &&
                        adj[newRow][newCol] != 'X'){

                    int res = adj[newRow][newCol];

                    if (Character.isDigit(res)) {
                        res = res - '0';
                    } else {
                        res = 0;
                    }
                    res = res + dis;

                    q.offer(new int[]{newRow, newCol, res % MOD});
                }
            }
        }

        return new int[]{maxValue,path};

    }
}
