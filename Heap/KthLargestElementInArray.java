package com.dsa.Heap;

import java.util.PriorityQueue;
import java.util.Random;

public class KthLargestElementInArray {
    public static void main(String[] args) {
        KthLargestElementInArray k = new KthLargestElementInArray();

        int[] nums = {1, 2, 3, 4, 5};
        System.out.println(k.kthLargestEle(nums, 2));
    }


    // Brute - Better Solution
    public int kthLargestEle(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int i = 0; i <= k - 1; i++){
            pq.offer(nums[i]);
        }

        for (int i = k; i <= nums.length-1; i++){
            if (!pq.isEmpty() && nums[i] > pq.peek()){
                pq.poll();
                pq.offer(nums[i]);
            }
        }
        return !pq.isEmpty() ? pq.peek() : -1;
    }

    // Optimal Solution
    public int kthLargestElement(int[] nums, int k) {
        int left = 0;
        int right = nums.length - 1;

        while (true){

            int pivotIndex = (left+right)/2;
            pivotIndex = partitionAndReturnIndex(nums, left, right, pivotIndex);

            if (pivotIndex == k-1){
                return nums[pivotIndex];
            } else if (pivotIndex > k - 1){
                right = pivotIndex - 1;
            } else {
                left = pivotIndex + 1;
            }
        }
    }

    public int partitionAndReturnIndex(int[] nums, int left, int right, int pivotIndex){
        int pivot = nums[pivotIndex];

        swap(nums, left, pivotIndex);

        int index = left + 1;
        for (int i = left + 1; i <= right; i++){
            if (nums[i] > pivot){
                swap(nums, i, index);
                index++;
            }
        }
        swap(nums, left, index-1);
        return index - 1;
    }


    public void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }



}
