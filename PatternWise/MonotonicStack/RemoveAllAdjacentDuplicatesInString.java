package com.dsa.PatternWise.MonotonicStack;

import java.util.Stack;

// 1047. Remove All Adjacent Duplicates In String
public class RemoveAllAdjacentDuplicatesInString {

    public static void main(String[] args) {
        RemoveAllAdjacentDuplicatesInString r = new RemoveAllAdjacentDuplicatesInString();

        String s = "abbaca";
        System.out.println(r.removeDuplicates(s));
    }

    public String removeDuplicates(String s) {

        Stack<Character> st = new Stack<>();

        for (char ch : s.toCharArray()){
            if (!st.isEmpty() && ch == st.peek()){
                st.pop();
            } else {
                st.push(ch);
            }
        }

        StringBuilder str = new StringBuilder(st.size());

        while (!st.isEmpty()){
            str.append(st.pop());
        }

        return String.valueOf(str.reverse());
    }

}
