package com.dsa.PatternWise.Heap.GreedyPlusHeap;

import java.util.*;

// 621. Task Scheduler
public class TaskScheduler {

    public static void main(String[] args) {
        TaskScheduler ts = new TaskScheduler();
        char[] tasks = {'A','C','A','B','D','B'};
        int n = 1;

        System.out.println(ts.leastInterval(tasks, n));
    }

    public int leastInterval(char[] tasks, int n) {

        HashMap<Character, Integer> mp = new HashMap<>();
        int[] freq = new int[256];

        for (char c : tasks){
            mp.merge(c, 1, Integer::sum);
            freq[c] = 1;
        }

        PriorityQueue<Map.Entry<Character, Integer>> pq = new PriorityQueue<>((a, b) -> b.getValue() - a.getValue());

        for (Map.Entry<Character, Integer> entry : mp.entrySet()){
            pq.offer(entry);
        }

        int seat = 1;

        while (!pq.isEmpty()){
            Queue<Map.Entry<Character, Integer>> q = new LinkedList<>();

            while (!pq.isEmpty()){
                Map.Entry<Character, Integer> temp = pq.poll();
                char key = temp.getKey();
                int val = temp.getValue();

                if (freq[key] <= seat){
                    if (val > 1){
                        freq[key] = seat + n + 1;
                        pq.offer(Map.entry(key, val - 1));
                    }
                    break;
                } else {
                    q.offer(temp);
                }
            }

            while (!q.isEmpty()){
                pq.offer(q.poll());
            }
            seat++;
        }

        return seat - 1;
    }

}
