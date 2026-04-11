package com.dsa.LinkedList.basics;

import com.dsa.LinkedList.DoublyLinkedListNode;

public class DoublyLinkedList {
    public static void main(String[] args) {
        int [] arr = {1, 5, 7, 9, 10};

        DoublyLinkedListNode head = convertToDLL(arr);
        printDLL(head);

        // Delete head
//        DoublyLinkedListNode deleteHead = deleteHead(head);
//        printDLL(deleteHead);

        // Delete tail
        DoublyLinkedListNode deleteTail = deleteTail(head);
        printDLL(deleteTail);
    }

    public static DoublyLinkedListNode convertToDLL(int[] arr){

        DoublyLinkedListNode head = new DoublyLinkedListNode(arr[0]);
        DoublyLinkedListNode mover = head;
        for (int i = 1 ; i < arr.length; i++){
            DoublyLinkedListNode temp = new DoublyLinkedListNode(mover, arr[i], null);
            mover.next = temp;
            mover = temp;
        }
        return head;
    }

    public static void printDLL(DoublyLinkedListNode head){
        DoublyLinkedListNode temp = head;

        while (temp != null){
            System.out.print(temp.data + " ");
            temp = temp.next;
        }

        System.out.println();
    }

    public static DoublyLinkedListNode deleteHead(DoublyLinkedListNode head){
        if (head == null || head.next == null){
            return null;
        }

        DoublyLinkedListNode prev = head;

        head = prev.next;
        head.back = null;
        prev.next = null;

        return head;
    }

    public static DoublyLinkedListNode deleteTail(DoublyLinkedListNode head){
        DoublyLinkedListNode tail = head;

        while (tail.next != null){
            tail = tail.next;
        }

        DoublyLinkedListNode prev = tail.back;
        prev.next = null;
        tail.back = null;
        return head;
    }
}
