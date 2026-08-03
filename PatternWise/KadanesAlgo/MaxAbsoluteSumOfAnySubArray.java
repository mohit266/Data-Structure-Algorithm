package com.dsa.PatternWise.KadanesAlgo;

// 1749. Maximum Absolute Sum of Any Subarray
public class MaxAbsoluteSumOfAnySubArray {

    public static void main(String[] args) {
        MaxAbsoluteSumOfAnySubArray m = new MaxAbsoluteSumOfAnySubArray();

        int[] nums = {1,-3,2,3,-4};
        System.out.println(m.maxAbsoluteSum(nums));
    }

    public int maxAbsoluteSum(int[] nums) {
        int bestEndingMax = 0;
        int bestEndingMin = 0;

        int maxSum = Integer.MIN_VALUE;
        int minSum = Integer.MAX_VALUE;


        for (int n : nums){
            int v1 = bestEndingMax + n;
            int v2 = bestEndingMin + n;

            bestEndingMax = Math.max(v1, n);
            bestEndingMin = Math.min(v2, n);

            maxSum = Math.max(maxSum, bestEndingMax);
            minSum = Math.min(minSum, bestEndingMin);
        }

        return Math.max(Math.abs(minSum), Math.abs(maxSum));
    }

}
