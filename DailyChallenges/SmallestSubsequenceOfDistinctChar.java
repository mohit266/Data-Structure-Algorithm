package com.dsa.DailyChallenges;

import java.util.Stack;

public class SmallestSubsequenceOfDistinctChar {
    public static void main(String[] args) {
        SmallestSubsequenceOfDistinctChar sm = new SmallestSubsequenceOfDistinctChar();

        String s = "cbaacabcaaccaacababa";

        System.out.println(sm.smallestSubsequence(s));

    }

    public String smallestSubsequence(String s) {

        char[] freq = new char[265];

        for (int i = 0; i < s.length(); i++){
            freq[s.charAt(i)]++;
        }

        Stack<Character> st = new Stack<>();

        for (char ch : s.toCharArray()){

            while (!st.isEmpty() && st.peek() > ch && freq[st.peek()] >= 1 && !st.contains(ch)){
                st.pop();
            }

            if(!st.contains(ch)){
                st.push(ch);
            }
            freq[ch]--;
        }

        StringBuilder result = new StringBuilder(st.size());

        while(!st.isEmpty()){
            result.append(st.pop());
        }

        return String.valueOf(result.reverse());

    }
}
