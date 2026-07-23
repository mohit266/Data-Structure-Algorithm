package com.dsa.PatternWise.PrefixSum;

// 303. Range Sum Query - Immutable
public class RangeSumQuery {

    public static void main(String[] args) {

        int[] nums = {-2, 0, 3, -5, 2, -1};

        RangeSumQuery rangeSumQuery = new RangeSumQuery(nums);

        System.out.println(rangeSumQuery.sumRange(0,2));
        System.out.println(rangeSumQuery.sumRange(2,5));
        System.out.println(rangeSumQuery.sumRange(0,5));
    }

    int[] prefixSum;

    public RangeSumQuery(int[] nums) {
        prefixSum = new int[nums.length];

        prefixSum[0] = nums[0];

        for (int i = 1; i < nums.length; i++){
            prefixSum[i] = prefixSum[i-1] + nums[i];
        }

    }

    public int sumRange(int left, int right) {
        int leftVal;
        if (left <= 0) {
            leftVal = 0;
        } else {
            leftVal = prefixSum[left-1];
        }
        return prefixSum[right] - leftVal;

    }
}
