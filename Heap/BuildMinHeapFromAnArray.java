package com.dsa.Heap;

import java.util.Arrays;

public class BuildMinHeapFromAnArray {
    public static void main(String[] args) {
        BuildMinHeapFromAnArray minHeap = new BuildMinHeapFromAnArray();

        int[] arr = {6, 5, 2, 7, 1, 7};
        minHeap.buildMinHeap(arr);

        System.out.println(Arrays.toString(arr));
    }

    public void buildMinHeap(int[] nums) {
        int n = nums.length;

        for (int index = (n/2)-1; index >= 0; index--){
            heapifyDown(nums, index);
        }
    }

    public void heapifyDown(int[] arr, int index){
        int smallest = index;

        int leftNodeIndex = 2 * index + 1;
        int rightNodeIndex = 2 * index + 2;

        if (leftNodeIndex < arr.length && arr[leftNodeIndex] < arr[smallest]){
            smallest = leftNodeIndex;
        }
        if (rightNodeIndex < arr.length && arr[rightNodeIndex] < arr[smallest]){
            smallest = rightNodeIndex;
        }

        if (smallest != index){
            swap(arr, smallest, index);
            heapifyDown(arr, smallest);
        }
    }

    public void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
