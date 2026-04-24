package com.dsa.StackAndQueues;

import java.util.Stack;

public class QueueUsingStack {

    static Stack<Integer> st;
    static Stack<Integer> st2;

    public static void main(String[] args) {
        st = new Stack<>();
        st2 = new Stack<>();

        System.out.println(st);

        push(1);
        push(2);
        System.out.println(peek());
        System.out.println(pop());
        System.out.println(empty());
    }

    public static void push(int x) {

        while(!st.isEmpty()){
            st2.push(st.pop());
        }
        st.push(x);

        while (!st2.isEmpty()){
            st.push(st2.pop());
        }
    }

    public static int pop() {
        if (st.isEmpty()){
            return -1;
        }
        return st.pop();
    }

    public static int peek() {
        return st.peek();
    }

    public static boolean empty() {
        return st.isEmpty();
    }
}
