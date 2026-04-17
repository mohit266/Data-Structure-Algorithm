package com.dsa.LinkedList;

import static com.dsa.LinkedList.Utility.convertToDLL;
import static com.dsa.LinkedList.Utility.printDLL;

public class DeleteAllOccurrenceOfKeyInDLL {
    public static void main(String[] args) {
        int [] arr = {2, 3, 2, -1, 4, 2};

        DLLNode head = convertToDLL(arr);
        DLLNode rev = deleteAllOccurrences(head, 2);
        printDLL(rev);
    }

    public static DLLNode deleteAllOccurrences(DLLNode head, int target) {

        DLLNode temp = head;
        DLLNode nextNode = null;
        DLLNode prevNode = null;

        while (temp!= null){
            if (temp.data == target){
                if (temp == head){
                    head = head.next;
                }
                nextNode = temp.next;
                prevNode = temp.back;

                if (nextNode != null){
                    nextNode.back = prevNode;
                }
                if (prevNode != null){
                    prevNode.next = nextNode;
                }
                temp = nextNode;
            } else  {
                temp = temp.next;
            }
        }

        return head;


    }
}
