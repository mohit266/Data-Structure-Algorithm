package com.dsa.DailyChallenges;

import java.util.Arrays;

public class MinimumTotalPriceAfterApplyingDiscounts {

    public static void main(String[] args) {
        int[] prices = {10,30,21};
        int[] discounts = {50,60};

        MinimumTotalPriceAfterApplyingDiscounts m = new MinimumTotalPriceAfterApplyingDiscounts();

        System.out.println(m.minPrice(prices, discounts));
    }

    public double minPrice(int[] prices, int[] discounts) {
        Arrays.sort(prices);
        Arrays.sort(discounts);

        int i = prices.length - 1;
        int j = discounts.length - 1;

        double minPrice = 0.0;

        while (i >= 0 && j >= 0){
            minPrice += (prices[i] * (100.0 - discounts[j]) / 100.0);
            i--;
            j--;
        }

        while (i >= 0) {
            minPrice += prices[i];
            i--;
        }

        return minPrice;
    }

}


