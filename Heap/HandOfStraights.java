package com.dsa.Heap;

import java.util.Arrays;

public class HandOfStraights {

    public static void main(String[] args) {
        int[] hand = {1,2,3,6,2,3,4,7,8};
        int groupSize = 3;

        HandOfStraights h = new HandOfStraights();
        System.out.println(h.isNStraightHand(hand, groupSize));
    }

    public boolean isNStraightHand(int[] hand, int groupSize) {
        if (hand.length % groupSize != 0){
            return false;
        }

        Arrays.sort(hand);
        boolean[] used = new boolean[hand.length];

        for (int i = 0; i < hand.length; i++){
            if (used[i]) continue;
            used[i] = true;
            int next = hand[i] + 1;
            int count = 1;

            for (int j = i + 1; j < hand.length && count < groupSize; j++){
                if (!used[j] && hand[j] == next) {
                    used[j] = true;
                    count++;
                    next++;
                }
            }
            if (count != groupSize){
                return false;
            }

        }
        return true;
    }
}
