package com.dsa.DynamicProgramming;

import java.util.Arrays;

public class FrogJumpWithKDistance {

    public static void main(String[] args) {

        FrogJumpWithKDistance f = new FrogJumpWithKDistance();

        int[] heights = {10, 5, 20, 0, 15};
        int k = 2;

        System.out.println(f.frogJumpWithMemoization(heights, k));

    }

    public int frogJump(int[] heights, int k) {
        int n = heights.length;

        int[] dp = new int[k];

        for (int i = 1; i < n; i++) {
            int minSteps = Integer.MAX_VALUE;

            for (int j = 1; j <= k; j++) {
                if (i - j >= 0) {
                    int prevIndex = (i - j) % k;
                    int jump = dp[prevIndex] + Math.abs(heights[i] - heights[i - j]);
                    minSteps = Math.min(minSteps, jump);
                }
            }
            dp[i % k] = minSteps;
        }

        return dp[(n - 1) % k];
    }


    // Tabulation
    public int frogJumpWithTabulation(int[] heights, int k) {
        int ind = heights.length - 1;
        int[] dp = new int[ind+1];
        Arrays.fill(dp, -1);

        for (int i = 1; i < ind; i++){
            int minSteps = Integer.MAX_VALUE;

            for (int j = 1; j <= k; j++){
                if (i - j >= 0) {
                    int jump = dp[i - j] + Math.abs(heights[i] - heights[i - j]);
                    minSteps = Math.min(jump, minSteps);
                }
            }
            dp[i] = minSteps;
        }

        return dp[ind - 1];
    }


    // Memoization
    public int frogJumpWithMemoization(int[] heights, int k) {
        int ind = heights.length - 1;
        int[] dp = new int[ind+1];
        Arrays.fill(dp, -1);

        return recursion(ind, heights, k, dp);
    }

    public int recursion(int n, int[] heights, int k, int[] dp){
        if (n == 0){
            return 0;
        }

        if (dp[n] != -1){
            return dp[n];
        }

        int minSteps = Integer.MAX_VALUE;
        for (int i = 1; i <= k; i++){
            if (n - i >= 0){
                minSteps = Math.min(minSteps, recursion(n-i, heights, k) + Math.abs(heights[n] - heights[n-i]));
            }
        }
        dp[n] = minSteps;
        return dp[n];
    }


    // Recursion
    public int frogJumpWithRecursion(int[] heights, int k) {
        int ind = heights.length - 1;
        return recursion(ind, heights, k);
    }

    public int recursion(int n, int[] heights, int k){
        if (n == 0){
            return 0;
        }

        int minSteps = Integer.MAX_VALUE;
        for (int i = 1; i <= k; i++){
            if (n - i >= 0){
                minSteps = Math.min(minSteps, recursion(n-i, heights, k) + Math.abs(heights[n] - heights[n-i]));
            }
        }
        return minSteps;
    }
}
