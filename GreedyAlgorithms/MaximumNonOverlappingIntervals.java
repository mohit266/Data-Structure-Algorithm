package com.dsa.GreedyAlgorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MaximumNonOverlappingIntervals {
    public static void main(String[] args) {
        MaximumNonOverlappingIntervals m1 = new MaximumNonOverlappingIntervals();

        int[][]  intervals = {{1, 3} , {1, 4} , {3, 5} , {3, 4} , {4, 5}};
        // You can remove the intervals [1, 4] and [3, 5] and the remaining intervals becomes non overlapping.
        System.out.println(m1.maxNonOverlappingIntervals(intervals));
    }

    public int maxNonOverlappingIntervals(int[][] intervals) {

        List<int[]> ls = new ArrayList<>(Arrays.asList(intervals));

        ls.sort(Comparator.comparingInt(a -> a[1]));

        int count = 0;
        int lastEnd = ls.get(0)[1];

        for (int i = 1; i < intervals.length; i++) {
            if (ls.get(i)[0] >= lastEnd) {
                lastEnd = ls.get(i)[1];
            } else {
                count++;
            }
        }
        return count;

    }
}
