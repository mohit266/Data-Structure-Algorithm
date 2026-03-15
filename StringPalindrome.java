package com.dsaAtoZ.BasicRecursion;

// https://leetcode.com/problems/valid-palindrome/description/
public class StringPalindrome {
    public static void main(String[] args) {
        String a = "a";
        char[] arr = a.toCharArray();
        System.out.println(isPalindrome(arr, 0, arr.length));
        System.out.println(isPalindrome(a));

    }

    public static boolean isPalindrome(char[] arr, int i, int n){
        if (i >= n/2){
            return true;
        }

        if (arr[i] != arr[n-i-1]){
            return false;
        }
        return isPalindrome(arr,i+1, n);
    }

    // Second Approach
    public static boolean isPalindrome(String s) {
        s = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        if (s.isBlank()) return true;
        return isPalindrome(s, 0, s.length());
    }

    public static boolean isPalindrome(String s, int i, int n){
        if (i >= n/2){
            return true;
        }
        if (s.charAt(i) != s.charAt(n-i-1)){
            return false;
        }
        return isPalindrome(s, i+1, n);
    }
}
