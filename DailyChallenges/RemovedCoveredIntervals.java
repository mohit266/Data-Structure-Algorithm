package com.dsa.DailyChallenges;

import java.util.Arrays;
import java.util.Comparator;

public class RemovedCoveredIntervals {
    public static void main(String[] args) {

        RemovedCoveredIntervals r = new RemovedCoveredIntervals();

        int [][] intervals = {{1,4}, {3,6}, {2,8}};
        System.out.println(r.removeCoveredIntervals(intervals));

    }


    public int removeCoveredIntervals(int[][] intervals) {

        Arrays.sort(intervals, Comparator.comparingInt((int[] interval) -> interval[0])
                .thenComparingInt((int[] interval) -> - interval[1]));

        int ans = 0;
        int prevEnd = 0;

        for (int[] interval : intervals)
            if (prevEnd < interval[1]) {
                prevEnd = interval[1];
                ++ans;
            }

        return ans;
    }
}
