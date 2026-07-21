package com.dsa.DynamicProgramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MaximumSumOfNonAdjacentElements {
    public static void main(String[] args) {
        MaximumSumOfNonAdjacentElements m = new MaximumSumOfNonAdjacentElements();

        int[] nums = {1,2,1,1};
        System.out.println(m.nonAdjacentUsingMemoization(nums));
    }

    public int nonAdjacent(int[] nums) {
        int n = nums.length;
        int prev = nums[0];
        int prev2 = 0;

        for (int i = 1; i < n; i++) {
            int pick = nums[i];

            if (i > 1) {
                pick += prev2;
            }
            int nonPick = prev;

            int cur_i = Math.max(pick, nonPick);

            prev2 = prev;
            prev = cur_i;
        }
        return prev;
    }

    public int nonAdjacentUsingMemoization(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, -1);
        return recursion(0, dp, nums);
    }

    private int recursion(int index, int[]dp, int[] nums) {
        if (index >= nums.length) {
            return 0;
        }

        if (dp[index] != -1){
            return dp[index];
        }

        int take = nums[index] + recursion(index + 2, dp, nums);
        int skip = recursion(index + 1, dp, nums);

        dp[index] = Math.max(take, skip);
        return dp[index];
    }

    public int nonAdjacentUsingRecursion(int[] nums) {
        return recursion(0, 0, nums);
    }

    private int recursion(int index, int currSum, int[] nums) {
        if (index >= nums.length) {
            return currSum;
        }

        int take = recursion(index + 2, currSum + nums[index], nums);
        int skip = recursion(index + 1, currSum, nums);

        return Math.max(take, skip);
    }
}
