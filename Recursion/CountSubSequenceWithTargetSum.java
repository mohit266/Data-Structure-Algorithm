package com.dsa.Recursion;

public class CountSubSequenceWithTargetSum {
    public static void main(String[] args) {
        int[] nums = {4, 9, 2, 5, 1};
        int k = 10;

        System.out.println(countSubsequenceWithTargetSum(nums, k));
    }

    public static int countSubsequenceWithTargetSum(int[] nums, int k) {
        return countSubSeq(0, nums, k);
    }

    private static int countSubSeq(int i, int[] nums, int k) {
        if (k == 0){
            return 1;
        }
        if (i == nums.length || k < 0){
            return 0;
        }

        return countSubSeq(i + 1, nums, k - nums[i]) + countSubSeq(i + 1, nums, k);
    }
}
