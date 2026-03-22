package com.dsa.Array;

import java.util.Arrays;

// https://leetcode.com/problems/next-permutation/description/
public class NextPermutation {
    public static void main(String[] args) {
        int[] arr = {2, 1 , 5, 4, 3, 0, 0};
        nextPermutationValue(arr);

        System.out.println(Arrays.toString(arr));
    }

    public static void nextPermutationValue(int[] nums){
        int n = nums.length;
        int index = -1;

        for (int i = n-2; i>=0; i--){
            if (nums[i] < nums[i+1]){
                index = i;
                break;
            }
        }

        int k = n-1;
        if (index == -1){
            for (int i = 0; i < k; i++){
                swap(nums, i, k);
                k--;
            }
            return;
        }

        for (int i = n-1; i>= index+1; i--){
            if (nums[i] > nums[index]){
                swap(nums, i, index);
                break;
            }
        }

        int j = n-1;
        for (int i = index+1; i < j; i++){
            swap(nums, i, j);
            j--;
        }
    }

    public static void swap(int[] arr, int a, int b){
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}
