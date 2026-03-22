package com.dsaAtoZ.Array;

import java.util.HashMap;
import java.util.Map;

public class LongestSubArrayWithNegativeValue {
    public static void main(String[] args) {
        // sample input
        int[] A = new int[]{9, -3, 3, -1, 6, -5};
        // compute size
        int n = A.length;
        // compute result
        int ans =  maxLen(A, n);
        // print result
        System.out.println(ans);
    }

    public static int maxLen(int[] A, int n) {
        // map prefix sum -> first index seen
        Map<Integer, Integer> mpp = new HashMap<>();
        // best length so far
        int maxi = 0;
        // running prefix sum
        int sum = 0;

        // iterate over the array
        for (int i = 0; i < n; i++) {
            // update running sum
            sum += A[i];

            // if sum is zero, subarray [0..i] has zero sum
            if (sum == 0) {
                // update best length
                maxi = i + 1;
            }
            // otherwise check if this sum was seen before
            else {
                // when seen, zero-sum segment between previous index + 1 and i
                if (mpp.containsKey(sum)) {
                    // maximize length
                    maxi = Math.max(maxi, i - mpp.get(sum));
                }
                // first time seeing this sum
                else {
                    // record index
                    mpp.put(sum, i);
                }
            }
        }

        // return best length
        return maxi;
    }
}
