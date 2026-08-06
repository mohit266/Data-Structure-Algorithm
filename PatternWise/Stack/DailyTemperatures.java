package com.dsa.PatternWise.Stack;

import java.util.Arrays;
import java.util.Stack;

// 739. Daily Temperatures
public class DailyTemperatures {

    public static void main(String[] args) {
        DailyTemperatures d = new DailyTemperatures();
        int[] temperatures = {73,74,75,71,69,72,76,73};

        System.out.println(Arrays.toString(d.dailyTemperatures(temperatures)));
    }

    public int[] dailyTemperatures(int[] temperatures) {

        Stack<int[]> st = new Stack<>();

        for (int i = temperatures.length - 1; i >= 0; i--){

            while (!st.isEmpty() && st.peek()[0] <= temperatures[i]){
                st.pop();
            }

            int nextGreater = 0;
            if (!st.isEmpty()){
                nextGreater = st.peek()[1] - i;
            }

            st.push(new int[] {temperatures[i], i});
            temperatures[i] = nextGreater;
        }
        return temperatures;
    }

}
