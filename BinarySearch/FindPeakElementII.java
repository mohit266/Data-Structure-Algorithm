package com.dsa.BinarySearch;

import java.util.Arrays;

public class FindPeakElementII {
    public static void main(String[] args) {
        int[][] mat = {
                    {10,20,15},
                    {21,30,14},
                    {7,16,32}
                };
        System.out.println(Arrays.toString(findPeakGrid(mat)));
    }

    public static int[] findPeakGrid(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;

        int low = 0;
        int high = m-1;

        while (low <= high){
            int mid = (low+high)/2;
            int index = findMaxElementIndex(mat, n, mid);

            int left = mid -1 >= 0 ? mat[index][mid-1]: -1;
            int right = mid + 1 < m  ? mat[index][mid+1] : -1;

            if (mat[index][mid] > left && mat[index][mid] > right){
                return new int[] {index, mid};
            } else if (mat[index][mid] < left) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return new int[]{-1,-1};
    }

    private static int findMaxElementIndex(int[][] mat, int n, int mid) {
        int maxValue = -1;
        int index = -1;

        for (int i =0; i<n; i++){
            if (mat[i][mid] > maxValue){
                maxValue = mat[i][mid];
                index = i;
            }
        }
        return index;
    }
}
