package com.dsa.LinkedList;

import static com.dsa.LinkedList.Utility.*;

public class ReverseDLL {
    public static void main(String[] args) {
        int [] arr = {10,20,30};

        DLLNode head = convertToDLL(arr);
        DLLNode rev = reverseDLL(head);
        printDLL(rev);
    }

    public static DLLNode reverseDLL(DLLNode head) {

        if (head == null || head.next == null){
            return head;
        }

        DLLNode temp = head;
        DLLNode prev = null;

        while(temp != null){
            prev = temp.back;
            temp.back = temp.next;
            temp.next = prev;

            temp = temp.back;
        }
        return prev.back;
    }

}
