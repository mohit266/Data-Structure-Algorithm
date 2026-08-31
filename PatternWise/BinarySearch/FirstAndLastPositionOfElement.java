package com.dsa.PatternWise.BinarySearch;

import java.util.Arrays;

// 34. Find First and Last Position of Element in Sorted Array
public class FirstAndLastPositionOfElement {

    public static void main(String[] args) {

        FirstAndLastPositionOfElement f = new FirstAndLastPositionOfElement();

        int[] nums = {5,7,7,8,8,10};
        int target = 8;

        System.out.println(Arrays.toString(f.searchRange(nums, target)));
    }

    public int[] searchRange(int[] nums, int target) {
        return new int[] {lowerBound(nums, target), upperBound(nums, target)};
    }

    public int lowerBound(int[] nums, int target){

        int low = 0;
        int high = nums.length - 1;

        int ans = -1;

        while (low <= high){
            int mid = low + (high - low)/2;

            if (nums[mid] >= target){
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return ans;
    }

    public int upperBound(int[] nums, int target){

        int low = 0;
        int high = nums.length - 1;

        int ans = -1;

        while (low <= high){
            int mid = low + (high - low)/2;

            if (nums[mid] <= target){
                ans = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return ans;
    }

}
