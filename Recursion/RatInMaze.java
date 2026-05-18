package com.dsa.Recursion;

import java.util.ArrayList;
import java.util.List;

public class RatInMaze {
    public static void main(String[] args) {
        int[][]  grid = { {1, 0, 0, 0} , {1, 1, 0, 1}, {1, 1, 0, 0}, {0, 1, 1, 1} };
        System.out.println(findPath(grid));
    }

    public static List<String> findPath(int[][] grid) {
        List<String> ans = new ArrayList<>();
        if (grid[0][0] == 0 || grid[grid.length - 1][grid.length - 1] == 0) return ans;
        backtrack(0, 0, grid, "", ans);
        return ans;
    }

    public static void backtrack(int row, int col, int[][] grid, String current, List<String> ans){
        if (row == grid.length -1 && col == grid[0].length - 1){
            ans.add(current);
            return;
        }

        if (grid[row][col] == 0){
            return;
        }

        grid[row][col] = 0;

        if (row > 0) backtrack(row - 1, col, grid, current + 'U', ans);
        if (col > 0) backtrack( row, col - 1, grid, current + 'L', ans);
        if (row < grid.length - 1) backtrack(row + 1, col, grid, current + 'D', ans);
        if (col < grid.length - 1) backtrack( row, col + 1, grid, current + 'R', ans);

        grid[row][col] = 1;
    }
}
