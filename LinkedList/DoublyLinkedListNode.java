package com.dsa.LinkedList;

public class DoublyLinkedListNode {
    public DoublyLinkedListNode back;
    public int data;
    public DoublyLinkedListNode next;

    public DoublyLinkedListNode(int data1){
        this.back = null;
        this.data = data1;
        this.next = null;
    }

    public DoublyLinkedListNode(DoublyLinkedListNode back, int data1, DoublyLinkedListNode next){
        this.back = back;
        this.data = data1;
        this.next = next;
    }
}
