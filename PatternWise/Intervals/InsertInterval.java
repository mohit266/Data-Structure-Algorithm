package com.dsa.PatternWise.Intervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// 57. Insert Interval
public class InsertInterval {
    public static void main(String[] args) {
        InsertInterval insertInterval = new InsertInterval();

        int[][] intervals = {{1, 2} , {3, 9} , {6, 7} , {8,10}};
        int[] interval = {4, 8};

        System.out.println(Arrays.deepToString(insertInterval.insertNewInterval(intervals, interval)));

    }

    public int[][] insertNewInterval(int[][] intervals, int[] newInterval) {
        List<int[]> res = new ArrayList<>();

        int i = 0;

        int n = intervals.length;

        while (i < n && intervals[i][1] < newInterval[0]) {
            res.add(intervals[i]);
            i++;
        }

        while (i < n && intervals[i][0] <= newInterval[1]) {
            newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            i++;
        }

        res.add(newInterval);

        while (i < n) {
            res.add(intervals[i]);
            i++;
        }

        return res.toArray(new int[res.size()][]);
    }
}
