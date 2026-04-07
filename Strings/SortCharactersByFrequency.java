package com.dsa.Strings;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class SortCharactersByFrequency {
    public static void main(String[] args) {
        String s = "tree";
        System.out.println(frequencySort(s));
    }

    public static String frequencySort(String s) {
        HashMap<Character, Integer> map = new HashMap<>();

        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        List<Character> list = new ArrayList<>(map.keySet());

        list.sort((a, b) -> map.get(b) - map.get(a));

        StringBuilder result = new StringBuilder();

        for (char c : list) {
            int freq = map.get(c);
            for (int i = 0; i < freq; i++) {
                result.append(c);
            }
        }

        return result.toString();
    }
}
