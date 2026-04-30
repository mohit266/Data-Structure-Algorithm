package com.dsa.StackAndQueues;

public class CelebrityProblem {
    public static void main(String[] args) {
        int[][] M = {
                {0, 1, 1, 0},
                {0, 0, 0, 0},
                {1, 1, 0, 0},
                {0, 1, 1, 0}
        };
        System.out.println(celebrity(M));
    }

    public static int celebrity(int[][] M) {
        int top = 0;
        int bottom = M.length - 1;

        while (top < bottom){
            if (M[top][bottom] == 1){
                top += 1;
            } else if (M[bottom][top] == 1) {
                bottom -= 1;
            } else {
                top++;
                bottom--;
            }
        }

        if (top > bottom) return -1;

        for (int i = 0; i < M.length; i++){
            if (i == top){
                continue;
            }
            if (M[i][top] == 1 && M[top][i] == 0){
            } else {
                return -1;
            }
        }

        return top;
    }
}
