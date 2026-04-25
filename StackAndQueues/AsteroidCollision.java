package com.dsa.StackAndQueues;

import java.util.Arrays;
import java.util.Stack;

public class AsteroidCollision {
    public static void main(String[] args) {
         int[] asteroids = {10, 20, -10};

        System.out.println(Arrays.toString(asteroidCollision(asteroids)));
    }

    public static int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> st = new Stack<>();
        for (int asteroid : asteroids) {
            while (!st.empty() && st.peek() > 0 && asteroid < 0){
                int res = st.peek() + asteroid;
                if (res < 0){
                    st.pop();
                } else {
                    break;
                }
            }

            if (!st.isEmpty() && asteroid < 0 && (asteroid + st.peek() == 0)){
                st.pop();
            } else {
                if (!st.empty() && ((asteroid > 0) || st.peek() < 0 && asteroid < 0)){
                    st.push(asteroid);
                }

                if (st.isEmpty()){
                    st.push(asteroid);
                }
            }

        }
        int [] res = new int[st.size()];

        int i = 0;
        for (int num : st){
            res[i] = num;
            i++;
        }
        return res;

    }
}
