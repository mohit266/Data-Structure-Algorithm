package com.dsa.DailyChallenges;

import java.util.HashMap;
import java.util.Map;

public class CountSubArrayWithMajorityElementII {

    public static void main(String[] args) {
        int[] nums = {1,2,2,3};
        int target = 2;

        CountSubArrayWithMajorityElementII c = new CountSubArrayWithMajorityElementII();
        System.out.println(c.countMajoritySubarrays(nums, target));
    }

    public long countMajoritySubarrays(int[] nums, int target) {
        int n = nums.length;

        long[] freq = new long[2 * n + 1];
        long[] prefixFreq = new long[2 * n + 1];

        int idx = n;

        freq[idx] = 1;
        prefixFreq[idx] = 1;

        long ans = 0;

        for (int num : nums) {

            if (num == target){
                idx++;
            } else {
                idx--;
            }

            freq[idx]++;
            ans += prefixFreq[idx - 1];

            prefixFreq[idx] = prefixFreq[idx - 1] + freq[idx];
        }

        return ans;
    }
}
