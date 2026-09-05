package com.dsa.PatternWise.Heap;

import java.util.PriorityQueue;

// 1046. Last Stone Weight
public class LastStoneWeigh {

    public static void main(String[] args) {

        LastStoneWeigh lst = new LastStoneWeigh();

        int[] stones = {2,7,4,1,8,1};

        System.out.println(lst.lastStoneWeight(stones));

    }

    public int lastStoneWeight(int[] stones) {

        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);

        for (int n : stones){
            pq.offer(n);
        }

        while (pq.size() > 1){
            int x = pq.poll();
            int y = pq.poll();

            if (x != y){
                pq.offer(Math.abs(y - x));
            } 
        }

        return pq.isEmpty() ? 0 : pq.peek();

    }
}