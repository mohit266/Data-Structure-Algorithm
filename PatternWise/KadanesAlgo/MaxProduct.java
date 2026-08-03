package com.dsa.PatternWise.KadanesAlgo;

// 152. Maximum Product Subarray
public class MaxProduct {

    public static void main(String[] args) {
        MaxProduct m = new MaxProduct();

        int[] nums = {-2, 3, -4};
        System.out.println(m.maxProd(nums));
    }

    public int maxProd(int[] nums){

        int maxEnding = nums[0];
        int minEnding = nums[0];
        int ans = nums[0];

        for (int i = 1; i < nums.length; i++){
            int v1 = nums[i];
            int v2 = minEnding * v1;
            int v3 = maxEnding * v1;

            minEnding = Math.min(v1, Math.min(v2, v3));
            maxEnding = Math.max(v1, Math.max(v2, v3));

            ans = Math.max(ans, maxEnding);
        }
        return ans;
    }

}
