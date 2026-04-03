package com.dsa.BinarySearch;

import java.util.Arrays;

public class AggressiveCows {
    public static void main(String[] args) {
        int[] arr = {4, 2, 1, 3, 6};
        int numOfCows = 2;

        System.out.println(aggressiveCows(arr, numOfCows));
    }

    public static int aggressiveCows(int[] nums, int k) {
        Arrays.sort(nums);

        int low = 0;
        int high = getMaxElement(nums);

        while (low <= high){
            int mid = (low+high)/2;

            if (canWePlaceCows(nums, mid, k)){
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return high;
    }

    public static boolean canWePlaceCows(int[] nums, int dis, int cows){
        int lastCow = nums[0];
        int countCow = 1;

        for (int i = 1; i <nums.length; i++){
            if ((nums[i] - lastCow) >= dis){
                lastCow = nums[i];
                countCow++;
            }
            if (countCow >= cows){
                return true;
            }
        }
        return false;
    }


    public static int getMaxElement(int[] nums){
        int max = Integer.MIN_VALUE;

        for (int n : nums){
            max = Math.max(max,n);
        }
        return max;
    }
}
