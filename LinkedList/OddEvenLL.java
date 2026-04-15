package com.dsa.LinkedList;

import static com.dsa.LinkedList.Utility.convertArrayToLL;
import static com.dsa.LinkedList.Utility.printLL;

public class OddEvenLL {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        Node head = convertArrayToLL(arr);
        Node oddEvenNode = oddEvenList(head);
        printLL(oddEvenNode);
    }

    public static Node oddEvenList(Node head) {
        Node odd = head;
        Node even = head.next;
        Node evenHead = even;

        while (even !=null && even.next != null){
            odd.next = even.next;
            odd = odd.next;

            even.next = odd.next;
            even = even.next;
        }
        odd.next = evenHead;
        return head;
    }
}
