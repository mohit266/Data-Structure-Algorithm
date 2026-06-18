package com.dsa.Graphs;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class SurroundedRegions {

    public static void main(String[] args) {

        SurroundedRegions s = new SurroundedRegions();

        char[][] board = {
                {'O','X','X','O','X'},
                {'X','O','O','X','O'},
                {'X','O','X','O','X'},
                {'O','X','O','O','O'},
                {'X','X','O','X','O'}
        };
        s.solve(board);
        System.out.println(Arrays.deepToString(board));
    }

    public void solve(char[][] board) {
        int n = board.length;
        int m = board[0].length;

        Queue<int[]> q = new LinkedList<>();
        boolean[][] visitedMp = new boolean[n][m];

        for (int i = 0; i < n; i++){
            for (int j = 0; j < m; j++){
                if ((i == 0 || j == 0 || i == n - 1 || j == m - 1) && board[i][j] == 'O'){
                    q.offer(new int[]{i, j});
                    visitedMp[i][j] = true;
                }
            }
        }

        bfsTraversal(q, visitedMp, board);

        for (int i = 0; i < n; i++){
            for (int j = 0; j < m; j++){
                if (!visitedMp[i][j] && board[i][j] == 'O'){
                    board[i][j] = 'X';
                }
            }
        }
    }

    public void bfsTraversal(Queue<int[]> q, boolean[][] visitedMp, char[][] board){

        while(!q.isEmpty()){
            int[] cell = q.poll();

            int row = cell[0];
            int col = cell[1];

            for (int i = -1; i <= 1; i++){
                for (int j = -1; j <= 1; j++){
                    if (i == j || i == -j) {
                        continue;
                    }

                    int newRow = row + i;
                    int newCol = col + j;

                    if (newRow >= 0 && newRow < board.length && newCol >= 0 && newCol < board[0].length
                            && board[newRow][newCol] == 'O' && !visitedMp[newRow][newCol]){
                        q.offer(new int[]{newRow, newCol});
                        visitedMp[newRow][newCol] = true;
                    }
                }
            }
        }
    }
}
