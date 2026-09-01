package com.dsa.PatternWise.BinarySearch;

// 153. Find Minimum in Rotated Sorted Array
public class FindMinimumInRotatedSortedArray {
    public static void main(String[] args) {
        FindMinimumInRotatedSortedArray f = new FindMinimumInRotatedSortedArray();

        int[] arr = {3,1,2};

        System.out.println(f.findMin(arr));
    }

    public int findMin(int[] nums) {
        int low = 0;
        int high = nums.length - 1;

        int ans = -1;

        while (low <= high){
            int mid = low + (high - low)/2;

            if (nums[mid] > nums[nums.length - 1]){
                low = mid + 1;
            } else {
                ans = nums[mid];
                high = mid-1;
            }
        }
        return ans;
    }
}
