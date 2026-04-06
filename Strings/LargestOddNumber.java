package com.dsa.Strings;

public class LargestOddNumber {
    public static void main(String[] args) {
        String input = "052";
        System.out.println(largestOddNumber(input));
    }

    public static String largestOddNumber(String num) {
        int index = -1;

        for (int i = num.length()-1; i>=0; i--){
            if (num.charAt(i) % 2 != 0){
                index = i;
                break;
            }
        }

        if (index == -1) return "";

        int j = 0;
        while (j <= index && num.charAt(j) == '0'){
            j++;
        }


        return num.substring(j, index+1);
    }
}
