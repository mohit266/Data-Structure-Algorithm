package com.dsa.BinarySearch;

public class MatrixMedian {
    public static void main(String[] args) {
        int[][] matrix= {{1, 3, 8}, {2, 3, 4}, {1, 2, 5} };

        System.out.println(findMedian(matrix));
    }

    public static int findMedian(int[][] matrix) {
        int low = getSmallestElement(matrix);
        int high = getLargestElement(matrix);

        int requiredVal = (matrix.length * matrix[0].length)/2;

        while (low <= high){
            int mid = (low+high)/2;

            int getCountOfSmallEqual = countSmallEqual(matrix, mid);

            if (getCountOfSmallEqual <= requiredVal){
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return low;
    }

    private static int countSmallEqual(int[][] matrix, int mid) {
        int count = 0;
        for (int[] arr : matrix){
            count += getUpperBound(arr, mid);
        }
        return count;
    }

    private static int getUpperBound(int[] nums, int target) {
        int low = 0;
        int high = nums.length-1;

        while (low <= high){
            int mid = (low+high)/2;

            if (nums[mid] <= target){
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return low;
    }

    public static int getSmallestElement(int[][] matrix){
        int min = Integer.MAX_VALUE;

        for (int[] ints : matrix) {
            if (ints[0] < min) {
                min = ints[0];
            }
        }
        return min;
    }

    public static int getLargestElement(int[][] matrix){
        int max = Integer.MIN_VALUE;

        for (int[] ints : matrix) {
            if (ints[matrix[0].length - 1] > max) {
                max = ints[matrix[0].length - 1];
            }
        }
        return max;
    }

}
