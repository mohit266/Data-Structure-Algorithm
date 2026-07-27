package com.dsa.PatternWise.SlidingWindow.FixedWindow;

// 1456. Maximum Number of Vowels in a Substring of Given Length
public class MaximumNumberOfVowelsInASubStringOfGivenLength {

    public static void main(String[] args) {
        MaximumNumberOfVowelsInASubStringOfGivenLength m = new MaximumNumberOfVowelsInASubStringOfGivenLength();
        String s = "abciiidef";
        int k = 3;

        System.out.println(m.maxVowels(s, k));
    }

    public int maxVowels(String s, int k) {
        String vowels = "aeiou";

        int numOfVowels = 0;
        int max;
        int j = 0;
        while (j < k){
            char ch = s.charAt(j);
            if (vowels.contains(String.valueOf(ch))){
                numOfVowels++;
            }
            j++;
        }

        max = numOfVowels;

        int i = 0;
        while (j < s.length()){
            char rightChar = s.charAt(j);
            char prevChar = s.charAt(i);

            if (vowels.contains(String.valueOf(prevChar))){
                numOfVowels--;
            }

            if (vowels.contains(String.valueOf(rightChar))){
                numOfVowels++;
            }

            max = Math.max(max, numOfVowels);

            i++;
            j++;
        }
        return max;
    }

}
