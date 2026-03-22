package com.dsa.Sorting;

import java.util.Arrays;

public class Insertion {
    public static void main(String[] args) {
        int[] arr = {13, 46, 24, 52, 20, 9};
//        insertionSort(arr);
        insertionSortUsingRecursion(arr, 0, arr.length);
        System.out.println("Sorted Array :: "+ Arrays.toString(arr));
    }

    // Worst Case Time Complexity = O(n2) and Best Case is O(n).
    public static void insertionSort(int[] arr){
        for (int i =1; i<= arr.length-1; i++){
            int j = i;
            while (j > 0 && arr[j-1] > arr[j]){
                swapArray(arr, j, j-1);
                j--;
            }
        }
    }

    public static void swapArray(int[] arr, int a, int b){
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    static void insertionSortUsingRecursion(int[] arr, int i, int n) {
        // Base case
        if (i == n) return;

        int j = i;
        // Move the current element back until it's in the correct place
        while (j > 0 && arr[j - 1] > arr[j]) {
            // Swap arr[j] and arr[j-1]
            int temp = arr[j - 1];
            arr[j - 1] = arr[j];
            arr[j] = temp;
            j--;
        }

        // Recur for the next index
        insertionSortUsingRecursion(arr, i + 1, n);
    }

}
