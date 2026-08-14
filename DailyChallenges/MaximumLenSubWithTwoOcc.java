package com.dsa.DailyChallenges;

import java.util.HashMap;

// 3090. Maximum Length Substring With Two Occurrences
public class MaximumLenSubWithTwoOcc {

    public static void main(String[] args) {

        MaximumLenSubWithTwoOcc max = new MaximumLenSubWithTwoOcc();

        String s = "bcbbbcba";
        System.out.println(max.maximumLengthSubstring(s));


    }


    public int maximumLengthSubstring(String s) {

        HashMap<Character, Integer> mp = new HashMap<>();

        int i = 0;
        int j = 0;

        int len = 0;

        while (j < s.length()){
            char ch = s.charAt(j);

            mp.put(ch, mp.getOrDefault(ch, 0) + 1);

            while (!mp.isEmpty() && mp.get(ch) > 2){
                char left = s.charAt(i);
                mp.put(left, mp.get(left) - 1);
                if (mp.get(left) == 0) {
                    mp.remove(left);
                }
                i++;
            }

            len = Math.max(len, j - i + 1);

            j++;
        }

        return len;

    }
}
