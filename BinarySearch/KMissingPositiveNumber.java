package com.dsa.BinarySearch;

public class KMissingPositiveNumber {
    public static void main(String[] args) {
        int[] arr = {4, 7, 9, 10};
//        3, 5, 6, 6
        int k = 4;


        System.out.println(missingK(arr,k));
    }

    public static int missingK(int[] arr, int k) {
        int low = 0, high = arr.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;

            // Number of missing elements before index mid
            int missing = arr[mid] - (mid + 1);

            if (missing < k) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return low+k;
    }
}
