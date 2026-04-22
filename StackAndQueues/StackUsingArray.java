package com.dsa.StackAndQueues;

import java.util.Arrays;

public class StackUsingArray {

    static int top = -1;
    static int[] st;

    public static void main(String[] args) {
        top = -1;
        st = new int[10];

        push(10);
        push(5);
        push(1);
        push(3);
        System.out.println(Arrays.toString(st));

    }

    public static void push(int x){
        if (top >= size()){
            System.out.println("Stack is full");
        } else {
            top = top + 1;
            st[top] = x;
        }
    }

    public static int pop(){
        int el = -1;
        if (top == -1){
            System.out.println("Stack is empty");
        } else {
            el = st[top];
            top = top - 1;
        }
        return el;
    }

    public static int top(){
        if (top != -1){
            return st[top];
        } else {
            System.out.println("Stack is empty");
            return top;
        }
    }

    public static int size(){
        return top + 1;
    }

}
