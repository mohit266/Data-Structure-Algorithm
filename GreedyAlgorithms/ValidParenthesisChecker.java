package com.dsa.GreedyAlgorithms;

public class ValidParenthesisChecker {
    public static void main(String[] args) {
        ValidParenthesisChecker v1 = new ValidParenthesisChecker();

        String s = "*((";
        System.out.println(v1.checkValidString(s));
    }

    public boolean checkValidString(String s) {
        int min = 0;
        int max = 0;

        for (char c : s.toCharArray()){
            if (c == '('){
                min++;
                max++;
            } else if (c == ')'){
                min--;
                max--;
            } else if (c == '*') {
                min--;
                max++;
            }

            if (max < 0) return false;
            if (min < 0) min = 0;
        }

        return min == 0;
    }

}
