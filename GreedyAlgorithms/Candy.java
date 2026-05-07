package com.dsa.GreedyAlgorithms;

import java.util.Arrays;

public class Candy {
    public static void main(String[] args) {
        Candy c = new Candy();
        int[] ratings = {1, 0, 5};

        System.out.println(c.candy(ratings));
    }


    public int candy(int[] ratings) {

        int n = ratings.length;

        int candies = n;

        int i = 1;

        while (i < n) {
            if (ratings[i] == ratings[i - 1]) {
                i++;
                continue;
            }

            int peak = 0;

            while (i < n && ratings[i] > ratings[i - 1]) {
                peak++;
                candies += peak;
                i++;
            }

            int valley = 0;

            while (i < n && ratings[i] < ratings[i - 1]) {
                valley++;
                candies += valley;
                i++;
            }

            candies -= Math.min(peak, valley);
        }
        return candies;
    }

    public int candyBruteForce(int[] ratings) {
        int n = ratings.length;
        int[] candies = new int[n];

        Arrays.fill(candies, 1);

        // Traverse from left to right
        for (int i = 1; i < n; i++) {
            if (ratings[i] > ratings[i - 1]) {
                candies[i] = candies[i - 1] + 1;
            }
        }

        // Traverse from right to left
        for (int i = n - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1]) {
                candies[i] = Math.max(candies[i], candies[i + 1] + 1);
            }
        }

        int total = 0;
        for (int c : candies) {
            total += c;
        }
        return total;
    }


}
