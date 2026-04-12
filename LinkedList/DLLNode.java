package com.dsa.LinkedList;

public class DLLNode {
    public DLLNode back;
    public int data;
    public DLLNode next;

    public DLLNode(int data1){
        this.back = null;
        this.data = data1;
        this.next = null;
    }

    public DLLNode(DLLNode back, int data1, DLLNode next){
        this.back = back;
        this.data = data1;
        this.next = next;
    }
}
