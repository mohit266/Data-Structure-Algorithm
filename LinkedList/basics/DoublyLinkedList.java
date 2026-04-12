package com.dsa.LinkedList.basics;

import com.dsa.LinkedList.DLLNode;

public class DoublyLinkedList {
    public static void main(String[] args) {
        int [] arr = {1, 5, 7, 9, 10};

        DLLNode head = convertToDLL(arr);
        printDLL(head);

        // Delete head
//        DLLNode deleteHead = deleteHead(head);
//        printDLL(deleteHead);

        // Delete tail
//        DLLNode deleteTail = deleteTail(head);
//        printDLL(deleteTail);

        // Delete kth element
//        DLLNode deleteKNode = deleteKthNode(head, 1);
//        printDLL(deleteKNode);

        // Insert new node before head
        DLLNode insertHead = insertNodeBeforeHead(head, 0);
        printDLL(insertHead);
    }


    public static DLLNode insertNodeBeforeHead(DLLNode head, int el){
        DLLNode newNode = new DLLNode(null, el ,head);

        head.back = newNode;
        return newNode;
    }

    public static DLLNode deleteKthNode(DLLNode head, int k){

        int cnt = 0;

        DLLNode temp = head;
        // {1, 5, 7, 9, 10};

        while (temp != null){
            cnt++;

            if (cnt == k){
                break;
            }
            temp = temp.next;
        }

        DLLNode prev = temp.back;
        DLLNode front = temp.next;

        if (prev == null && front == null){
            return null;
        } else if (prev == null) {
            head = temp.next;
            temp.next = null;
            return head;
        } else if (front == null) {
            prev.next = null;
            temp.back = null;
            return head;
        } else {
            prev.next = front;
            front.back = prev;
            temp.back = null;
            temp.next = null;
            return head;
        }
    }

    public static DLLNode convertToDLL(int[] arr){

        DLLNode head = new DLLNode(arr[0]);
        DLLNode mover = head;
        for (int i = 1 ; i < arr.length; i++){
            DLLNode temp = new DLLNode(mover, arr[i], null);
            mover.next = temp;
            mover = temp;
        }
        return head;
    }

    public static void printDLL(DLLNode head){
        DLLNode temp = head;

        while (temp != null){
            System.out.print(temp.data + " ");
            temp = temp.next;
        }

        System.out.println();
    }

    public static DLLNode deleteHead(DLLNode head){
        if (head == null || head.next == null){
            return null;
        }

        DLLNode prev = head;

        head = prev.next;
        head.back = null;
        prev.next = null;

        return head;
    }

    public static DLLNode deleteTail(DLLNode head){
        DLLNode tail = head;

        while (tail.next != null){
            tail = tail.next;
        }

        DLLNode prev = tail.back;
        prev.next = null;
        tail.back = null;
        return head;
    }
}
