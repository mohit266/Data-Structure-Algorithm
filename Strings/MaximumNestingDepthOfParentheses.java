package com.dsa.Strings;

public class MaximumNestingDepthOfParentheses {
    public static void main(String[] args) {
        String s = "(1+(2*3)+((8)/4))+1";
        System.out.println(maxDepth(s));
    }

    // The depth of any character in the VPS is the ( number of left brackets before it ) - ( number of right brackets before it )

    public static int maxDepth(String s) {

        int leftBrackets = 0;
        int rightBrackets = 0;

        int maxDept = 0;

        for (int i = 0; i < s.length(); i++){
            if (s.charAt(i) == '('){
                leftBrackets++;
            } else if (s.charAt(i)  == ')') {
                rightBrackets ++;
            }

            maxDept = Math.max(maxDept, (leftBrackets - rightBrackets));
        }
        return maxDept;
    }
}
