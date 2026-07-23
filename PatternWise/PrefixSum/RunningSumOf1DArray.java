package com.dsa.PatternWise.PrefixSum;

import java.util.Arrays;

// 1480. Running Sum of 1d Array
public class RunningSumOf1DArray {

    public static void main(String[] args) {
        RunningSumOf1DArray rSum = new RunningSumOf1DArray();

        int[] nums = {1, 2, 3, 4};
        System.out.println(Arrays.toString(rSum.runningSum(nums)));
    }

    public int[] runningSum(int[] nums) {
        for (int i = 1; i < nums.length; i++){
            nums[i] = nums[i-1] + nums[i];
        }
        return nums;
    }
}
