package com.dsa.SlidingWindowAndTwoPointer;

import java.util.HashMap;
import java.util.Map;

public class SubArrayWithKDifferentIntegers {
    public static void main(String[] args) {
        int[] nums = {1,1,1,1};
        int k = 1;

        System.out.println(subarraysWithKDistinct(nums, k));

    }

    private static int subarraysWithKDistinct(int[] nums, int k) {
        return numSubArraysWithSumLessEqualToGoal(nums, k) - numSubArraysWithSumLessEqualToGoal(nums, k - 1);
    }

    public static int numSubArraysWithSumLessEqualToGoal(int[] nums, int k) {
        int left = 0;
        int right = 0;

        int n = nums.length;

        int count = 0;

        Map<Integer, Integer> mp = new HashMap<>();

        while (right < n){
            mp.put(nums[right], mp.getOrDefault(nums[right], 0) + 1);

            while (mp.size() > k){
                mp.put(nums[left], mp.get(nums[left]) - 1);

                if (mp.get(nums[left]) == 0){
                    mp.remove(nums[left]);
                }
                left++;
            }
            count += (right - left + 1);

            right++;
        }
        return count;
    }
}
