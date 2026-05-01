package com.dsa.StackAndQueues;

public class DLLNode {
    public DLLNode back;
    public int key;
    public int value;
    public int cnt;
    public DLLNode next;


    public DLLNode(int key, int value){
        this.back = null;
        this.key = key;
        this.value = value;
        this.cnt = 1;
        this.next = null;
    }
}

