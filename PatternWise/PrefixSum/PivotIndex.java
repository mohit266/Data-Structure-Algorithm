package com.dsa.PatternWise.PrefixSum;

// 724. Find Pivot Index
public class PivotIndex {

    public static void main(String[] args) {
        PivotIndex p = new PivotIndex();
        int[] nums = {1,7,3,6,5,6};

        System.out.println(p.pivotIndex(nums));
    }

    public int pivotIndex(int[] nums) {
        int n = nums.length;

        int[] prefixSum = new int[n];

        prefixSum[0] = nums[0];
        for (int i = 1; i < n; i++){
            prefixSum[i] = prefixSum[i-1] + nums[i];
        }

        int totalSum = prefixSum[n-1];

        int result = -1;
        for (int i = n - 1; i >= 0; i--){
            int leftMost = 0;

            if (i > 0){
                leftMost = prefixSum[i-1];
            }

            int rightMost = totalSum - prefixSum[i];

            if (rightMost == leftMost){
                result = i;
            }
        }

        return result;
    }

}
