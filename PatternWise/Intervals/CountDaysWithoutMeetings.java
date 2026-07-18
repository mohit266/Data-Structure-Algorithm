package com.dsa.PatternWise.Intervals;

import java.util.*;

// 3169. Count Days Without Meetings
public class CountDaysWithoutMeetings {

    public static void main(String[] args) {

        CountDaysWithoutMeetings c = new CountDaysWithoutMeetings();

        int[][] meetings = {{2,4},{1,3}};
        int days = 5;

        System.out.println(c.countDays(days, meetings));

    }

    public int countDays(int days, int[][] meetings) {

        Arrays.sort(meetings, Comparator.comparingInt(a -> a[0]));

        int[] lastInterval = meetings[0];

        List<int[]> mergedIntervals = new ArrayList<>();

        for (int i = 1; i < meetings.length; i++){
            if (lastInterval[1] < meetings[i][0]){
                mergedIntervals.add(lastInterval);
                lastInterval = meetings[i];
            } else {
                lastInterval[0] = Math.min(lastInterval[0], meetings[i][0]);
                lastInterval[1] = Math.max(lastInterval[1], meetings[i][1]);
            }
        }

        mergedIntervals.add(lastInterval);

        int countDays = 0;

        for (int[] num : mergedIntervals){
            countDays = countDays + Math.abs(num[1] - num[0] + 1);
        }

        return days - countDays;
    }

}
