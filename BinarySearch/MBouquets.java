package com.dsa.BinarySearch;

public class MBouquets {
    public static void main(String[] args) {
        int[] arr = {7,7,7,7,12,7,7};
        int m = 2;
        int k = 3;

        System.out.println(minDays(arr, m, k));
    }

    public static int minDays(int[] bloomDay, int m, int k) {
        int[] minAndMaxValues = getMinAndMax(bloomDay);
        int low = minAndMaxValues[0];
        int high = minAndMaxValues[1];

        int ans = -1;

        while (low <= high){
            int mid = (low + high)/2;
            int numOfBouquets = getTotalNumberOfBouquets(bloomDay, k, mid);

            if (numOfBouquets >= m){
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }

    public static int getTotalNumberOfBouquets(int[] arr, int k, int day) {
        int count = 0;
        int bouquets = 0;

        for (int n : arr) {
            if (n <= day) {
                count++;

                if (count == k) {
                    bouquets++;
                    count = 0;
                }
            } else {
                count = 0;
            }
        }

        return bouquets;
    }

    public static int[] getMinAndMax(int[] arr){
        int min = arr[0];
        int max = arr[0];

        for (int n : arr){
            min = Math.min(min, n);
            max = Math.max(max, n);
        }
        return new int[] {min, max};
    }

}
