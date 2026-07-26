package com.dsa.PatternWise.PrefixSum;

import java.util.HashMap;
import java.util.Map;

public class ContinuousSubArraySum {

    public static void main(String[] args) {
        ContinuousSubArraySum c = new ContinuousSubArraySum();

        int[] nums = {2, 4, 3};
        int k = 6;

        System.out.println(c.checkSubarraySum(nums, k));
    }

    public boolean checkSubarraySum(int[] nums, int k) {

        Map<Integer,Integer> mp = new HashMap<>();
        mp.put(0, -1);

        int prefixSum = 0;

        for (int i = 0; i < nums.length; i++) {

            prefixSum += nums[i];

            int rem = prefixSum % k;

            if (rem < 0) {
                rem += k;
            }

            if (mp.containsKey(rem)) {
                int prevIndex = mp.get(rem);

                if (i - prevIndex >= 2) {
                    return true;
                }
            } else {
                mp.put(rem, i);
            }
        }

        return false;
    }

}
