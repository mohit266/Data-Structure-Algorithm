package com.dsa.PatternWise.Intervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// 986. Interval List Intersections
public class IntervalListIntersections {

    public static void main(String[] args) {

        IntervalListIntersections inv = new IntervalListIntersections();

        int[][] firstList = {{3, 5},{9,20}};
        int[][] secondList = {{4,5},{7,10},{11,12},{14,15},{16,20}};

        System.out.println(Arrays.deepToString(inv.intervalIntersection(firstList, secondList)));
    }


    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        List<int[]> result = new ArrayList<>();
        int m = firstList.length;
        int n = secondList.length;

        int i = 0;
        int j = 0;

        while (i < m && j < n) {

            int l = Math.max(firstList[i][0], secondList[j][0]);
            int r = Math.min(firstList[i][1], secondList[j][1]);

            if (l <= r) {
                result.add(new int[] {l, r});
            }

            if (firstList[i][1] < secondList[j][1]) {
                i++;
            } else {
                j++;
            }
        }
        return result.toArray(new int[result.size()][]);
    }
}
