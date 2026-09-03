package com.dsa.PatternWise.BinarySearch;

// 378. Kth Smallest Element in a Sorted Matrix
public class KthSmallestElementInSortedMatrix {

    public static void main(String[] args) {

        KthSmallestElementInSortedMatrix kSmallest = new KthSmallestElementInSortedMatrix();

        int[][] matrix = {{1,5,9},{10,11,13},{12,13,15}};
        int k = 8;

        System.out.println(kSmallest.kthSmallest(matrix,k));
    }


    public int kthSmallest(int[][] matrix, int k) {
        int m = matrix.length;
        int n = matrix[0].length;

        int low = matrix[0][0];
        int high = matrix[m-1][n-1];

        int ans = -1;

        while (low <= high){
            int mid = low + (high - low)/2;

            if (getSmallestElementsCount(matrix, mid, m, n) >= k){
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }


    public int getSmallestElementsCount(int[][] matrix, int target, int m, int n){

        int row = m - 1;
        int col = 0;

        int count = 0;

        while (row >= 0 && col < n){

            if (matrix[row][col] <= target){
                count = count + row + 1;
                col++;
            } else {
                row--;
            }
        }
        return count;
    }

}
