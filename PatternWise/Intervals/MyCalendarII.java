package com.dsa.PatternWise.Intervals;

import java.util.Map;
import java.util.TreeMap;


// 731. My Calendar II
public class MyCalendarII {

    TreeMap<Integer, Integer> tm;
    int numOfBookingAllowed;

    public static void main(String[] args) {
        MyCalendarII mc = new MyCalendarII();

        System.out.println(mc.book(10,20));
        System.out.println(mc.book(50,60));
        System.out.println(mc.book(10,40));
        System.out.println(mc.book(5,15));
        System.out.println(mc.book(5,10));
        System.out.println(mc.book(25,55));

    }

    public MyCalendarII() {
        tm = new TreeMap<>();
        numOfBookingAllowed = 2;
    }

    public boolean book(int startTime, int endTime) {
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
