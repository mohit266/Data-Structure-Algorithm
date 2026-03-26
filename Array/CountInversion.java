package com.dsa.Array;

import java.util.ArrayList;
import java.util.List;

public class CountInversion {
    public static void main(String[] args) {
        int[] arr = {2, 3, 7, 1, 3, 5};
        System.out.println(numberOfInversions(arr));
    }

    public static long numberOfInversions(int[] nums) {
        return divideAndMergeSort(nums, 0, nums.length-1);
    }

    private static int divideAndMergeSort(int[] nums, int low, int high){
        int cnt = 0;
        if (low >= high) return cnt;
        int mid = (low + high) / 2;
        cnt += divideAndMergeSort(nums, low, mid);
        cnt += divideAndMergeSort(nums, mid + 1, high);
        cnt += merge(nums, low, mid, high);
        return cnt;
    }

    private static int merge(int[] arr, int low, int mid, int high){

        List<Integer> ls = new ArrayList<>();
        int left = low;
        int right = mid + 1;
        int cnt = 0;

        while (left <= mid && right <= high){

            if (arr[left] <= arr[right]){
                ls.add(arr[left]);
                left++;
            }  else {
                cnt += (mid - left + 1);
                ls.add(arr[right]);
                right++;
            }
        }

        while (left <= mid){
            ls.add(arr[left]);
            left++;
        }

        while (right <= high){
            ls.add(arr[right]);
            right++;
        }

        for (int i = low; i<= high; i++){
            arr[i] = ls.get(i-low);
        }
        return cnt;
    }
}
