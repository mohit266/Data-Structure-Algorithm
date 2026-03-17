package com.dsaAtoZ.Array;

import java.util.Arrays;

public class RotateArray {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7};
        // We need to rotate the array to right by k steps.
        int k = 3;
        rotate(arr, k);
        System.out.println(Arrays.toString(arr));
//        System.out.println("Rotated array : " + Arrays.toString(getRotatedArray(arr, k)));


    }

    public static void rotate(int[] nums, int k) {
        int n = nums.length;
        k = k % n;

        reverse(nums, 0, n - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, n - 1);
    }

    private static void reverse(int[] nums, int l, int r) {
        // {1,2,3,4,5,6,7}
        while (l < r) {
            int temp = nums[l];
            nums[l] = nums[r];
            nums[r] = temp;
            l++;
            r--;
        }
    }

    public static int[] getRotatedArray(int[] arr, int n){
        int size = arr.length;
        int f = n%size;
        while (f >= 1){
            int lastIndexVal = arr[size-1];
            int j = size - 1;
            for (int i =0; i<= arr.length-2; i++){
                arr[j-i] = arr[j-i-1];
            }
            arr[0] = lastIndexVal;
            f--;
        }
        return arr;
    }
}
