package com.dsaAtoZ.Sorting;

import java.util.Arrays;

public class Bubble {
    public static void main(String[] args) {
        int[] arr = {13, 46, 24, 52, 20, 9};
//        bubbleSort(arr);
        bubbleSortUsingRecursion(arr, arr.length);
        System.out.println("Sorted Array :: "+ Arrays.toString(arr));

    }

    // Worst Case Time Complexity = O(n2) and Best Case is O(n).
    public static void bubbleSort(int[] arr){
        for (int i = arr.length - 1; i >= 1; i--){
            int didSwap = 0;
            for (int j = 0; j<i; j++){
                if (arr[j] > arr[j+1]){
                    swapArray(arr, j, j+1);
                    didSwap = 1;
                }
            }
            if (didSwap == 0){
                break;
            }
        }
    }

    public static void swapArray(int[] arr, int a, int b){
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    static void bubbleSortUsingRecursion(int[] arr, int n) {
        // Base case: array of size 1 is already sorted
        if (n == 1) return;

        // Push the largest element to the end
        for (int j = 0; j <= n - 2; j++) {
            if (arr[j] > arr[j + 1]) {
                // Swap arr[j] and arr[j + 1]
                int temp = arr[j];
                arr[j] = arr[j + 1];
                arr[j + 1] = temp;
            }
        }

        bubbleSortUsingRecursion(arr, n - 1);
    }
}
