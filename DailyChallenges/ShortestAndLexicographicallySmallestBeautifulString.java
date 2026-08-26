package com.dsa.DailyChallenges;

public class ShortestAndLexicographicallySmallestBeautifulString {

    public static void main(String[] args) {

        ShortestAndLexicographicallySmallestBeautifulString sh = new ShortestAndLexicographicallySmallestBeautifulString();

        String s = "100011001";
        int k = 3;

        System.out.println(sh.shortestBeautifulSubstring(s, k));
    }

    public String shortestBeautifulSubstring(String s, int k) {

        int i = 0;
        int j = 0;

        int startIndex = -1;

        int count = Integer.MAX_VALUE;

        while (j < s.length()){
            char ch = s.charAt(j);

            if (ch == '1'){
                k--;
            }

            while (k < 1){
                if (startIndex == -1 || ((j - i + 1) <= count)){
                    if (j - i + 1 == count){
                        String s1 = s.substring(i, i + count);
                        String s2 = s.substring(startIndex, startIndex + count);
                        if (s1.compareTo(s2) < 0){
                            startIndex = i;
                        }
                    } else {
                        startIndex = i;
                    }
                    count = j - i + 1;
                }

                char left = s.charAt(i);
                if (left == '1'){
                    k++;
                }
                i++;
            }
            j++;
        }

        if (startIndex == -1){
            return "";
        }

        return s.substring(startIndex, startIndex + count);
    }

}
