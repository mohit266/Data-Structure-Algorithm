package com.dsa.Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ReversePairs {

    public static void main(String[] args) {
        int[] arr = {2,4,3,5,1};
        System.out.println(mergeSort(arr, 0, arr.length-1));
        System.out.println(Arrays.toString(arr));
    }

    private static int mergeSort(int[] nums, int low, int high){
        int count = 0;
        if (low >= high) return count;
        int mid = (low+ high)/2;
        count += mergeSort(nums, low, mid);
        count += mergeSort(nums, mid+1, high);
        count += reversePairs(nums, low, mid, high);
        merge(nums, low, mid, high);
        return count;
    }


    private static int reversePairs(int[] nums, int low, int mid, int high){
        int left = low;
        int right = mid+1;

        int count = 0;
        while (left <= mid && right <= high){

            if (nums[right] * 2 < nums[left]){
                count = count + (mid - left + 1);
                right++;
            } else {
                left++;
            }
        }
        return count;
    }

    private static void merge(int[] nums, int low, int mid, int high) {
        int left = low;
        int right = mid + 1;

        List<Integer> ls = new ArrayList<>();

        while (left <= mid && right <= high){
            if (nums[left] <= nums[right]){
                ls.add(nums[left]);
                left++;
            } else {
                ls.add(nums[right]);
                right++;
            }
        }

        while (left <= mid){
            ls.add(nums[left]);
            left++;
        }

        while (right <= high){
            ls.add(nums[right]);
            right++;
        }

        for (int i = low; i <= high; i++){
            nums[i] = ls.get(i-low);
        }
    }
}