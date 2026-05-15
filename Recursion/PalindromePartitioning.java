package com.dsa.Recursion;

import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning {
    public static void main(String[] args) {
        String s = "aabaa";
        System.out.println(partition(s));
    }

    public static List<List<String>> partition(String s) {
        List<List<String>> ans = new ArrayList<>();
        backTrackPartition(0, s, new ArrayList<>(), ans);
        return ans;
    }

    public static void backTrackPartition(int index, String s, List<String> current, List<List<String>> ans){
        if (index == s.length()){
            ans.add(new ArrayList<>(current));
            return;
        }

        for (int i = index; i < s.length(); i++){
            if (isPalindrome(s, index, i)){
                String subs = s.substring(index, i + 1);
                current.add(subs);
                backTrackPartition(i + 1, s, current, ans);
                current.remove(current.size()-1);
            }
        }
    }

    private static boolean isPalindrome(String s, int left, int right) {
        while (left < right){
            if (s.charAt(left) != s.charAt(right)){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
