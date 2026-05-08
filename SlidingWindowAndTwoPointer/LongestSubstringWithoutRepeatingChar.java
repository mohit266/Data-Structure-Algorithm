package com.dsa.SlidingWindowAndTwoPointer;

import java.util.HashMap;

public class LongestSubstringWithoutRepeatingChar {
    public static void main(String[] args) {

        String s = "abcabcbb";
        System.out.println(lengthOfLongestSubstring(s));
    }

    public static int lengthOfLongestSubstring(String s) {

        HashMap<Character, Integer> mp = new HashMap<>();

        char[] arr = s.toCharArray();

        int left = 0;
        int right = 0;

        int maxLength = 0;

        while (right < s.length()){

            char c = arr[right];

            while (mp.containsKey(c)){
                mp.remove(arr[left]);
                left++;
            }

            mp.put(c, right);

            maxLength = Math.max(maxLength, mp.size());
            right++;
        }

        return maxLength;
    }
}
