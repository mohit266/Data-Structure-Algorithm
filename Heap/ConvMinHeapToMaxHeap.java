package com.dsa.Heap;

import java.util.Arrays;

public class ConvMinHeapToMaxHeap {
    public static void main(String[] args) {
        ConvMinHeapToMaxHeap o = new ConvMinHeapToMaxHeap();

        int[] nums = {10, 20, 30, 21, 23};
        System.out.println(Arrays.toString(o.minToMaxHeap(nums)));
    }

    public int[] minToMaxHeap(int[] nums) {
        int n = nums.length;

        int internalNodesIndex = (int) Math.ceil((double) n-1)/2;


        for (int index = internalNodesIndex; index >= 0; index--){
            heapifyDown(nums, index);
        }
        return nums;
    }

    public void heapifyDown(int[] arr, int index) {
        int largest = index;
        int leftChild = 2 * index + 1;
        int rightChild = 2 * index + 2;

        if (leftChild < arr.length && arr[leftChild] > arr[index]){
            largest = leftChild;
        }
        if (rightChild < arr.length && arr[rightChild] > arr[largest]){
            largest = rightChild;
        }
        if (largest != index) {
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
