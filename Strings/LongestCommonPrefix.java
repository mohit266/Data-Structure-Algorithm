package com.dsa.Strings;

import java.util.Arrays;

public class LongestCommonPrefix {
    public static void main(String[] args) {
        String[] str = {"dog","racecar","car"};
        System.out.println(longestCommonPrefix(str));
    }

    // Without sorting
    public static String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) return "";

        for (int i = 0; i < strs[0].length(); i++) {
            char ch = strs[0].charAt(i);

            for (int j = 1; j < strs.length; j++) {
                if (i == strs[j].length() || strs[j].charAt(i) != ch) {
                    return strs[0].substring(0, i);
                }
            }
        }

        return strs[0];
    }

    public static String longestComPrefix(String[] str) {
        Arrays.sort(str);

        String firstStr = str[0];
        String lastStr = str[str.length-1];

        int count = 0;

        for (int i = 0; i < Math.min(firstStr.length(), lastStr.length()); i++){
            if (firstStr.charAt(i) == lastStr.charAt(i)){
                count++;
            } else {
                break;
            }
        }

        return count == 0 ? "" : lastStr.substring(0, count);

    }

}
