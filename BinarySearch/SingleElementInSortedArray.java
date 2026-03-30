package com.dsa.BinarySearch;

public class SingleElementInSortedArray {
    public static void main(String[] args) {
        int[] nums = {1,1,2};

        System.out.println(singleNonDuplicate(nums));
    }

    public static int singleNonDuplicate(int[] nums) {
        int n = nums.length-1;

        if (nums.length == 1) return nums[0];
        if (nums[0] != nums[1]) return nums[0];
        if (nums[n] != nums[n-1]) return nums[n];

        int low = 1;
        int high = n - 1;

        while (low <= high){
            int mid = (low + high)/2;

            if (nums[mid] != nums[mid-1] && nums[mid] != nums[mid+1]){
                return nums[mid];
            }

            if ((mid % 2 == 1 && nums[mid] == nums[mid-1]) || (mid % 2 == 0 && nums[mid] == nums[mid+1])){
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }
}
