package com.dsaAtoZ.Array;

// https://leetcode.com/problems/best-time-to-buy-and-sell-stock
public class BestTimeToBuyAndSellStock {
    public static void main(String[] args) {
        int[] arr = {7,1,5,3,6,4};
        System.out.println(maxProfit(arr));
    }

    public static int maxProfit(int[] prices) {
        int minimum = prices[0];
        int maxProfit = 0;
        int n = prices.length;

        for (int i=1; i<n; i++){
            int cost = prices[i] - minimum;
            maxProfit = Math.max(maxProfit, cost);
            minimum = Math.min(minimum, prices[i]);
        }
        return maxProfit;
    }

}
