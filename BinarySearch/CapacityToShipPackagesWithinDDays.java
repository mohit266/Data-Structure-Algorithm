package com.dsa.BinarySearch;

import java.util.Arrays;

public class CapacityToShipPackagesWithinDDays {
    public static void main(String[] args) {
        int[] weights = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int days = 5;

        System.out.println(shipWithinDays(weights, days));
    }

    public static int shipWithinDays(int[] weights, int days) {
        int low = getMaxElement(weights);
        int high = Arrays.stream(weights).sum();

        int minCapacity = 0;

        while (low <= high){
            int mid = (low+high)/2;
            int requiredDays = daysNeeded(weights, mid);

            if (requiredDays <= days){
                minCapacity = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return minCapacity;
    }

    public static int daysNeeded(int[] weights, int capacity) {
        int days = 1;
        int currentLoad = 0;

        for (int w : weights) {
            if (currentLoad + w > capacity) {
                days++;
                currentLoad = w;
            } else {
                currentLoad += w;
            }
        }
        return days;
    }

    public static int getMaxElement(int[] nums){
        int max = Integer.MIN_VALUE;

        for (int n : nums){
            max = Math.max(max,n);
        }
        return max;
    }
}
