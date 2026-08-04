package com.dsa.PatternWise.KadanesAlgo;

// 918. Maximum Sum Circular Subarray
public class MaximumSumCircularSubarray {

    public static void main(String[] args) {
        MaximumSumCircularSubarray m = new MaximumSumCircularSubarray();

        int[] nums = {-3, -2, -3};
        System.out.println(m.maxSubarraySumCircular(nums));
    }

    public int maxSubarraySumCircular(int[] nums) {

        int bestEndingMax = 0;
        int bestEndingMin = 0;

        int maxSum = Integer.MIN_VALUE;
        int minSum = Integer.MAX_VALUE;

        int sum = 0;

        for (int num : nums){
            sum += num;

            bestEndingMax = Math.max(bestEndingMax + num, num);
            bestEndingMin = Math.min(bestEndingMin + num, num);

            maxSum = Math.max(bestEndingMax, maxSum);
            minSum = Math.min(bestEndingMin, minSum);
        }

        if(maxSum < 0) return maxSum;


        return Math.max(maxSum, sum - minSum);
    }

}
