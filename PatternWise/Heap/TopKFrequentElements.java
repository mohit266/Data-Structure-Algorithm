package com.dsa.PatternWise.Heap;

import java.util.*;

// 347. Top K Frequent Elements
public class TopKFrequentElements {

    public static void main(String[] args) {
        TopKFrequentElements topK = new TopKFrequentElements();
        int[] nums = {1,1,1,2,2,3};

        System.out.println(Arrays.toString(topK.topKFrequent(nums, 2)));

    }

    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> mp = new HashMap<>();

        for (int n : nums){
            mp.put(n, mp.getOrDefault(n, 0) + 1);
        }

        PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>(Comparator.comparingInt(Map.Entry::getValue));

        for (Map.Entry<Integer, Integer> entry : mp.entrySet()) {

            pq.offer(entry);

            if (pq.size() > k) {
                pq.poll();
            }
        }

        int[] result = new int[k];

        for (int i = k - 1; i >= 0; i--) {
            result[i] = pq.poll().getKey();
        }

        return result;
    }

}
