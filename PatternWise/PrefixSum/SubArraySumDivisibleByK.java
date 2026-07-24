package com.dsa.PatternWise.PrefixSum;

import java.util.HashMap;

public class SubArraySumDivisibleByK {

    public static void main(String[] args) {

        SubArraySumDivisibleByK sub = new SubArraySumDivisibleByK();

        int[] nums = {4,5,0,-2,-3,1};
        int k = 5;

        System.out.println(sub.subarraysDivByK(nums, k));
    }

    public int subarraysDivByK(int[] nums, int k) {
        HashMap<Integer, Integer> mp = new HashMap<>();
        mp.put(0,1);

        int totalSubArrayCount = 0;
        int prefixSum = 0;
        for (int num : nums){
            prefixSum += num;

            int rem = prefixSum % k;

            // IMP :: This is used to make negative remainder to positive.
            int target =  (rem + k) % k;

            if (mp.containsKey(target)){
                totalSubArrayCount += mp.get(target);
            }

            mp.put(target, mp.getOrDefault(target, 0) + 1);
        }
        return totalSubArrayCount;
    }

}
