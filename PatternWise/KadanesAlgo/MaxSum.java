package com.dsa.PatternWise.KadanesAlgo;

public class MaxSum {

    // 53. Maximum Subarray
    public static void main(String[] args) {
        MaxSum m = new MaxSum();

        int[] nums = {2, 3, 5, -2, 7, -4};

        System.out.println(m.maxSubArray(nums));

    }

    public int maxSubArray(int[] nums) {

        int bestEnding = 0;
        int ans = Integer.MIN_VALUE;

        for (int num : nums) {
            int v1 = bestEnding + num;

            bestEnding = Math.max(v1, num);
            ans = Math.max(ans, bestEnding);
        }

        return ans;
    }

}
