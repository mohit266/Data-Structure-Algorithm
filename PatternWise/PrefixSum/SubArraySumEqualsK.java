package com.dsa.PatternWise.PrefixSum;

import java.util.HashMap;

// 560. Subarray Sum Equals K
public class SubArraySumEqualsK {
    public static void main(String[] args) {

        SubArraySumEqualsK s = new SubArraySumEqualsK();

        int[] nums = {1, -1, 0, 1, 2, -1, 3};
        int k = 3;

        System.out.println(s.subarraySum(nums, k));

    }

    public int subarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> mp = new HashMap<>();
        mp.put(0, 1);

        int count = 0;
        int prefixSum = 0;

        for (int num : nums){
            prefixSum += num;

            int target = prefixSum - k;

            if (mp.containsKey(target)){
                count = count + mp.get(target);
            }
            mp.put(prefixSum, mp.getOrDefault(prefixSum, 0) + 1);
        }
        return count;
    }
}
