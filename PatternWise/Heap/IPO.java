package com.dsa.PatternWise.Heap;

import java.util.Collections;
import java.util.PriorityQueue;

// 502. IPO
public class IPO {

    public static void main(String[] args) {
        IPO ipo = new IPO();

        int k = 2;
        int w = 0;
        int[] profits = {1,2,3};
        int[] capital = {0,1,1};

        System.out.println(ipo.findMaximizedCapital(k, w, profits, capital));

    }

    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        PriorityQueue<int[]> capitalPQ = new PriorityQueue<>(
                (a, b) -> Integer.compare(a[1], b[1]));

        PriorityQueue<Integer> profitPQ = new PriorityQueue<>(Collections.reverseOrder());

        for (int i = 0; i < capital.length; i++) {
            capitalPQ.offer(new int[] { profits[i], capital[i] });
        }

        while (k > 0) {
            while (!capitalPQ.isEmpty() &&
                    capitalPQ.peek()[1] <= w) {

                profitPQ.offer(capitalPQ.poll()[0]);
            }

            if (profitPQ.isEmpty()) {
                break;
            }

            w += profitPQ.poll();

            k--;
        }

        return w;
    }
}