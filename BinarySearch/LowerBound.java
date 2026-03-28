package com.dsa.BinarySearch;

public class LowerBound {
    public static void main(String[] args) {
        int[] arr = {3,5,8,15,19};
        int x = 9;
        System.out.println(lowerBound(arr, x));
    }

    public static int lowerBound(int[] nums, int x) {
        int n = nums.length;
        int low = 0;
        int high = n-1;

        int minIndex = n;

        while (low <= high){
            int mid = (low + high)/2;
            if (nums[mid] >= x){
                minIndex = mid;
                high = mid-1;
            } else {
                low = mid + 1;
            }
        }
        return minIndex;
    }
}
