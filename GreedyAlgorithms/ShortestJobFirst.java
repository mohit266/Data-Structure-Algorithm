package com.dsa.GreedyAlgorithms;

import java.util.Arrays;

public class ShortestJobFirst {
    public static void main(String[] args) {
        ShortestJobFirst shortestJobFirst = new ShortestJobFirst();

        int[] arr = {4, 1, 3, 7, 2};
        System.out.println(shortestJobFirst.solve(arr));

    }

    public long solve(int[] bt) {
        Arrays.sort(bt);

        long time = 0;
        long waitingTime = 0;

        for (int n : bt){
            waitingTime += time;
            time += n;
        }

        return (long) Math.floor((double) waitingTime /bt.length);
    }
}
