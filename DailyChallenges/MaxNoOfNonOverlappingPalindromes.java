package com.dsa.DailyChallenges;

public class MaxNoOfNonOverlappingPalindromes {

    public static void main(String[] args) {

        MaxNoOfNonOverlappingPalindromes m = new MaxNoOfNonOverlappingPalindromes();

        String s = "aabbbbaa";
        int k = 4;

        System.out.println(m.maxPalindromes(s, k));

    }


    public int maxPalindromes(String s, int k) {

        int n = s.length();

        if (k == 1)
            return n;

        int ans = 0;

        for (int i = 0; i <= n - k; i++) {
            if (isPalindrome(s, i, i + k - 1)) {
                ans++;
                i += k - 1;
            } else if (i < n - k && isPalindrome(s, i, i + k)) {
                ans++;
                i += k;
            }
        }

        return ans;
    }

    public boolean isPalindrome(String s, int i, int j){
        while (i < j){
            if (s.charAt(i) != s.charAt(j)){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

}
