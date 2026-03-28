package com.dsa.BinarySearch;

public class SearchInsertOperation {
    public static void main(String[] args) {
        int[] arr = {1, 3, 5, 6};
        int target = 7;

        System.out.println(searchInsert(arr, target));
    }

    public static int searchInsert(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        int searchIndex = nums.length;

        while (low <= high){
            int mid = (low + high)/2;

            if (nums[mid] == target){
                return mid;
            } else if (nums[mid] > target){
                searchIndex = mid;
                high = mid - 1;
            } else {
                searchIndex = mid + 1;
                low = mid + 1;
            }
        }
        return searchIndex;
    }

}
