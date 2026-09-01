package com.dsa.PatternWise.BinarySearch;

// 852. Peak Index in a Mountain Array
public class PeakIndexInMountainArray {

    public static void main(String[] args) {
        PeakIndexInMountainArray p = new PeakIndexInMountainArray();
        int[] arr = {24,69,100,99,79,78,67,36,26,19};

        System.out.println(p.peakIndexInMountainArray(arr));
    }

    public int peakIndexInMountainArray(int[] arr) {
        int low = 0;
        int high = arr.length - 1;

        int ans = -1;
        while (low <= high){
            int mid = low + (high - low)/2;

            if (arr[mid] < arr[mid + 1]){
                low = mid + 1;
            } else {
                ans = mid;
                high = mid -1;
            }
        }

        return ans;
    }
}
