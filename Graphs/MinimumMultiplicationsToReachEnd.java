package com.dsa.Graphs;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class MinimumMultiplicationsToReachEnd {
    public static void main(String[] args) {
        MinimumMultiplicationsToReachEnd m = new MinimumMultiplicationsToReachEnd();

        int[] arr = {2, 5, 7};
        int start = 3;
        int end = 30;

        System.out.println(m.minimumMultiplications(arr, start, end));
    }

    public int minimumMultiplications(int[] arr, int start, int end) {

        if (start == end) return 0;

        int mod = 100000;

        int[] minSteps  = new int[mod];
        Arrays.fill(minSteps , Integer.MAX_VALUE);

        Queue<int[]> q = new LinkedList<>();

        q.offer(new int[]{0, start});
        minSteps [start] = 0;

        while (!q.isEmpty()){
            int[] cell = q.poll();
            int steps = cell[0];
            int node = cell[1];

            for (int j : arr) {
                int num = (node * j) % mod;

                if (num == end) return steps + 1;

                if (steps + 1 < minSteps[num]) {
                    minSteps[num] = steps + 1;
                    q.add(new int[]{steps + 1, num});
                }
            }
        }
        return -1;
    }

}
