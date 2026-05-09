package com.dsa.SlidingWindowAndTwoPointer;

public class MaxConsecutiveOnesIII {
    public static void main(String[] args) {
        int[] arr = {0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1};
        int k = 3;

        System.out.println(longestOnes(arr, k));

    }

    public static int longestOnes(int[] nums, int k) {
        int left = 0;
        int right = 0;
        int n = nums.length;

        int sum = 0;
        int maxSum = 0;

        while (right < n){

            while (nums[right] == 0 && k < 1){
                sum -= 1;
                if (nums[left] == 0){
                    k++;
                }
                left++;
            }

            if (nums[right] == 1){
                sum += 1;
            } else if (nums[right] == 0 && k > 0) {
                sum += 1;
                k--;
            }

            maxSum = Math.max(maxSum, sum);

            right++;
        }
        return maxSum;
    }

    public static int longestOnesOptimalSol(int[] nums, int k) {
        int left = 0;
        int right = 0;
        int n = nums.length;

        int maxSum = 0;

        while (right < n){

            if (nums[right] == 0){
                k--;
            }

            if (k < 0){
                if (nums[left] == 0){
                    k++;
                }
                left++;
            }

            maxSum = Math.max(maxSum, (right - left + 1));

            right++;
        }
        return maxSum;
    }
}
