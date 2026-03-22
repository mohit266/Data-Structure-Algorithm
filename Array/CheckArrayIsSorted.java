package com.dsaAtoZ.Array;

// https://leetcode.com/problems/check-if-array-is-sorted-and-rotated/description/
public class CheckArrayIsSorted {
    public static void main(String[] args) {
        int[] arr = {3,4,5,1,2};

        System.out.println(check(arr));
        System.out.println(isArraySorted(arr, arr.length));
    }

    // Output: true
    // Explanation: [1,2,3,4,5] is the original sorted array.
    // You can rotate the array by x = 2 positions to begin on the element of value 3: [3,4,5,1,2].
    public static boolean check(int[] nums) {
        int count = 0;
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            if (nums[i] > nums[(i + 1) % n]) {
                count++;
            }
            if (count > 1) {
                return false;
            }
        }

        return true;
    }

    // This method will fail for rotated array.
    public static boolean isArraySorted(int[]arr, int n){
        for (int i = 1; i < n; i++){
            if (arr[i] >= arr[i-1]){
                continue;
            } else {
                return false;
            }
        }
        return true;
    }



}
