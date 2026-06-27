package com.dsa.DailyChallenges;

import java.util.*;

public class MaximumNoOfElementsInSubset {

    public static void main(String[] args) {
        MaximumNoOfElementsInSubset m = new MaximumNoOfElementsInSubset();
        int [] nums  = {5,4,1,2,2};

        System.out.println(m.maximumLength(nums));
    }

    public int maximumLength(int[] nums) {

        Map<Long, Integer> freq = new HashMap<>();

        for (int num : nums) {
            freq.merge((long) num, 1, Integer::sum);
        }

        int ans = 1;

        if (freq.containsKey(1L)) {
            ans = freq.get(1L);
            if ((ans > 1) && ((ans & 1) == 0)){
                ans -= 1;
            }
        }

        for (long start : freq.keySet()) {

            if (start == 1)
                continue;

            long curr = start;
            int length = 1;

            while (freq.getOrDefault(curr, 0) >= 2) {

                if (curr > 1000000000L)
                    break;

                long next = curr * curr;

                if (!freq.containsKey(next))
                    break;

                length += 2;
                curr = next;
            }

            ans = Math.max(ans, length);
        }

        return ans;
    }
}
