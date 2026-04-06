package com.dsa.Strings;

public class RemoveOutermostParentheses {
    public static void main(String[] args) {
        String s = "(()())(())";

        System.out.println(removeOuterParentheses(s));
    }

    public static String removeOuterParentheses(String s) {
        String result = "";
        int counter = 0;

        for (Character ch : s.toCharArray()){
            if (ch.equals('(')){
                if (counter > 0){
                    result += ch;
                }
                counter++;
            } else if (ch.equals(')')) {
                counter--;
                if (counter > 0){
                    result += ch;
                }
            }
        }
        return result;
    }
}
