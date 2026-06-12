package com.dsa.Heap;

import java.util.PriorityQueue;

class KthLargestInAStream {

    PriorityQueue<Integer> pq;
    int kValue;

    public static void main(String[] args) {
        int [] nums = {1,2,3,4};
        int k = 3;
        KthLargestInAStream obj = new KthLargestInAStream(k, nums);
        System.out.println(obj.add(5));
        System.out.println(obj.add(2));
        System.out.println(obj.add(7));
    }

    public KthLargestInAStream(int k, int[] nums) {
        pq = new PriorityQueue<>();
        kValue = k;

        for (int n : nums){
            if (pq.size() < k){
                pq.offer(n);
            } else if (!pq.isEmpty() && n > pq.peek()){
                pq.poll();
                pq.offer(n);
            }
        }
    }
    
    public int add(int val) {
        if (pq.isEmpty()){
            return -1;
        }

        if (pq.size() < kValue){
            pq.offer(val);
            return pq.peek();
        }

        if (val > pq.peek()){
            pq.poll();
            pq.offer(val);
            return pq.peek();
        }
        return pq.peek();
    }
}