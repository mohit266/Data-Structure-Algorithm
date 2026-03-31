package com.dsa.BinarySearch;

public class FindPeakElement {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5};

        System.out.println(findPeakElement(nums));
    }

    public static int findPeakElement(int[] nums) {
        int low  = 1;
        int n = nums.length;

        int high = n - 2;


        if(nums.length == 1) return 0;
        if (nums[0] > nums[1]) return 0;
        if (nums[n-1] > nums[n-2]) return n-1;

        while (low <= high){
            int mid = (low + high)/2;

            if (nums[mid-1] < nums[mid] && nums[mid] > nums[mid+1]){
                return mid;
            } else if (nums[mid] > nums[mid-1] && nums[mid] < nums[mid+1]){
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }
}
