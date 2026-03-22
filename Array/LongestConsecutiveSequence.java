package com.dsa.Array;

import java.util.HashSet;

public class LongestConsecutiveSequence {
    public static void main(String[] args) {
        int [] arr = {100, 4, 200, 1, 3, 2};
        System.out.println(longestConsecutive(arr));
    }

    public static int longestConsecutive(int[] nums) {

        int n = nums.length;

        if (n == 0) return 0;

        int longest = 1;

        HashSet<Integer> hashSet = new HashSet<>();
        int count = 0;
        for (int num : nums){
            hashSet.add(num);
        }

        for (int val : hashSet){
            if (!hashSet.contains(val-1)){
                count = 1;

                int currentNum = val;

                while(hashSet.contains(currentNum+1)){
                    currentNum += 1;
                    count += 1;
                }
                longest = Math.max(longest, count);
            }
        }
        return longest;
    }
}
