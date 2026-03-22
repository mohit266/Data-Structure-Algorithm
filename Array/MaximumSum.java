package com.dsaAtoZ.Array;

// Given an integer array , find the subArray with the largest sum, and return its sum.
// Kadane's Algorithm | Maximum SubArray Sum
// https://leetcode.com/problems/maximum-subarray/description/
public class MaximumSum {

    public static void main(String[] args) {
        int[] arr = {5,4,-1,7,8};
        System.out.println("Maximum sum is :: " +maxSubArray(arr));
    }

    public static int maxSubArray(int[] nums) {
        int maximum = Integer.MIN_VALUE;
        int sum = 0;
        for (int i =0; i<nums.length; i++){
            sum += nums[i];

            if (sum > maximum){
                maximum = sum;
            }

            if (sum < 0){
                sum = 0;
            }
        }
        return maximum;
    }


    // Additional Problem to print subArray of maximum sum
    public static int maxSumAndPrintSubArray(int[] nums) {
        int maximum = Integer.MIN_VALUE;
        int sum = 0;
        int start = 0;
        int end = 0;
        for (int i =0; i<nums.length; i++){
            sum += nums[i];

            if (sum > maximum){
                maximum = sum;
                end = i;
            }

            if (sum < 0){
                sum = 0;
                start = i+1;
            }
        }

        for (int i = start; i <= end; i++){
            System.out.print(nums[i] + " ");
        }

        return maximum;
    }
}
