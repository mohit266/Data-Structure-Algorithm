package com.dsa.PatternWise.Intervals;

import java.util.*;

// 729. My Calendar I
class MyCalendar {

    List<int[]> intervals;
    int[] lastInterval;
    TreeMap<Integer, Integer> tm;
    int numOfBookingAllowed;

    public static void main(String[] args) {
        MyCalendar myCalendar = new MyCalendar();
        System.out.println(myCalendar.book(47,50));
        System.out.println(myCalendar.book(33,41));
        System.out.println(myCalendar.book(39,45));
        System.out.println(myCalendar.book(33,42));
        System.out.println(myCalendar.book(25,32));
        System.out.println(myCalendar.book(26,35));
        System.out.println(myCalendar.book(19,25));
        System.out.println(myCalendar.book(3,8));
        System.out.println(myCalendar.book(8,13));
        System.out.println(myCalendar.book(18,27));
    }

    public MyCalendar() {
        intervals = new ArrayList<>();
        lastInterval = new int[2];
        tm = new TreeMap<>();
        numOfBookingAllowed = 1;
    }

    public boolean book(int startTime, int endTime) {
        
        if (intervals.isEmpty()){
            intervals.add(new int[] {startTime, endTime});
            return true;
        }

        int[] newInterval = {startTime, endTime};

        for (int[] interval : intervals) {
            if (interval[1] <= newInterval[0]) {
                continue;
            }
            if (Math.max(startTime, endTime) <= interval[0]){
                continue;
            }
            return false;
        }
        intervals.add(newInterval);
        intervals.sort(Comparator.comparingInt(a -> a[0]));
        return true;
    }

    public boolean bookUsingLineSweepAlgo(int startTime, int endTime) {

        tm.put(startTime, tm.getOrDefault(startTime, 0) + 1);
        tm.put(endTime, tm.getOrDefault(endTime, 0) - 1);

        int numberOfBooking = 0;

        for (Map.Entry<Integer, Integer> mp : tm.entrySet()) {

            numberOfBooking += mp.getValue();

            if (numberOfBooking > numOfBookingAllowed) {
                tm.put(startTime, tm.getOrDefault(startTime, 0) - 1);
                tm.put(endTime, tm.getOrDefault(endTime, 0) + 1);

                if (tm.get(startTime) == 0) {
                    tm.remove(startTime);
                }
                if (tm.get(endTime) == 0) {
                    tm.remove(endTime);
                }
                return false;
            }
        }
        return true;
    }
}