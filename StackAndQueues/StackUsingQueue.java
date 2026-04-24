package com.dsa.StackAndQueues;

import java.util.LinkedList;
import java.util.Queue;

public class StackUsingQueue {

    static Queue<Integer> q = new LinkedList<>();

    public StackUsingQueue(){
        q = new LinkedList<>();
    }

    public static void main(String[] args) {
        push(10);
        push(20);
        push(30);

        System.out.println(pop());

        System.out.println(q);
        System.out.println(top());
        System.out.println(empty());
    }

    static void push(int x){
        if (q.isEmpty()){
            q.add(x);
            return;
        }
        int size = q.size();
        q.add(x);
        for (int i = 1; i <= size; i++){
            q.add(q.poll());
        }
    }

    static int pop(){
        if (q.isEmpty()){
            return -1;
        }
        return q.poll();
    }

    static int top(){
        if (q.isEmpty()){
            return -1;
        }
        return q.peek();
    }

    static boolean empty(){
        return q.isEmpty();
    }



}
