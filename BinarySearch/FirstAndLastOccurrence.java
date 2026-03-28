package com.dsa.BinarySearch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FirstAndLastOccurrence {
    public static void main(String[] args) {
        int[] arr = {5, 7, 7, 8, 8, 10};
        int target = 8;

        System.out.println(Arrays.toString(searchRange(arr, target)));
    }

    public static int[] searchRange(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;

        int firstOccurrence = -1;
        int lastOccurrence = -1;


        while (low <= high){
            int mid = (low+high)/2;

            if (nums[mid] == target){
                firstOccurrence = mid;
                high = mid - 1;
            } else if (nums[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        low = 0;
        high = nums.length-1;

        while (low <= high){
            int mid = (low+high)/2;

            if (nums[mid] == target){
                lastOccurrence = mid;
                low = mid + 1;
            } else if (nums[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return new int[] {firstOccurrence, lastOccurrence};
    }
}
