package com.dsa.DailyChallenges;

import java.util.Map;
import java.util.TreeMap;

public class SmallestPalindromicRearrangementI {

    public static void main(String[] args) {
        SmallestPalindromicRearrangementI s = new SmallestPalindromicRearrangementI();
        String str = "babab";

        System.out.println(s.smallestPalindrome(str));

    }

    public String smallestPalindrome(String s) {
        int[] freq = new int[26];

        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }

        StringBuilder left = new StringBuilder();
        StringBuilder middle = new StringBuilder();

        for (int i = 0; i < 26; i++) {
            left.append(String.valueOf((char)('a' + i)).repeat(freq[i] / 2));

            if (freq[i] % 2 == 1) {
                middle.append((char)('a' + i));
            }
        }

        String first = left.toString();
        return first + middle + new StringBuilder(first).reverse();
    }
}
