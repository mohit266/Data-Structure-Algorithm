package com.dsa.BinarySearch;

public class UpperBound {
    public static void main(String[] args) {
        int[] arr = {1,2,2,3};
        int k = 2;
        System.out.println(upperBound(arr, k));
    }

    public static int upperBound(int[] nums, int x) {
        int low = 0;
        int high = nums.length-1;
        int upperBoundIndex = nums.length;

        while(low <= high){
            int mid = (low+high)/2;
            if (nums[mid] <= x){
                low = mid+1;
            } else {
                upperBoundIndex = mid;
                high = mid - 1;
            }
        }
        return upperBoundIndex;
    }
}
