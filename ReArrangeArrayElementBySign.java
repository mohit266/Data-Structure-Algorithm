package com.dsaAtoZ.Array;

import java.util.Arrays;

public class ReArrangeArrayElementBySign {
    public static void main(String[] args) {
        int[] arr = {3, 1, -2,-5,2,-4};
        System.out.println(Arrays.toString(rearrangeArray(arr)));
    }

    public static int[] rearrangeArray(int[] nums) {
        int[] newArray = new int[nums.length];
        int posIndex = 0;
        int negIndex = 1;
        for (int i =0 ;i<nums.length; i++){
            if (nums[i] > 0){
                newArray[posIndex] = nums[i];
                posIndex += 2;
            } else {
                newArray[negIndex] = nums[i];
                negIndex += 2;
            }
        }
        return newArray;
    }
}
