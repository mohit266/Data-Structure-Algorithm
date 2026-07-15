package com.dsa.DynamicProgramming;

import com.dsa.BasicRecursion.FibonacciNumber;

import java.util.Arrays;

public class FibonacciSeries {

    public static void main(String[] args) {

        FibonacciSeries fibo = new FibonacciSeries();

        int n = 5;
        System.out.println(fibo.getFibNum(n));


    }


    // Tabulation Pattern - with optimal solution.
    public int getFibNum(int n){
        int prev = 1;
        int prev2 = 0;

        if (n == 0) {
            return prev2;
        }

        if (n == 1) {
            return prev;
        }

        int current = 0;

        for (int i = 2; i <= n; i++){
            current = prev + prev2;
            prev2 = prev;
            prev = current;
        }

        return current;
    }

    // Tabulation Pattern - Takes O(N) space.
    public int getFiboNum(int n){

        int[] dp = new int[n+1];
        dp[0] = 0;
        dp[1] = 1;

        for(int i = 2; i <= n; i++){
            dp[i] = dp[i-1] + dp[i-2];
        }

        return dp[n];

    }


    // Memoization Pattern.
    public int getFibonacciNum(int n){

        int[] dp = new int[n+1];
        Arrays.fill(dp, -1);

        return recursive(n, dp);

    }

    public int recursive(int n, int[] dp){
        if (n <= 1){
            return n;
        }

        if (dp[n] != -1){
            return dp[n];
        }

        return dp[n] = recursive(n - 1, dp) + recursive(n - 2, dp);
    }


}
