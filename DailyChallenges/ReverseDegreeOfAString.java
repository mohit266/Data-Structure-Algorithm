package com.dsa.DailyChallenges;

// 3498. Reverse Degree of a String
public class ReverseDegreeOfAString {

    public static void main(String[] args) {
        ReverseDegreeOfAString rev = new ReverseDegreeOfAString();

        String s = "zaza";
        System.out.println(rev.reverseDegree(s));
    }

    public int reverseDegree(String s) {

        int degree = 0;

        for (int i = 0; i < s.length(); i++){
            int sum = ('z' - s.charAt(i) + 1) * (i + 1);
            degree += sum;
        }

        return degree;
    }

}
