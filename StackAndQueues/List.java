package com.dsa.StackAndQueues;

class List {
    int size;
    DLLNode head;
    DLLNode tail;
    
    List() {
        head = new DLLNode(0, 0);
        tail = new DLLNode(0, 0);
        head.next = tail;
        tail.back = head;
        size = 0;
    }
    
    void addFront(DLLNode node) {
        DLLNode temp = head.next;
        node.next = temp;
        node.back = head;
        head.next = node;
        temp.back = node;
        size++;
    }
    
    void removeNode(DLLNode delnode) {
        DLLNode prevNode = delnode.back;
        DLLNode nextNode = delnode.next;
        prevNode.next = nextNode;
        nextNode.back = prevNode;
        size--;
    }
}