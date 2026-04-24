package com.dsa.StackAndQueues;

import com.dsa.LinkedList.Node;

import static com.dsa.LinkedList.Utility.printLL;

public class QueueUsingLinkedList {
    static Node start;
    static Node end;
    static int size;


    public static void main(String[] args) {
        start = null;
        end = null;
        size = 0;

        push(10);
        push(20);

        printLL(start);

        System.out.println(pop());

        push(30);

        printLL(start);
    }

    public static void push(int x) {
        Node element = new Node(x);

        if (start == null) {
            start = end = element;
        } else {
            end.next = element;
            end = element;
        }
        size++;
    }

    public static int pop() {
        if (start == null) {
            return -1;
        }

        int value = start.data;
        Node temp = start;
        start = start.next;
        temp.next = null;
        size--;

        return value;
    }

    public static int peek() {
        if (start == null) {
            return -1;
        }

        return start.data;
    }

    public static boolean isEmpty() {
        return (size == 0);
    }

}
