package com.dsa.PatternWise.PrefixSum;

import java.util.HashMap;
import java.util.Map;

public class CountNumberOfNiceSubArray {

    public static void main(String[] args) {

        CountNumberOfNiceSubArray cnt = new CountNumberOfNiceSubArray();

        int[] nums = {1,1,2,1,1};
        int k = 3;

        System.out.println(cnt.numberOfSubarrays(nums, k));
    }

    public int numberOfSubarrays(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();

        map.put(0, 1);

        int prefixSum = 0;
        int count = 0;

        for (int num : nums) {
            // Count odd number as 1 and even 0
            prefixSum += (num % 2);

            int target = prefixSum - k;

            if (map.containsKey(target)) {
                count += map.get(target);
            }

            map.put(prefixSum, map.getOrDefault(prefixSum, 0) + 1);
        }

        return count;
    }

}
