package com.dsa.BinarySearch;

public class MedianOfSortedArrays {
    public static void main(String[] args) {
        int[] nums2 = {3,4};
        int[] nums1 = {1,2};

        System.out.println(findMedianSortedArrays(nums1, nums2));
    }


    // Optimal approach -- Not to use merge sort
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums2.length < nums1.length) return findMedianSortedArrays(nums2, nums1);

        int n1 = nums1.length;
        int n2 = nums2.length;

        int low = 0;
        int high = n1;

        while (low <= high){
            int cut1 = (low+high)/2;
            int cut2 = ((n1+n2+1)/2)-cut1;

            int left1 = cut1 == 0 ? Integer.MIN_VALUE : nums1[cut1-1];
            int left2 = cut2 == 0 ? Integer.MIN_VALUE : nums2[cut2-1];

            int right1 = cut1 == n1 ? Integer.MAX_VALUE : nums1[cut1];
            int right2 = cut2 == n2 ? Integer.MAX_VALUE : nums2[cut2];

            if (left1 <= right2 && left2 <= right1){
                if ((n1+n2) % 2 == 0){
                    return (Math.max(left1, left2) + Math.min(right1, right2)) /2.0;
                } else {
                    return Math.max(left1, left2);
                }
            } else if (left1 > right2) {
                high = cut1 - 1;
            } else {
                low = cut1 + 1;
            }
        }
        return 0.0;
    }


    // Brute force solution

    public static double medianOfSortedArrays(int[] nums1, int[] nums2) {
        int[] arr = combineSortedArray(nums1, nums2);

        int low = 0;
        int high = arr.length;
        int mid = (low+high)/2;

        if (arr.length % 2 != 0){
            return arr[mid];
        } else {
            return (double) (arr[mid] + arr[mid - 1]) /2;
        }

    }

    public static int[] combineSortedArray(int[] arr1, int[] arr2){
        int i = 0;
        int j = 0;

        int k =0;
        int[] newArray = new int[arr1.length + arr2.length];

        while (i < arr1.length && j < arr2.length){
            if (arr1[i] <= arr2[j]){
                newArray[k] = arr1[i];
                i++;
            } else {
                newArray[k] = arr2[j];
                j++;
            }
            k++;
        }

        for (int l = i; l<arr1.length; l++){
            newArray[k] = arr1[l];
            k++;
        }

        for (int m = j; m<arr2.length; m++){
            newArray[k] = arr2[m];
            k++;
        }

        return newArray;
    }

}
