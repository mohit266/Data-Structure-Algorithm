package com.dsa.DailyChallenges;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class MinNumOfPushesToTypeWordI {

    public static void main(String[] args) {
        MinNumOfPushesToTypeWordI m = new MinNumOfPushesToTypeWordI();

        String word = "xycdefghij";
        System.out.println(m.minimumPushes(word));
    }


    public int minimumPushes(String word) {

        HashMap<Character, Integer> mp = new HashMap<>();

        int minPushes = 0;

        for (int i = 0; i < word.length(); i++){
            char ch = word.charAt(i);

            if (mp.containsKey(ch)){
                minPushes += mp.get(ch);
            } else {
                int size;
                if (mp.size() < 8){
                    size = 1;
                } else if (mp.size() < 16){
                    size = 2;
                } else if (mp.size() < 24) {
                    size = 3;
                } else {
                    size = 4;
                }

                minPushes += size;
                mp.put(ch, size);
            }

        }

        return minPushes;

    }

}
