package com.dsa.Strings;

public class Anagram {
    public static void main(String[] args) {
        String s = "rat";
        String t = "car";

        System.out.println(isAnagram(s.toUpperCase(), t.toUpperCase()));
    }

    public static boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;

        int [] freq = new int[26];

        for (int i = 0; i < s.length(); i++){
            freq[s.charAt(i)-'A']++;
        }

        for (int i = 0; i < t.length(); i++){
            freq[t.charAt(i)-'A']--;
        }

        for (int i : freq){
            if (i != 0){
                return false;
            }
        }

        return true;
    }
}
