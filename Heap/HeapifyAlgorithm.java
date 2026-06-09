package com.dsa.Heap;

import java.util.Arrays;

public class HeapifyAlgorithm {
    public static void main(String[] args) {
        HeapifyAlgorithm heapifyAlgorithm = new HeapifyAlgorithm();

        int[] arr = {10, 7, 6, 4, 5, 4, 5, 3, 7};
        heapifyAlgorithm.heapify(arr, 0, 1);

        System.out.println(Arrays.toString(arr));
    }


    public void heapify(int[] arr, int index, int val){

        if (arr[index] < val){
            arr[index] = val;
            heapifyUp(arr, index);
        } else {
            arr[index] = val;
            heapifyDown(arr, index);
        }
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

    public void heapifyUp(int[] arr, int index){
        int parent = (int) Math.floor((double) index /2) - 1;

        if (index > 0 && arr[index] < arr[parent]){
            swap(arr, parent, index);
            heapifyUp(arr, parent);
        }
    }

    public void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
