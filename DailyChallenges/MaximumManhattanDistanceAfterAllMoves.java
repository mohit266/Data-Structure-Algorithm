package com.dsa.DailyChallenges;

import java.util.Arrays;

public class MaximumManhattanDistanceAfterAllMoves {

    public static void main(String[] args) {

        MaximumManhattanDistanceAfterAllMoves m = new MaximumManhattanDistanceAfterAllMoves();

        String moves = "_L";
        System.out.println(m.maxDistance(moves));
    }


    public int maxDistance(String moves) {
        int x = 0;
        int y = 0;
        int count=0;
        for(char c : moves.toCharArray())
        {
            switch(c)
            {
                case 'L': y--; break;
                case 'R': y++; break;
                case 'U': x++; break;
                case 'D': x--; break;
                case '_': count++; break;
            }
        }

        return Math.abs(x)+Math.abs(y)+count;
    }

}
