package com.dsa.BinarySearch;

public class SmallestDivisorWithGIvenThreshold {
    public static void main(String[] args) {
        int[] arr = {1,2,5,9};
        int threshold = 6;

        System.out.println(smallestDivisor(arr, threshold));
    }

    public static int smallestDivisor(int[] nums, int threshold) {
        int low = 1;
        int high = getMaxElement(nums);

        int smallestDiv = 1;

        while (low <= high){
            int mid = (low+high)/2;

            int sumOfDivisor = findSumOfDivisor(nums, mid);

            if (sumOfDivisor <= threshold){
                smallestDiv = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return smallestDiv;

    }

    public static int findSumOfDivisor(int[] nums, int divisor){
        int sum = 0;

        // ceil(a/b) = (a + b - 1) / b
        for (int n : nums){
            sum = sum + (n + divisor - 1)/divisor;
        }
        return sum;
    }

    public static int getMaxElement(int[] nums){
        int max = Integer.MIN_VALUE;

        for (int n : nums){
            max = Math.max(max,n);
        }
        return max;
    }
}
