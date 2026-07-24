package com.dsa.PatternWise.PrefixSum;

import java.util.HashMap;

// 930. Binary Subarrays With Sum
public class BinarySubArrayWithSum {

    public static void main(String[] args) {

        BinarySubArrayWithSum b = new BinarySubArrayWithSum();

        int[] nums = {1,0,1,0,1};
        int goal = 2;

        System.out.println(b.numSubarraysWithSum(nums, goal));
    }

    public int numSubarraysWithSum(int[] nums, int goal) {
        HashMap<Integer, Integer> mp = new HashMap<>();
        mp.put(0,1);

        int totalSubArrayCount = 0;
        int prefixSum = 0;
        for (int num : nums){
            prefixSum += num;

            int target = prefixSum - goal;

            if (mp.containsKey(target)){
                totalSubArrayCount += mp.get(target);
            }

            mp.put(prefixSum, mp.getOrDefault(prefixSum, 0) + 1);
        }
        return totalSubArrayCount;
    }

}
