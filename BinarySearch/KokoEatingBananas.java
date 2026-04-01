package com.dsa.BinarySearch;

public class KokoEatingBananas {
    public static void main(String[] args) {
        int[] piles = {3,6,7,11};
        int maxHours = 8;

        System.out.println(minEatingSpeed(piles, maxHours));
    }

    public static int minEatingSpeed(int[] piles, int h) {
        int low = 0;
        int high = maxElement(piles);

        int minEatingSpeed = high;

        while (low <= high){
            int mid = (low+high)/2;

            int totalHours = getTotalHours(piles, mid);

            if (totalHours <= h){
                minEatingSpeed = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return minEatingSpeed;
    }

    private static int getTotalHours(int[] piles, int hourly) {

        double totalHours = 0;

        for (int n : piles){
           totalHours = totalHours + Math.ceil((double) n /hourly);
        }
        return (int) totalHours;
    }

    private static int maxElement(int[] piles) {
        int max = piles[0];

        for (int n : piles){
            max = Math.max(max, n);
        }
        return max;
    }
}
