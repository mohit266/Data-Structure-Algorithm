package com.dsaAtoZ.Array;

public class LongestSubArrayWithKSum {

    public static void main(String[] args) {
        int [] nums = {1, 2, 3, 1, 1, 1, 1, 3, 3};
        int sum = 6;
        System.out.println(getLongestSubArraySize(nums, sum));
    }

    public static int getLongestSubArraySize(int[] nums, int k){
        int n = nums.length;
        int sum = nums[0];
        int length = 0;
        int left =0;
        int right =0;
        while (right < n){

            while (left <= right && sum > k){
                sum -= nums[left];
                left++;
            }

            if (sum == k) {
                if (length < (right-left+1)){
                    length = right-left+1;
                }
            }

            right++;
            if (right < n){
                sum += nums[right];
            }
        }
        return length;
    }
}
