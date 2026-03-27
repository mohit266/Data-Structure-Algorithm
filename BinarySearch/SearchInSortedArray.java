package com.dsa.BinarySearch;

public class SearchInSortedArray {
    public static void main(String[] args) {
        int[] arr = {-1,0,3,5,9,12};
        int target = 9;
        System.out.println(search(arr, target));
        System.out.println(binarySearch(arr, target));
    }

    // optimal approach
    public static int binarySearch(int[] nums, int target) {
        int n = nums.length;
        int low = 0, high = n - 1;

        while (low <= high) {
            int mid = (low + high) / 2;
            if (nums[mid] == target) return mid;
            else if (target > nums[mid]) low = mid + 1;
            else high = mid - 1;
        }
        return -1;
    }

    public static int search(int[] nums, int target) {
        int mid = nums.length /2;
        int left = 0;
        int right = nums.length;

        if (target == nums[mid]){
            return mid;
        } else if (target < nums[mid]) {
            right = mid;
        } else {
            left = mid + 1;
        }

        for (int i = left; i < right; i++){
            if (nums[i] == target){
                return i;
            }
        }
        return -1;
    }

}
