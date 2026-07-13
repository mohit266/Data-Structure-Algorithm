package com.dsa.DailyChallenges;

import java.util.ArrayList;
import java.util.List;

public class SequentialDigits {

    public static void main(String[] args) {

        SequentialDigits s = new SequentialDigits();

        int low = 1000;
        int high = 13000;

        System.out.println(s.sequentialDigits(low, high));
    }

    public List<Integer> sequentialDigits(int low, int high) {

        List<Integer> res = new ArrayList<>();

        int lowLen = String.valueOf(low).length();
        int highLen = String.valueOf(high).length();

        String s = "123456789";

        while (lowLen <= highLen){
            for (int i = 0; i <= s.length() - lowLen; i++){
                int num = Integer.parseInt(s.substring(i, i + lowLen));

                if (num >= low && num <= high){
                    res.add(num);
                }
            }
            lowLen++;
        }

        return res;
    }
}
