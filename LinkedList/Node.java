package com.dsa.LinkedList;

public class Node {
    public int data;
    public Node next;

    public Node(int data1, Node next1) {
        this.data = data1;
        this.next = next1;
    }

    public Node(int data1) {
        this.data = data1;
        this.next = null;
    }
}
