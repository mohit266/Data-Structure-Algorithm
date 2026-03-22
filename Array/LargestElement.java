package com.dsa.Array;

public class LargestElement {
    public static void main(String[] args) {
        int[] arr = {4, 4, 6, 2, 5, 7, 9, 1, 3};
        System.out.println("Largest Number is : " +getLargestElement(arr, arr.length));
    }

    public static int getLargestElement(int[] arr, int n){
        int largestNum = arr[0];

        for (int i = 1; i < n; i++){
            if (arr[i] > largestNum){
                largestNum = arr[i];
            }
        }
        return largestNum;
    }
}
