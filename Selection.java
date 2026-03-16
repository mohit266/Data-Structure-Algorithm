package com.dsaAtoZ.Sorting;

import java.util.Arrays;

public class Selection {
    public static void main(String[] args) {
        int[] arr = {13, 46, 24, 52, 20, 9};
        selectionSort(arr);
        System.out.println("Sorted Array :: "+ Arrays.toString(arr));
    }


    // Time complexity is O(n2)
    public static void selectionSort(int[] arr){
        int minIndex;
        for (int i=0; i<arr.length-1; i++){
            minIndex = i;
            for (int j=i; j<arr.length; j++){
                if (arr[j] < arr[minIndex]){
                    minIndex = j;
                }
            }
            swapArray(arr, i, minIndex);
        }
    }

    public static void swapArray(int[] arr, int a, int b){
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}
