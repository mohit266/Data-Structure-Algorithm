package com.dsa.Array;

import java.util.Arrays;

// https://leetcode.com/problems/sort-colors/submissions/1952631980/
// Dutch National Flag Algorithm
public class SortArrayWithZeroOneAndTwo {
    public static void main(String[] args) {
        int[] arr = {2,0,1};
        sortColors(arr);
        System.out.println(Arrays.toString(arr));
    }
    public static void sortColors(int[] nums) {
        int low = 0;
        int mid = 0;
        int high = nums.length-1;

        while (mid <= high){
            if (nums[mid] == 0){
                swap(nums,mid,low);
                mid++;
                low++;
            } else if (nums[mid] == 1){
                mid++;
            } else {
                swap(nums, mid, high);
                high--;
            }
        }
    }

    public static void swap(int[] arr, int a, int b){
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}
