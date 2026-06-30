package com.dsa.DailyChallenges;

public class NumberOfSubstringsContainingAllThreeCharacters {

    public static void main(String[] args) {
        NumberOfSubstringsContainingAllThreeCharacters n = new NumberOfSubstringsContainingAllThreeCharacters();

        System.out.println(n.numberOfSubstrings("abcabc"));
    }


    public int numberOfSubstringsOptimalSol(String s) {
        int[] hash = new int[256];

        int len = s.length();
        int count = 0;

        int left = 0;
        for (int i = 0; i < len; i++){
            hash[s.charAt(i)]++;

            while (hash['a'] > 0 && hash['b'] > 0 && hash['c'] > 0) {
                count = count + (len - i);

                hash[s.charAt(left)]--;
                left++;
            }
        }

        return count;
    }

    public int numberOfSubstrings(String s) {
        int[] hash = new int[256];

        int len = s.length();
        int count = 0;

        for (int i = 0; i < len; i++){
            hash['a'] = 1;
            hash['b'] = 1;
            hash['c'] = 1;

            hash[s.charAt(i)] = 0;

            for (int j = i + 1; j < len; j++){
                hash[s.charAt(j)] = 0;

                if (hash['a'] == 0 && hash['b'] == 0 && hash['c'] == 0){
                    count = count + (len - j);
                    break;
                }
            }
        }

        return count;
    }

}
