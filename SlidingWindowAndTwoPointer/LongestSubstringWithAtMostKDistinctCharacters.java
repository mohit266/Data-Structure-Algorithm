package com.dsa.SlidingWindowAndTwoPointer;

import java.util.HashMap;

public class LongestSubstringWithAtMostKDistinctCharacters {
    public static void main(String[] args) {
        String s = "abcddefg";
        int k = 3;

        System.out.println(kDistinctChar(s, k));
    }

    public static int kDistinctChar(String s, int k) {
        int left = 0;
        int right = 0;
        int n = s.length();

        int maxLen = 0;

        HashMap<Character, Integer> mp = new HashMap<>();

        while (right< n){

            char c = s.charAt(right);
            mp.put(c, mp.getOrDefault(c, 0) + 1);

            if (mp.size() > k){
                char l = s.charAt(left);
                mp.put(l, mp.get(l) - 1);

                if (mp.get(l) == 0){
                    mp.remove(l);
                }
                left++;
            }

            if (mp.size() <= k){
                maxLen = Math.max(maxLen, right - left + 1);
            }
            right++;
        }
        return maxLen;
    }
}
