package com.dsa.PatternWise.Heap;

import java.util.Collections;
import java.util.PriorityQueue;

public class KthSmallestElementInArray {
    public static void main(String[] args) {
        KthSmallestElementInArray smallest = new KthSmallestElementInArray();

        int[] nums = {1, 2, 3, 4, 5};
        System.out.println(smallest.kthSmallestEle(nums, 2));
    }

    public int kthSmallestEle(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for (int i = 0; i < k; i++){
            pq.offer(nums[i]);
        }

        for (int i = k; i < nums.length; i++){
            if (!pq.isEmpty() && pq.peek() <= nums[i]){
                continue;
            }
            pq.poll();
            pq.offer(nums[i]);
        }
        return !pq.isEmpty() ? pq.peek() : -1;
    }
}
