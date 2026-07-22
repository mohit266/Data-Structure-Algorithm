package com.dsa.DynamicProgramming;

import java.util.Arrays;

public class HouseRobber {
    public static void main(String[] args) {

        HouseRobber h = new HouseRobber();

        int[] money = {2, 1, 4, 9};
        System.out.println(h.houseRobber(money));
    }

    public int houseRobber(int[] money) {
        int n = money.length;
        int[] dp1 = new int[n];
        int[] dp2 = new int[n];
        Arrays.fill(dp1, -1);
        Arrays.fill(dp2, -1);

        int[] money1 = new int[n];
        int[] money2 = new int[n];

        for (int i = 0; i < n; i++){
            if (i!=0) money1[i] = money[i];
            if (i!=n-1) money2[i] = money[i];
        }

        return Math.max(memoization(0, money1, dp1), memoization(0, money2, dp2));
    }

    public int memoization(int index, int[] money, int[] dp){

        if (index >= money.length){
            return 0;
        }

        if (dp[index] != -1){
            return dp[index];
        }

        int take = money[index] + memoization(index + 2, money, dp);
        int skip = memoization(index + 1, money, dp);

        dp[index] = Math.max(take, skip);

        return dp[index];

    }


}
