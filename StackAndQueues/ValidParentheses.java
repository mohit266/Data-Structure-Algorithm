package com.dsa.StackAndQueues;

import java.util.Stack;

public class ValidParentheses {
    public static void main(String[] args) {
        String  s = "()[]{}";
        System.out.println(isValid(s));
    }


    public static boolean isValid(String s) {
        Stack<Character> st= new Stack<>();
        int len = s.length();
        if ((len & 1) != 0) return false;
        st.add(s.charAt(0));

        for (int i = 1; i < len; i++){
            if (!st.isEmpty() && ((s.charAt(i) == ')' && st.peek() == '(') || (s.charAt(i) == ']' && st.peek() == '[') ||
                    (s.charAt(i) == '}' && st.peek() == '{'))){
                st.pop();
            } else {
                st.add(s.charAt(i));
            }
        }
        return st.isEmpty();

    }
}
