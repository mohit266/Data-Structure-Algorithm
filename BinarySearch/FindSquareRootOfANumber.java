package com.dsa.BinarySearch;

public class FindSquareRootOfANumber {
    public static void main(String[] args) {
        System.out.println(floorSqrt(28));
    }

    public static int floorSqrt(int n) {
        int low = 1;
        int high = n;

        while (low <= high){
            int mid = (low+high)/2;
            int square = mid * mid;

            if (square <= n){
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return high;
    }
}
