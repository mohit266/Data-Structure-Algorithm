package com.dsa.DailyChallenges;

import java.util.HashMap;

public class MaxNoOfBalloons {
    public static void main(String[] args) {
        MaxNoOfBalloons m = new MaxNoOfBalloons();

        String text = "loonbalxballpoon";

        System.out.println(m.maxNumberOfBalloons(text));

    }

    public int maxNumberOfBalloons(String text) {

        String s = "balloon";

        HashMap<Character, Integer> freq = new HashMap<>();

        for (int i = 0; i < text.length(); i++){
            char ch = text.charAt(i);

            if (s.contains(String.valueOf(ch))){
                freq.put(ch, freq.getOrDefault(ch, 0) + 1);
            }
        }

        int i = 0;

        int count = 0;

        while (!freq.isEmpty()){

            char ch = s.charAt(i);

            if (!freq.containsKey(ch)) {
                return count;
            }

            freq.put(ch, freq.get(ch) - 1);
            if (freq.get(ch) == 0){
                freq.remove(ch);
            }

            i++;
            if (i == 7){
                count++;
                i = 0;
            }
        }

        return count;

    }
}
