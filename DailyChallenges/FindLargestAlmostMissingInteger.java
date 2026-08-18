package com.dsa.DailyChallenges;

import java.util.HashSet;
import java.util.Set;

public class FindLargestAlmostMissingInteger {

    public static void main(String[] args) {
        int[] nums = {3,9,2,1,7};
        int k = 3;

        FindLargestAlmostMissingInteger f = new FindLargestAlmostMissingInteger();
        System.out.println(f.largestInteger(nums, k));
    }

    public int largestInteger(int[] nums, int k) {

        int[] freq = new int[51];

        for(int i = 0; i <= nums.length - k; i++) {
            Set<Integer> set = new HashSet<>();

            for(int j = i; j < i + k; j++) {
                set.add(nums[j]);
            }

            for(int key : set) {
                freq[key]++;
            }
        }

        for(int i = 50; i >= 0; i--) {
            if(freq[i] == 1) {
                return i;
            }
        }
        return -1;
    }

}
