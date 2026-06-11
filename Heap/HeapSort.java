package com.dsa.Heap;

import java.util.Arrays;

public class HeapSort {
    public static void main(String[] args) {
        HeapSort hs = new HeapSort();
        int[] nums = {7, 4, 1, 5, 3};
        hs.heapSort(nums);
        System.out.println(Arrays.toString(nums));
    }

    public void heapSort(int[] nums) {
        int n = nums.length;
        buildMaxHeapFromAnArray(nums);
        int last = n - 1;

        while (last > 0){
            swap(nums, last, 0);
            last--;
            heapifyDown(nums, last, 0);
        }
    }

    public void buildMaxHeapFromAnArray(int[] nums){
        int n = nums.length;
        int internalNodeIndex = (int) Math.ceil((double) n - 1)/2;

        for (int index = internalNodeIndex; index >= 0; index--){
            heapifyDown(nums, n - 1, index);
        }


    }

    public void heapifyDown(int[] arr, int lastIndex, int index){
        int largest = index;

        int left = 2 * index + 1;
        int right = 2 * index + 2;

        if (left <= lastIndex && arr[left] > arr[largest]){
            largest = left;
        }

        if (right <= lastIndex && arr[right] > arr[largest]){
            largest = right;
        }

        if (largest != index){
            swap(arr, index, largest);
            heapifyDown(arr, lastIndex, largest);
        }

    }

    public void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
