package com.dsa.LinkedList;

import static com.dsa.LinkedList.Utility.convertToDLL;
import static com.dsa.LinkedList.Utility.printDLL;

public class RemovesDuplicateFromSortedDLL {
    public static void main(String[] args) {
        int [] arr = {1, 1, 3, 3, 4, 5};

        DLLNode head = convertToDLL(arr);
        DLLNode rev = removeDuplicates(head);
        printDLL(rev);
    }

    public static DLLNode removeDuplicates(DLLNode head) {
        DLLNode temp = head.next;
        DLLNode prevNode;
        DLLNode nextNode;

        while (temp != null && temp.next != null){
            prevNode = temp.back;
            nextNode = temp.next;

            if (temp.data == prevNode.data){
                prevNode.next = temp.next;
                nextNode.back = prevNode;
                temp.back = null;
                temp.next = null;
                temp = nextNode;
            } else {
                temp = temp.next;
            }
        }
        return head;
    }
}
