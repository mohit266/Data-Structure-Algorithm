package com.dsa.Array;

public class MaximumProductSubArray {
    public static void main(String[] args) {
        int[] arr = {2,3,-2, -2, 4};
        System.out.println(maxProduct(arr));
    }

    public static int maxProduct(int[] nums) {
        int res = nums[0];
        int maxProd = nums[0];
        int minProd = nums[0];

        for (int i = 1; i < nums.length; i++) {
            int curr = nums[i];

            if (curr < 0) {
                int temp = maxProd;
                maxProd = minProd;
                minProd = temp;
            }

            maxProd = Math.max(curr, maxProd * curr);
            minProd = Math.min(curr, minProd * curr);

            res = Math.max(res, maxProd);
        }

        return res;
    }

}
