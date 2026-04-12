package com.dsa.LinkedList;

public class Utility {
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

    public static void printLL(Node head){
        Node temp = head;
        while (temp != null){
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    public static Node convertArrayToLL(int[] arr){
        Node head = new Node(arr[0]);
        Node mover = head;

        for (int i = 1; i < arr.length; i++){
            Node temp = new Node(arr[i]);
            mover.next = temp;
            mover = temp;
        }
        return head;
    }

}
