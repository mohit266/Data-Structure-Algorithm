package com.dsa.DynamicProgramming;

import java.util.Arrays;

public class ClimbingStairs {

    public static void main(String[] args) {

        ClimbingStairs c = new ClimbingStairs();

        int n = 7;
        System.out.println(c.climbStairsSpc(n));

    }

    // Recursion
    public int climbStairs(int n) {

        if (n == 0) return 1;
        if (n == 1) return 1;

        int left = climbStairs(n - 1);
        int right = climbStairs(n - 2);

        return left + right;

    }

    // Memoization
    public int climbStairsMem(int n){
        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);

        return recur(n, dp);
    }

    public int recur(int n, int[] dp){
        if (n <= 1) {
            return 1;
        }

        if (dp[n] != -1){
            return dp[n];
        }

        dp[n] = recur(n - 1, dp) + recur(n - 2, dp);

        return dp[n];
    }

    // Tabulation
    public int climbStairsTab(int n){
        int[] dp = new int[n + 1];

        dp[0] = dp[1] = 1;


        for (int i = 2; i <= n; i++){
            dp[i] = dp[i-1] + dp[i-2];
        }

        return dp[n];
    }

    // Tabulation with space optimization
    public int climbStairsSpc(int n){
        int prev = 1;
        int prev2 = 1;

        int current = 1;
        for (int i = 2; i <= n; i++){
            current = prev + prev2;
            prev2 = prev;
            prev = current;
        }
        return current;
    }

}
