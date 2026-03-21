package com.dsaAtoZ.Array;

import java.util.ArrayList;
import java.util.List;

public class LargestLadder {
    public static void main(String[] args) {
        int[] arr = {1, 2, 5, 3, 1, 2};
        System.out.println(getLargestLadder(arr));
    }

    public static List<Integer> getLargestLadder(int [] arr){
        List<Integer> ladderList = new ArrayList<>();
        int n = arr.length;
        int index = -1;
        int maxEl = arr[0];

        for (int i = 1; i<n; i++){
            if (arr[i] > maxEl){
                maxEl = arr[i];
                index = i;
            }
        }

        ladderList.add(arr[index]);
        int rightMostEl = arr[n-1];

        for (int i = index+1; i < n-1; i++){
            if (arr[i] > rightMostEl) {
                ladderList.add(arr[i]);
            }
        }

        ladderList.add(rightMostEl);

        return ladderList;
    }
}
