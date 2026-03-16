package com.dsaAtoZ.Sorting;

import java.util.Arrays;

public class Quick {
    public static void main(String[] args) {
        int[] arr = {4, 4, 6, 2, 5, 7, 9, 1, 3};
        quickSort(arr, 0, arr.length-1);
        System.out.println("Sorted Array is :: "+ Arrays.toString(arr));
    }


    public static void quickSort(int[] arr, int low, int high){
        if (low < high){
            int partitionIndex = getPartitionIndex(arr, low, high);
            quickSort(arr, low, partitionIndex-1);
            quickSort(arr, partitionIndex+1, high);
        }
    }

    public static int getPartitionIndex(int[] arr, int low, int high){
        int pivot = arr[low];
        int i = low;
        int j = high;

        while (i<j){
            while (arr[i] <= pivot && i <= high + 1){
                i++;
            }

            while(arr[j] >= pivot && j >= low+1){
                j--;
            }

            if (i < j) {
                swapArray(arr, i, j);
            }
        }
        swapArray(arr, low, j);
        return j;
    }

    public static void swapArray(int[] arr, int a, int b){
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

}
