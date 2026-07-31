package com.dsa.DailyChallenges;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MinimumNumberOfPushesToTypeWordII {

    public static void main(String[] args) {
        MinimumNumberOfPushesToTypeWordII min = new MinimumNumberOfPushesToTypeWordII();
        String s = "aabbccddeeffgghhiiiiii";

        System.out.println(min.minimumPushes(s));
    }

    public int minimumPushes(String word) {

        HashMap<Character, Integer> mp = new HashMap<>();

        for (char ch : word.toCharArray()){
            mp.put(ch, mp.getOrDefault(ch, 0) + 1);
        }

        List<Map.Entry<Character, Integer>> list = new ArrayList<>(mp.entrySet());

        list.sort((a, b) -> b.getValue() - a.getValue());

        int i = 0;
        int minPushes = 0;
        for (Map.Entry<Character, Integer> entry : list) {
            int size;
            int val = entry.getValue();

            if (i < 8) {
                size = 1;
            } else if (i < 16){
                size = 2;
            } else if (i < 24) {
                size = 3;
            } else {
                size = 4;
            }

            minPushes += (val * size);
            i++;
        }

        return minPushes;
    }

}
