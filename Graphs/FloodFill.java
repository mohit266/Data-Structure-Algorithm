package com.dsa.Graphs;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class FloodFill {
    public static void main(String[] args) {
        FloodFill ff = new FloodFill();
        int[][] image = {{0,0,0},{0,0,0}};
        int sr = 0;
        int sc = 0;
        int color = 0;

        System.out.println(Arrays.deepToString(ff.floodFill(image, sr, sc, color)));
    }


    public int[][] floodFill(int[][] image, int sr, int sc, int color) {

        int pixel = image[sr][sc];
        int n = image.length;
        int m = image[0].length;

        boolean[][] visitedMp = new boolean[n][m];

        bfsTraversal(pixel, sr, sc, color, visitedMp, image);

        return image;

    }

    public void bfsTraversal(int pixel, int sr, int sc, int color, boolean[][] visitedMp, int[][] image) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] { sr, sc });
        visitedMp[sr][sc] = true;

        while (!q.isEmpty()) {
            int[] cell = q.poll();

            int newRow = cell[0];
            int newCol = cell[1];
            image[newRow][newCol] = color;

            for (int i = -1; i <= 1; i++) {
                for (int j = -1; j <= 1; j++) {
                    if (i == j || i == -j)
                        continue;
                    int row = newRow + i;
                    int col = newCol + j;

                    if (row >= 0 && row < image.length && col >= 0 && col < image[0].length
                            && image[row][col] == pixel && !visitedMp[row][col]) {
                        visitedMp[row][col] = true;
                        q.offer(new int[] {row, col});
                    }
                }
            }
        }
    }

}
