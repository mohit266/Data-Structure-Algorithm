package com.dsa.LinkedList;

import static com.dsa.LinkedList.Utility.convertArrayToLL;
import static com.dsa.LinkedList.Utility.printLL;

public class ReverseLL {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};

        Node head = convertArrayToLL(arr);
        Node reverseNode = reverseList(head);
        printLL(reverseNode);

    }

    public static Node reverseList(Node head) {
        Node temp = head;
        Node prev = null;

        while (temp != null){
            Node front = temp.next;
            temp.next = prev;
            prev = temp;
            temp = front;
        }
        return prev;
    }

    // Recursive Approach
    public static Node reverseListRecursion(Node head) {
        if (head == null || head.next == null)
            return head;

        Node newHead = reverseListRecursion(head.next);
        Node front = head.next;
        front.next = head;
        head.next = null;

        return newHead;
    }

}
