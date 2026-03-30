package com.dsa.BinarySearch;

public class FindNTimesArrayIsRotated {
    public static void main(String[] args) {
        int[] arr = {4, 5, 6, 7, 0, 1, 2, 3};

        System.out.println(findNRotation(arr));
    }

    public static int findNRotation(int[] nums) {
        int low = 0;
        int high = nums.length - 1;

        int min = Integer.MAX_VALUE;
        int index = 0;

        while (low <= high){
            int mid = (low+high)/2;

            if (nums[low] <= nums[mid]){
                if (nums[low] < min){
                    index = low;
                    min = nums[low];
                }
                low = mid + 1;
            } else {
                high = mid - 1;
                if (nums[mid] < min){
                    index = mid;
                    min = nums[mid];
                }
            }
        }
        return index;
    }
}
