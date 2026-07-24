package com.dsa.DynamicProgramming;

import java.util.Arrays;

public class NinjaTraining {

    public static void main(String[] args) {
        NinjaTraining n = new NinjaTraining();
        int[][] matrix = {{10, 40, 70}, {20, 50, 80}, {30, 60, 90}};


        System.out.println(n.ninjaTraining(matrix));

    }

    public int ninjaTraining(int[][] matrix) {

        int[][] dp = new int[matrix.length][4];
        for (int[] arr : dp){
            Arrays.fill(arr, -1);
        }
        return memoization(matrix.length - 1, 3, matrix, dp);

    }

    public int memoization(int day, int last, int[][] matrix, int[][]dp){

        if (dp[day][last] != -1) return dp[day][last];

        if (day == 0){
            int maxi = 0;
            for (int i = 0; i < 3; i++){
                if (last != i) {
                    maxi = Math.max(maxi, matrix[day][i]);
                }
            }
            return dp[day][last] = maxi;
        }

        int maxi = 0;
        for (int i = 0; i < 3; i++) {
            if (i != last) {
                int activity = matrix[day][i] + memoization(day - 1, i, matrix, dp);
                maxi = Math.max(maxi, activity);
            }
        }
        return dp[day][last] = maxi;
    }

}
