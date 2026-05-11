package com.dsa.SlidingWindowAndTwoPointer;

public class CountNumberOfNiceSubArrays {
    public static void main(String[] args) {
        int[] nums = {2,2,2,1,2,2,1,2,2,2};
        int k = 2;

        System.out.println(numberOfSubarrays(nums, k));

    }

    public static int numberOfSubarrays(int[] nums, int k) {
        int left = 0;
        int right = 0;

        int n = nums.length;
        int prefix = 0;
        int totalSubArrayCount = 0;

        while (right < n){

            if ((nums[right] & 1) != 0){
                k--;
                prefix = 0;
            }

            while (k <= 0){
                prefix++;
                if ((nums[left] & 1) != 0) {
                    k++;
                }
                left++;
            }

            totalSubArrayCount  += prefix;

            right++;
        }
        return totalSubArrayCount;
    }
}
