package com.dsa.BinarySearch;

public class FindMinimumInRotatedSortedArray {
    public static void main(String[] args) {
        int[] arr = {3,1,2};

        System.out.println(findMin(arr));
    }

    public static int findMin(int[] nums) {
        int low = 0;
        int high = nums.length - 1;

        int min = Integer.MAX_VALUE;

        while (low <= high){
            int mid = (low+high)/2;

            if (nums[low] <= nums[mid]){
                min = Math.min(min, nums[low]);
                low = mid + 1;
            } else {
                high = mid -1;
                min = Math.min(min, nums[mid]);
            }
        }
        return min;
    }
}
