package com.dsa.Recursion;

import java.util.ArrayList;
import java.util.List;

public class GenerateParenthesis {
    public static void main(String[] args) {
        int n = 3;
        System.out.println(generateParenthesis(n));
    }

    public static List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        generateAllParen(0, "", 0, 0, result, n);
        return result;

    }

    public static void generateAllParen(int index, String s, int openBracket, int closingBracket, List<String> ls, int n){
        if (openBracket > n){
            return;
        }

        if (((openBracket + closingBracket) == 2*n) && openBracket == n){
            ls.add(s);
        }

        generateAllParen(index + 1, s + "(", openBracket + 1, closingBracket, ls, n);

        if (openBracket > closingBracket){
            generateAllParen(index + 1, s + ")", openBracket, closingBracket + 1, ls, n);
        }
    }
}
