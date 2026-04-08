package com.dsa.Strings;

import java.util.Map;

public class RomanToInteger {

    static Map<Character, Integer> romanValues = Map.of(
            'I', 1,
            'V', 5,
            'X', 10,
            'L', 50,
            'C', 100,
            'D', 500,
            'M', 1000
    );

    public static void main(String[] args) {
        String s = "MCMXCIV";
        System.out.println(romanToInt(s));
        // Output: 1994
        // Explanation: M = 1000, CM = 900, XC = 90 and IV = 4.
    }

    public static int romanToInt(String s) {
        int result = romanValues.get(s.charAt(s.length()-1));
        for (int i = 0; i < s.length()-1; i++){
            if (romanValues.get(s.charAt(i)) < romanValues.get(s.charAt(i+1))){
                result = result - romanValues.get(s.charAt(i));
            } else {
                result = result + romanValues.get(s.charAt(i));
            }
        }
        return result;
    }
}
