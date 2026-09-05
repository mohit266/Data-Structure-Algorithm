package com.dsa.PatternWise.Heap;

import java.util.*;

// 692. Top K Frequent Words
public class TopKFrequentWords {

    public static void main(String[] args) {
        TopKFrequentWords topK = new TopKFrequentWords();

        String[] words = {"the","day","is","sunny","the","the","the","sunny","is","is"};
        int k = 4;

        System.out.println(topK.topKFrequent(words, k));
    }

    public List<String> topKFrequent(String[] words, int k) {

        HashMap<String, Integer> mp = new HashMap<>();

        for (String s : words){
            mp.put(s, mp.getOrDefault(s, 0) + 1);
        }

        PriorityQueue<Map.Entry<String, Integer>> pq = new PriorityQueue<>((a, b) ->
        {
            if (!a.getValue().equals(b.getValue())) {
                return a.getValue() - b.getValue();
            }
            return b.getKey().compareTo(a.getKey());
        });

        for (Map.Entry<String, Integer> entries : mp.entrySet()){
            pq.offer(entries);

            if (pq.size() > k){
                pq.poll();
            }
        }

        List<String> res = new ArrayList<>();

        for (int i = 0; i < k; i++){
            res.add(pq.poll().getKey());
        }

        Collections.reverse(res);

        return res;
    }

}
