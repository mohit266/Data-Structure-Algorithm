package com.dsa.SlidingWindowAndTwoPointer;

import java.util.HashMap;

public class LongestRepeatingCharacterReplacement {
    public static void main(String[] args) {
        String s = "BAABAABBBAAA";
        int k = 2;

        System.out.println(characterReplacement(s, k));
    }

    public static int characterReplacement(String s, int k) {
        int left = 0;
        int right = 0;

        int maxFreq = 0;
        int maxLen = 0;

        int[] hash = new int[26];

        while (right < s.length()){
            hash[s.charAt(right) - 'A']++;

            maxFreq = Math.max(maxFreq, hash[s.charAt(right) - 'A']);

            if ((right - left + 1) - maxFreq > k){
                hash[s.charAt(left) - 'A']--;
                left++;
            }

            maxLen = Math.max(maxLen, right - left + 1);
            right++;
        }
        return maxLen;
    }
}
