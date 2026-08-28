package com.dsa;

import java.util.*;

public class Revision {
    public static void main(String[] args) {

        Revision rev = new Revision();

        System.out.println(rev.generateParenthesis(3));

    }

    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();

        recursion(n,1, 0, "(", result);
        return result;
    }


    public void recursion(int n, int openingBracket, int closingBracket, String s, List<String> res){

        if (openingBracket == closingBracket && (openingBracket + closingBracket) == 2 * n){
            res.add(s);
        }

        if (openingBracket > n || openingBracket < closingBracket) {
            return;
        }

        recursion(n, openingBracket + 1, closingBracket, s + "(", res);
        recursion(n, openingBracket, closingBracket + 1, s + ")", res);
    }


}
