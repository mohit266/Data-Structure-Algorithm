package com.dsaAtoZ.Array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {

    public static void main(String[] args) {
        int [] arr = {1, 3, 5, -7, 6, -3};
        int target = 0;
        System.out.println(Arrays.toString(twoSum(arr, target)));
        System.out.println(Arrays.toString(twoSumBetterApproach(arr, target)));
    }

    // Better Approach | Time Complexity - O(nlogN)
    public static int[] twoSumBetterApproach(int[] nums, int target) {
        Map<Integer, Integer> mpp = new HashMap<>();
        int remainingVal;
        for (int i=0; i<nums.length; i++){
            remainingVal = target - nums[i];
            if (mpp.containsKey(remainingVal)){
                return new int[] {mpp.get(remainingVal), i};
            }
            mpp.put(nums[i], i);
        }
        return new int[]{-1};
    }


    // Brute Force Approach | Time Complexity - O(N2)
    public static int[] twoSum(int[] nums, int target) {

        for (int i = 0; i < nums.length; i++){
            for (int j = i+1; j < nums.length; j++){
                if (nums[i] + nums[j] == target){
                    return new int[] {i,j};
                }
            }
        }
        return new int[] {0};
    }


}
