package com.dsa.BinarySearch;

import java.util.Arrays;

public class SplitArrayLargestSum {
    public static void main(String[] args) {
        int[] nums = {7,2,5,10,8};
        int k = 2;

        System.out.println(splitArray(nums, k));

    }

    public static int splitArray(int[] nums, int k) {
        int low = Arrays.stream(nums).max().getAsInt();
        int high = Arrays.stream(nums).sum();

        while (low <= high){
            int mid = (low+high)/2;
            if (canSplit(nums, k, mid)){
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

    public static boolean canSplit(int[] nums, int k, int mid){
        int sum = 0;
        int countSubArray = 1;

        for (int n : nums){
            if (sum+n <= mid){
                sum += n;
            } else {
                sum = n;
                countSubArray++;
            }
        }
        return countSubArray <= k;
    }
}
