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

    public int ninjaTrainingTabulation(int[][] matrix) {
        int n = matrix.length;

        int[][] dp = new int[n][4];

        dp[0][0] = Math.max(matrix[0][1], matrix[0][2]);
        dp[0][1] = Math.max(matrix[0][0], matrix[0][2]);
        dp[0][2] = Math.max(matrix[0][0], matrix[0][1]);
        dp[0][3] = Math.max(matrix[0][0], Math.max(matrix[0][1], matrix[0][2]));

        for (int day = 1; day < n; day++) {
            for (int last = 0; last < 4; last++) {
                dp[day][last] = 0;
                for (int task = 0; task <= 2; task++) {
                    if (task != last) {
                        int activity = matrix[day][task] + dp[day - 1][task];
                        dp[day][last] = Math.max(dp[day][last], activity);
                    }
                }
            }
        }
        return dp[n - 1][3];
    }

    public int ninjaTrainingSpaceOptimization(int[][] matrix) {
        int n = matrix.length;

        int[] prev = new int[4];

        prev[0] = Math.max(matrix[0][1], matrix[0][2]);
        prev[1] = Math.max(matrix[0][0], matrix[0][2]);
        prev[2] = Math.max(matrix[0][0], matrix[0][1]);
        prev[3] = Math.max(matrix[0][0], Math.max(matrix[0][1], matrix[0][2]));

        for (int day = 1; day < n; day++) {

            int[] temp = new int[4];

            for (int last = 0; last < 4; last++) {
                temp[last] = 0;
                for (int task = 0; task <= 2; task++) {
                    if (task != last) {
                        temp[last] = Math.max(temp[last], matrix[day][task] + prev[task]);
                    }
                }
            }
            prev = temp;
        }
        return prev[3];
    }

}
