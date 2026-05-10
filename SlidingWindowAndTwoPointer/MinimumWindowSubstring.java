package com.dsa.SlidingWindowAndTwoPointer;

import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubstring {
    public static void main(String[] args) {
        String s = "ADOBECODEBANC";
        String t = "ABC";

        System.out.println(minWindow(s, t));
    }

    public static String minWindow(String s, String t) {

        int minLen = Integer.MAX_VALUE;

        int startIndex = -1;

        int[] hash = new int[256];

        for (char c : t.toCharArray()) {
            hash[c]++;
        }

        int count = 0;

        int left = 0, right = 0;

        while (right < s.length()) {

            if (hash[s.charAt(right)] > 0) {
                count++;
            }
            hash[s.charAt(right)]--;

            while (count == t.length()) {

                if (right - left + 1 < minLen) {
                    minLen = right - left + 1;
                    startIndex = left;
                }

                hash[s.charAt(left)]++;
                if (hash[s.charAt(left)] > 0) {
                    count--;
                }
                left++;
            }
            right++;
        }

        return (startIndex == -1) ? "" : s.substring(startIndex, startIndex + minLen);
    }

}
