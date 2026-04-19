package com.dsa.Strings;

import java.util.Stack;

public class MinimumAddToMakeParenthesesValid {
    public static void main(String[] args) {
        String s = ")()";
        System.out.println(minAddToMakeValid(s));
    }

    public static int minAddToMakeValid(String s) {
        Stack<Character> st = new Stack<>();

        int length = s.length();

        for (int i=0; i < length; i++){
            if (s.charAt(i) == '('){
                st.push('(');
            } else if (s.charAt(i) == ')') {
                if (!st.isEmpty() && st.peek() == '('){
                    st.pop();
                } else {
                    st.push(')');
                }
            }
        }
        return st.size();
    }
    public static int minimumAddToMakeValid(String s) {
        int length = s.length();
        int openingBracket = 0;
        int closingBracket = 0;
        for (int i =0; i<length; i++){
            if (s.charAt(i) == '('){
                openingBracket++;
            } else if (s.charAt(i) == ')'){
                if (openingBracket > 0){
                    openingBracket--;
                } else {
                    closingBracket++;
                }
            }
        }

        int res = closingBracket + openingBracket;

        if (res < 0){
            return res * -1;
        }
        return res;
    }
}