package com.dsa.SlidingWindowAndTwoPointer;

public class BinarySubArraysWithSum {
    public static void main(String[] args) {
        int[]  nums = {1,0,1,0,1};
        int goal = 2;

        System.out.println(numSubArraysWithSum(nums, goal));
    }

    public static int numSubArraysWithSum(int[] nums, int goal) {
        return numSubArraysWithSumLessEqualToGoal(nums, goal) - numSubArraysWithSumLessEqualToGoal(nums, goal-1);
    }

    private static int numSubArraysWithSumLessEqualToGoal(int[] nums, int goal) {

        if (goal < 0) return 0;

        int l = 0, r = 0;

        int sum = 0;

        int count = 0;

        while (r < nums.length) {
            sum += nums[r];

            while (sum > goal) {
                sum -= nums[l];
                l++;
            }
            count += (r - l + 1);

            r++;
        }
        return count;
    }
}
