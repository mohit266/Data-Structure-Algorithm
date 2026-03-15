package com.dsaAtoZ.BasicRecursion;

import java.util.Arrays;

public class ReverseArray {
    public static void main(String[] args) {
        int[] arr = {2,1,5,6};
        reverseArray(arr, 0, arr.length);
        System.out.println(Arrays.toString(arr));

    }

    public static void reverseArray(int[] arr, int i, int n){
        if (i >= n/2){
            return;
        }
        swapValues(arr, i, n-i-1);
        reverseArray(arr, i+1, n);
    }

    public static void swapValues(int[] arr, int a, int b){
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }


}
