package com.dsa.Recursion;

import java.util.ArrayList;
import java.util.List;

public class LetterCombinationOfPhoneNum {

    private static final String[] map = new String[]{"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    public static void main(String[] args) {
        String digits = "34";
        System.out.println(letterCombinations(digits));
    }

    public static List<String> letterCombinations(String digits) {
        List<String> ans = new ArrayList<>();
        if (digits.length() == 0) return ans;
        generateComb(digits, ans, 0, "");
        return ans;
    }

    private static void generateComb(String digits, List<String> ans, int index, String current) {
        if (index == digits.length()) {
            ans.add(current);
            return;
        }

        String s = map[digits.charAt(index) - '0'];
        for (int i = 0; i < s.length(); i++) {
            generateComb(digits, ans, index + 1, current + s.charAt(i));
        }
    }

}
