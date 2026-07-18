package com.dsa.PatternWise.Intervals;

import java.util.*;

public class NMeetingInOneRoom {
    public static void main(String[] args) {
        int[] start = {1, 4, 6, 9};
        int[] end = {2, 5, 7, 12};

        NMeetingInOneRoom nMeetingInOneRoom = new NMeetingInOneRoom();
        System.out.println(nMeetingInOneRoom.maxMeetings(start, end));
    }

    public int maxMeetings(int[] start, int[] end) {
        int n = start.length;
        if (n == 0) return 0;

        List<int[]> meetings = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            meetings.add(new int[]{start[i], end[i]});
        }

        meetings.sort(Comparator.comparingInt(a -> a[1]));

        int count = 1;
        int lastEnd = meetings.get(0)[1];

        for (int i = 1; i < n; i++) {
            if (meetings.get(i)[0] > lastEnd) {
                count++;
                lastEnd = meetings.get(i)[1];
            }
        }
        return count;
    }
}
