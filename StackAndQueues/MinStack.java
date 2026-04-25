package com.dsa.StackAndQueues;

import java.util.Stack;

public class MinStack {

    static Stack<Long> st;
    static long prevMin;

    public static void main(String[] args) {
        st = new Stack<>();

        push(-2);
        push(0);
        push(-3);
        System.out.println("Get Min " +getMin());
        pop();
        System.out.println("Top "+top());
        System.out.println("Get Min " +getMin());
    }


    public static void push(int val) {
        if (st.isEmpty()) {
            st.push((long) val);
            prevMin = val;
        } else if (val < prevMin) {
            st.push(2L * val - prevMin);
            prevMin = val;
        } else {
            st.push((long) val);
        }
    }

    public static void pop() {
        if (st.isEmpty()) return;

        if (st.peek() < prevMin) {
            prevMin = 2 * prevMin - st.peek();
        }
        st.pop();
    }

    public static int top() {
        if (st.isEmpty()) return -1;

        if (st.peek() < prevMin) {
            return (int) prevMin;
        }
        return st.peek().intValue();
    }

    public static int getMin() {
        if (st.isEmpty()) return -1;
        return (int) prevMin;
    }

}
