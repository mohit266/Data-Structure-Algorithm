package com.dsa.Strings;

public class LongestPalindromicSubstring {
    public static void main(String[] args) {
        String s = "babd";
        System.out.println(longestPalindrome(s));
    }

    public static String longestPalindrome(String s) {
        if (s.length() <= 1) return s;

        int n = s.length() - 1;

        String longestSubStr = "";

        for (int i = 1; i <= n; i++){

            int left = i - 1;
            int right = i + 1;

            while (left >= 0 && right <= n){
                if (s.charAt(left) == s.charAt(right)){
                    left--;
                    right++;
                } else {
                    break;
                }
            }

            String palindrome = s.substring(left + 1, right);

            if (palindrome.length() > longestSubStr.length()){
                longestSubStr = palindrome;
            }

            left = i - 1;
            right = i;
            while (left >=0 && right <= n){
                if (s.charAt(left) == s.charAt(right)){
                    left--;
                    right++;
                } else {
                    break;
                }
            }

            palindrome = s.substring(left + 1, right);

            if (palindrome.length() > longestSubStr.length()){
                longestSubStr = palindrome;
            }

        }
        return longestSubStr;
    }
}
