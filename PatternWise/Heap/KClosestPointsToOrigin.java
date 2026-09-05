package com.dsa.PatternWise.Heap;

import java.util.Arrays;
import java.util.PriorityQueue;

// 973. K Closest Points to Origin
public class KClosestPointsToOrigin {
    public static void main(String[] args) {

        KClosestPointsToOrigin obj = new KClosestPointsToOrigin();

        int[][] points = {{1,3},{-2,2}};
        int k = 1;

        System.out.println(Arrays.deepToString(obj.kClosest(points, k)));
    }

    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<double[]> pq = new PriorityQueue<>( (a, b) -> Double.compare(b[0], a[0]));

        for (int i = 0; i < points.length; i++){
            double distance = getDistance(points[i]);
            pq.offer(new double[] {distance, i});

            if (pq.size() > k){
                pq.poll();
            }
        }

        int[][] result = new int[k][2];

        for (int i = k-1; i >= 0; i--){
            if (!pq.isEmpty()){
                result[i] = points[(int) pq.poll()[1]];
            }
        }

        return result;
    }

    public double getDistance(int[] arr){
        return Math.sqrt(arr[0]*arr[0] + arr[1]*arr[1]);
    }
}
