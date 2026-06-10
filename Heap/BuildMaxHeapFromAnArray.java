package com.dsa.Heap;

import java.util.Arrays;

public class BuildMaxHeapFromAnArray {
    public static void main(String[] args) {

        BuildMaxHeapFromAnArray maxHeap = new BuildMaxHeapFromAnArray();

        int[] arr = {6, 5, 2, 7, 1, 7};
        maxHeap.buildMaxHeap(arr);

        System.out.println(Arrays.toString(arr));

    }

    public void buildMaxHeap(int[] nums) {
        int n = nums.length;

        // internal node - 0 to (n/2)-1.

        for(int index = (n/2)-1; index >= 0; index--){
            heapifyDown(nums, index);
        }
    }

    public void heapifyDown(int[] arr, int index){
        int largest = index;

        int left = 2 * index + 1;
        int right = 2 * index + 2;

        if (left < arr.length && arr[largest] < arr[left]){
            largest = left;
        }
        if (right < arr.length && arr[largest] < arr[right]){
            largest = right;
        }

        if (largest != index){
            swap(arr, index, largest);
            heapifyDown(arr, largest);
        }
    }

    public void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
