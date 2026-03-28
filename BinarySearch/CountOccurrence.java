package com.dsa.BinarySearch;

public class CountOccurrence {
    public static void main(String[] args) {
        int[]arr = {5, 5, 5, 5, 5, 5};
        int target = 5;

        System.out.println(countOccurrences(arr, target));
    }

    public static int countOccurrences(int[] nums, int target) {
        int[] arr = searchRange(nums, target);
        if (arr[0] == -1) return 0;
        return arr[1] - arr[0] + 1;
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
