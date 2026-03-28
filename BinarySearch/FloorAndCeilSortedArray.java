package com.dsa.BinarySearch;

import java.util.Arrays;

public class FloorAndCeilSortedArray {
    public static void main(String[] args) {
        int[] arr = {3, 4, 4, 7, 8, 10};
        int x = 8;

        System.out.println(Arrays.toString(getFloorAndCeil(arr, x)));

    }

    public static int[] getFloorAndCeil(int[] nums, int x) {
        int left = 0;
        int right = nums.length-1;
        int floor = -1;
        int ceil = -1;

        while (left <= right){
            int mid = (left + right)/2;
            if (nums[mid] == x){
              floor = nums[mid];
              ceil = nums[mid];
              break;
            } else if (nums[mid] < x){
                left = mid + 1;
                floor = nums[mid];
            } else {
                right = mid - 1;
                ceil = nums[mid];
            }
        }
        return new int[] {floor,ceil};
    }
}
