package com.dsa.Array;

//This problem is for sorted array.
// https://leetcode.com/problems/remove-duplicates-from-sorted-array/description/
public class RemoveDuplicates {
    public static void main(String[] args) {
        int[] arr = {0,0,1,1,1,2,2,3,3,4};
        System.out.println("Unique Elements Count :: " +removeDuplicates(arr));
    }

    public static int removeDuplicates(int[] arr) {
        int i = 0;

        for (int j = 1; j < arr.length; j++){
            if (arr[i] != arr[j]){
                arr[i+1] = arr[j];
                i++;
            }
        }
        return i+1;
    }
}
