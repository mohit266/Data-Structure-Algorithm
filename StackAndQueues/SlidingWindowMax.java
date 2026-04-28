package com.dsa.StackAndQueues;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class SlidingWindowMax {

    public static void main(String[] args) {
        int[] arr = {4, 0, -1, 3, 5, 3, 6, 8};
        int k = 3;

        System.out.println(Arrays.toString(maxSlidingWindow(arr, k)));
    }

    public static int[] maxSlidingWindow(int[] arr, int k) {
        Deque<Integer> dq = new LinkedList<>();
        int[] res = new int[arr.length - k + 1];

        int ins = 0;

        for (int i = 0; i < arr.length; i++) {

            if (!dq.isEmpty() && dq.peekFirst() <= (i - k)) {
                dq.pollFirst();
            }

            while (!dq.isEmpty() && arr[i] >= arr[dq.peekLast()]) {
                dq.pollLast();
            }

            dq.offerLast(i);

            if (i >= (k - 1) && !dq.isEmpty()) {
                res[ins++] = arr[dq.peekFirst()];
            }
        }
        return res;
    }
}
