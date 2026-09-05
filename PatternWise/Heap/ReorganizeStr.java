package com.dsa.PatternWise.Heap;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

// 767. Reorganize String
public class ReorganizeStr {

    public static void main(String[] args) {
        ReorganizeStr str = new ReorganizeStr();
        String s = "aab";

        System.out.println(str.reorganizeString(s));
    }


    public String reorganizeString(String s) {
        HashMap<Character,Integer> mp = new HashMap<>();

        for (char c : s.toCharArray()){
            mp.merge(c, 1, Integer::sum);
        }

        PriorityQueue<Map.Entry<Character, Integer>> pq = new PriorityQueue<>( (a, b) -> {
            if (!a.getValue().equals(b.getValue())){
                return b.getValue() - a.getValue();
            }
            return b.getKey() - a.getKey();
        });

        for (Map.Entry<Character, Integer> entry : mp.entrySet()){
            pq.offer(entry);
        }

        char[] res = new char[s.length()];

        for (int i = 0; i < s.length(); i++){
            if (pq.isEmpty()){
                return "";
            }

            Map.Entry<Character, Integer> temp = pq.poll();

            char key = temp.getKey();
            int value = temp.getValue();

            if (i == 0 || res[i - 1] != key){
                res[i] = key;
                value--;
                if (value > 0) {
                    pq.offer(Map.entry(key, value));
                }
            } else {
                if (pq.isEmpty()) {
                    return "";
                }
                Map.Entry<Character, Integer> p2 = pq.poll();
                res[i] = p2.getKey();
                int val = p2.getValue();
                val--;

                if(val > 0){
                    pq.offer(Map.entry(p2.getKey(), val));
                }
                pq.offer(temp);
            }
        }

        return new String(res);
    }
}