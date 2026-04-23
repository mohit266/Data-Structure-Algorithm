package com.dsa.StackAndQueues;

import com.dsa.LinkedList.Node;

import static com.dsa.LinkedList.Utility.printLL;

public class StackUsingLinkedList {

    static Node head;
    static int size;

    public StackUsingLinkedList(){
        head = null;
        size = 0;
    }

    public static void main(String[] args) {
        push(10);
        push(20);

        printLL(head);

        System.out.println(pop());

        push(30);

        printLL(head);
    }

    public static void push(int x){
        Node temp = new Node(x);
        temp.next = head;
        head = temp;
        size += 1;
    }

    public static int pop(){
        Node temp = head;
        head = head.next;
        temp.next = null;
        size -= 1;
        return temp.data;
    }

    public static int top(){
        return head.data;
    }

    public static int size(){
        return size;
    }

}
