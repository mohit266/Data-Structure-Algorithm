package com.dsa.BinarySearch;

import java.util.Arrays;

public class BookAllocation {
    public static void main(String[] args) {
        int[] nums = {25, 46, 28, 49, 24};
        int m=4;

        System.out.println(findPages(nums, m));
    }

    public static int findPages(int[] nums, int m) {
        int low = getMin(nums);
        int high = Arrays.stream(nums).sum();

        while (low <= high){
            int mid = (low+high)/2;

            if (canBooksAllocate(nums, mid, m)){
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

    public static boolean canBooksAllocate(int[] nums, int barrier, int students){
        int sum = 0;
        int countStudents = 1;

        for (int pages : nums){
            if (sum + pages > barrier){
                sum = pages;
                countStudents++;
            } else {
                sum += pages;
            }
        }
        return countStudents <= students;
    }

    public static int getMin(int[] arr){
        int min = Integer.MAX_VALUE;

        for (int n : arr){
            min = Math.min(min, n);
        }
        return min;
    }
}
