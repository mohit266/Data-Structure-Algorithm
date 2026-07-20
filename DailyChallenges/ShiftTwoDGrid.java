package com.dsa.DailyChallenges;

import java.util.ArrayList;
import java.util.List;

public class ShiftTwoDGrid {
    public static void main(String[] args) {

        ShiftTwoDGrid s = new ShiftTwoDGrid();

        int[][]grid = {{3,8,1,9},{19,7,2,5},{4,6,11,10},{12,0,21,13}};
        int k = 4;

        System.out.println(s.shiftGrid(grid, k));
    }

    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;
        int len = m * n;

        List<List<Integer>> res = new ArrayList<>();
        int startIdx = len - (k % len);

        for (int i = 0; i < m; i++){
            int count = 0;
            List<Integer> ls = new ArrayList<>();

            while (count < n){

                if (startIdx >= len){
                    startIdx = 0;
                }

                int col = startIdx % n;
                int row = startIdx / n;

                ls.add(grid[row][col]);

                startIdx++;
                count++;
            }
            res.add(ls);
        }
        return res;
    }
}
