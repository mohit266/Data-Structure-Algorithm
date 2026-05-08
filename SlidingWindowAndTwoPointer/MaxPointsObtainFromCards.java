package com.dsa.SlidingWindowAndTwoPointer;

public class MaxPointsObtainFromCards {
    public static void main(String[] args) {

        MaxPointsObtainFromCards m = new MaxPointsObtainFromCards();

        int[] cardPoints = {1,2,3,4,5,6,1};
        int k = 3;

        System.out.println(m.maxScore(cardPoints, k));
    }

    public int maxScore(int[] cardPoints, int k) {
        int n = cardPoints.length;

        int total = 0;
        for (int i = 0; i < k; i++) {
            total += cardPoints[i];
        }

        int maxPoints = total;

        for (int i = 0; i < k; i++) {
            total -= cardPoints[k - 1 - i];
            total += cardPoints[n - 1 - i];
            maxPoints = Math.max(maxPoints, total);
        }
        return maxPoints;
    }
}
