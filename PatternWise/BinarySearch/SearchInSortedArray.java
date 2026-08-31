package com.dsa.PatternWise.BinarySearch;

// 704. Binary Search
public class SearchInSortedArray {
    public static void main(String[] args) {

        SearchInSortedArray s = new SearchInSortedArray();

        int[] arr = {-1,0,3,5,9,12};
        int target = 9;
        System.out.println(s.search(arr, target));
    }

    public int search(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;

        while (low <= high){
            int mid = (low + high) / 2;

            if (nums[mid] == target){
                return mid;
            } else if (nums[mid] < target){
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return -1;
    }

}
