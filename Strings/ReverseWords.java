package com.dsa.Strings;

public class ReverseWords {
    public static void main(String[] args) {
        String s = "the sky is blue";
        System.out.println(reverseWord(s));
    }

    // Optimal approach
    public static String reverseWord(String s) {
        StringBuilder result = new StringBuilder();

        int i = s.length() - 1;

        while (i >= 0) {
            while (i >= 0 && s.charAt(i) == ' ') {
                i--;
            }

            if (i < 0) break;

            int end = i;

            while (i >= 0 && s.charAt(i) != ' ') {
                i--;
            }

            String word = s.substring(i + 1, end + 1);

            if (result.length() > 0) {
                result.append(" ");
            }

            result.append(word);
        }

        return result.toString();
    }

    public static String reverseWords(String s) {
        String[] stringArray = s.split(" ");

        String res = "";

        int i = 0;
        int j = stringArray.length-1;

        while (i <= j){

            String temp = stringArray[i];
            stringArray[i] = stringArray[j];
            stringArray[j] = temp;

            i++;
            j--;
        }

        for (String str : stringArray){
            if (!str.isBlank()) res = res + " " + str.trim();
        }

        return res.trim();
    }
}
