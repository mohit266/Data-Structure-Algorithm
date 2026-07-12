package com.dsa.DailyChallenges;

import java.util.Arrays;
import java.util.HashMap;

public class RankTransformOfAnArray {

    public static void main(String[] args) {

        RankTransformOfAnArray rn = new RankTransformOfAnArray();

        int[] arr = {40,10,20,30};

        System.out.println(Arrays.toString(rn.arrayRankTransform(arr)));

    }

    public int[] arrayRankTransform(int[] arr) {
        int n = arr.length;
        int[] sortedArray = Arrays.copyOf(arr, n);

        Arrays.sort(sortedArray);
        HashMap<Integer, Integer> mp = new HashMap<>();

        int rank = 1;
        for (int i = 0; i < n; i++){
            if (!mp.containsKey(sortedArray[i])){
                mp.put(sortedArray[i], rank);
                rank++;
            }
        }

        for (int i = 0; i < n; i++){
            sortedArray[i] = mp.get(arr[i]);
        }
        return sortedArray;
    }

}
