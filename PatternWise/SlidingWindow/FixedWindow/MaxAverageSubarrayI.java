package com.dsa.PatternWise.SlidingWindow.FixedWindow;

// 643. Maximum Average Subarray I
public class MaxAverageSubarrayI {
    public static void main(String[] args) {

        MaxAverageSubarrayI m = new MaxAverageSubarrayI();

        int[] nums = {1,12,-5,-6,50,3};
        int k = 4;

        System.out.println(m.findMaxAverage(nums, k));

    }

    public double findMaxAverage(int[] nums, int k) {
        int n = nums.length;

        int sum = 0;
        int maxSum = 0;

        int j = 0;
        while (j < k){
            sum += nums[j];
            j++;
        }

        maxSum = sum;

        int i = 0;
        while (j < n){
            sum = sum + nums[j];
            sum = sum - nums[i];
            maxSum = Math.max(maxSum, sum);
            j++;
            i++;
        }
        return (double) maxSum / k;
    }
}
