package com.dsa.GreedyAlgorithms;

import java.util.Arrays;

public class MinNoOfPlatformRequired {
    public static void main(String[] args) {

        MinNoOfPlatformRequired m1 = new MinNoOfPlatformRequired();

        int[] Arrival = {900, 940, 950, 1100, 1500, 1800};
        int[] Departure = {910, 1200, 1120, 1130, 1900, 2000};

        System.out.println(m1.findPlatform(Arrival, Departure));

    }

    public int findPlatform(int[] Arrival, int[] Departure) {
        int n = Arrival.length;
        int ans = 1;

        for (int i = 0; i < n; i++) {

            int count = 1;
            for (int j = 0; j < n; j++) {
                if (i != j) {
                    if ((Arrival[i] >= Arrival[j] && Departure[j] >= Arrival[i])) {
                        count++;
                    }
                    ans = Math.max(ans, count);
                }
            }
        }
        return ans;
    }
}
