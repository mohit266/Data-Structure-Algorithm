package com.dsaAtoZ.Array;

public class SecondLargestElement {
    public static void main(String[] args) {
        int[] arr = {4, 4, 6, 2, 5, 7, 9, 9, 1, 3};
        System.out.println("Second Largest Number :: "+ getSecondLargestNum(arr, arr.length));
    }

    public static int getSecondLargestNum(int[] arr, int n){
        int largestNum = arr[0];
        int secondLargestNum = -1;

        for (int i= 1; i < n; i++){
            if (arr[i] > largestNum){
                secondLargestNum = largestNum;
                largestNum = arr[i];
            } else if (arr[i] < largestNum && arr[i] > secondLargestNum) {
                secondLargestNum = arr[i];
            }
        }
        return secondLargestNum;
    }
}
