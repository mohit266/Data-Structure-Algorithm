package com.dsaAtoZ.Sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeSort {
    public static void main(String[] args) {
        int[] arr = {3, 1, 2, 4, 1, 5, 6, 2, 4};
        divideAndMerge(arr, 0, arr.length-1);
        System.out.println("Sorted Array :: "+ Arrays.toString(arr));
    }

    public static void divideAndMerge(int[] arr, int low, int high){
        if (low >= high){
            return;
        }
        int mid = (low + high)/2;
        divideAndMerge(arr, low, mid);
        divideAndMerge(arr,mid+1, high);
        merge(arr, low, mid, high);
    }

    public static void merge(int[] arr, int low, int mid, int high){
        List<Integer> temp = new ArrayList<>();
        int left = low;
        int right = mid + 1;

        while (left <= mid && right <= high){
            if (arr[left] <= arr[right]){
                temp.add(arr[left]);
                left++;
            } else {
                temp.add(arr[right]);
                right++;
            }
        }

        while (left <= mid){
            temp.add(arr[left]);
            left++;
        }

        while (right <= high){
            temp.add(arr[right]);
            right++;
        }

        for (int i = low; i<= high; i++){
            arr[i] = temp.get(i-low);
        }
    }
}
