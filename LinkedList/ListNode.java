package com.dsa.LinkedList;

public class ListNode {
    int val;
    ListNode next;
    ListNode child;
    ListNode random;

    ListNode() {
        val = 0;
        next = null;
        child = null;
        random = null;
    }

    ListNode(int data1) {
        val = data1;
        next = null;
        child = null;
        random = null;
    }

    ListNode(int data1, ListNode next1, ListNode next2, ListNode next3) {
        val = data1;
        next = next1;
        child = next2;
        random = next3;
    }
}
