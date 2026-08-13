package com.dsa.PatternWise.RecursionAndBacktracking;

import java.util.ArrayList;
import java.util.List;

// 22. Generate Parentheses
public class GenerateParenthesesCombo {

    public static void main(String[] args) {
        GenerateParenthesesCombo g = new GenerateParenthesesCombo();

        int n = 3;
        System.out.println(g.generateParenthesis(n));
    }

    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();

        recursion(n,1, 0, "(", result);
        return result;
    }


    public void recursion(int n, int openingBracket, int closingBracket, String s, List<String> res){

        if (openingBracket == closingBracket && (openingBracket + closingBracket) == 2 * n){
            res.add(s);
            return;
        }

        if (openingBracket > n || openingBracket < closingBracket) {
            return;
        }

        recursion(n, openingBracket + 1, closingBracket, s + "(", res);
        recursion(n, openingBracket, closingBracket + 1, s + ")", res);
    }

}
