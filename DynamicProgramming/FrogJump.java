package com.dsa.DynamicProgramming;

import java.util.Arrays;

public class FrogJump {
    public static void main(String[] args) {
        FrogJump f = new FrogJump();

        int[] heights = {2, 1, 3, 5, 4};

        System.out.println(f.frogJump(heights));
    }


    public int frogJump(int[] heights) {
        int n = heights.length;
        int[] dp = new int[n];

        Arrays.fill(dp, -1);

        return minJum(n-1, heights, dp);
    }

    public int minJum(int n, int[] heights, int[]dp){

        if (n == 0){
            return 0;
        }

        if (dp[n] != -1) return dp[n];

        int left = minJum(n - 1, heights, dp) + Math.abs(heights[n] - heights[n-1]);
        int right = Integer.MAX_VALUE;

        if (n > 1){
            right = minJum(n-2, heights, dp) + Math.abs(heights[n] - heights[n-2]);
        }

        dp[n] = Math.min(left, right);

        return dp[n];
    }


    public int frogJumpTab(int[] heights) {
        int n = heights.length;
        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        dp[0] = 0;

        for (int ind = 1; ind < n; ind++) {
            int jumpOne = dp[ind - 1] + Math.abs(heights[ind] - heights[ind - 1]);
            int jumpTwo = Integer.MAX_VALUE;
            if (ind > 1)
                jumpTwo = dp[ind - 2] + Math.abs(heights[ind] - heights[ind - 2]);
            dp[ind] = Math.min(jumpOne, jumpTwo);
        }
        return dp[n - 1];
    }

    public int frogJumpSpc(int[] heights) {
        int n = heights.length;
        int prev = 0, prev2 = 0;

        for (int i = 1; i < n; i++) {
            int jumpOne = prev + Math.abs(heights[i] - heights[i - 1]);
            int jumpTwo = Integer.MAX_VALUE;
            if (i > 1)
                jumpTwo = prev2 + Math.abs(heights[i] - heights[i - 2]);

            int cur_i = Math.min(jumpOne, jumpTwo);
            prev2 = prev;
            prev = cur_i;
        }
        return prev;
    }
}
