package com.dsa.StackAndQueues;

import java.util.Arrays;

public class QueueUsingArray {

    static int start = -1;
    static int end = -1;
    static int currentSize = 0;
    static int[] queue;
    static int size = 10;
    public static void main(String[] args) {
        start = -1;
        end = -1;
        currentSize = 0;
        queue = new int [size];

        push(10);
        push(20);

        System.out.println(Arrays.toString(queue));

        System.out.println(pop());

        System.out.println(Arrays.toString(queue));

        System.out.println(top());

        System.out.println(size());

    }

    public static void push(int x){
        if (currentSize == size){
            System.out.println("Queue is full");
            return;
        }

        if (currentSize == 0){
            start = 0;
            end = 0;
        } else {
            end = (end + 1) % size;
        }
        queue[end] = x;
        currentSize += 1;
    }

    public static int pop(){
        if (currentSize == 0){
            System.out.println("Queue is empty");
            return -1;
        }
        int el = queue[start];

        if (currentSize == 1){
            start = -1;
            end = -1;
        } else {
            start = (start + 1) % size;
        }
        currentSize -= 1;
        return el;
    }

    public static int top(){
        if (currentSize == 0){
            System.out.println("Queue is empty");
            return -1;
        }

        return queue[start];
    }

    public static int size(){
        return currentSize;
    }


}
