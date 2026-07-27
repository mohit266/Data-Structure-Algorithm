package com.dsa.PatternWise.SlidingWindow.VariableWIndow;

// 3. Longest Substring Without Repeating Characters
public class LongestSubStringWithoutRepeatingCharacters {

    public static void main(String[] args) {
        LongestSubStringWithoutRepeatingCharacters l = new LongestSubStringWithoutRepeatingCharacters();

        String s = "abcabcbb";
        System.out.println(l.lengthOfLongestSubstring(s));
    }

    public int lengthOfLongestSubstring(String s) {

        int i = 0;
        int j = 0;

        int[] hash = new int[256];
        int maxLen = 0;
        while (i <= j && j < s.length()){
            char ch = s.charAt(j);

            while(hash[ch] > 0 && i <= j){
                char c = s.charAt(i);
                hash[c]--;
                i++;
            }

            hash[ch]++;
            maxLen = Math.max(maxLen, j-i+1);
            j++;
        }
        return maxLen;
    }

}
