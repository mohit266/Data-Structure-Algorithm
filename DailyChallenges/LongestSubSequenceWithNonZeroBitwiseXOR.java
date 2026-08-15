package com.dsa.DailyChallenges;

// 3702. Longest Subsequence With Non-Zero Bitwise XOR
public class LongestSubSequenceWithNonZeroBitwiseXOR {

    public static void main(String[] args) {

        LongestSubSequenceWithNonZeroBitwiseXOR l = new LongestSubSequenceWithNonZeroBitwiseXOR();

        int[] nums = {1, 2, 3};
        System.out.println(l.longestSubsequence(nums));
    }

    public int longestSubsequence(int[] nums) {
        int xor = 0;
        boolean nonZero = false;

        for (int num : nums) {
            xor ^= num;

            if (num != 0) {
                nonZero = true;
            }
        }

        if (xor != 0) {
            return nums.length;
        }

        if (nonZero) {
            return nums.length - 1;
        }

        return 0;
    }


}
