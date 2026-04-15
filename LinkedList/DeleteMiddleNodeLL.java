package com.dsa.LinkedList;

import static com.dsa.LinkedList.Utility.convertArrayToLL;
import static com.dsa.LinkedList.Utility.printLL;

public class DeleteMiddleNodeLL {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        Node head = convertArrayToLL(arr);
        Node newHead = deleteMiddle(head);
        printLL(newHead);
    }

    public static Node deleteMiddle(Node head) {
        if (head == null || head.next == null) return null;
        Node slow = head;
        Node fast = head;
        Node prevNode = head;

        while (fast != null && fast.next != null){
            prevNode = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        prevNode.next = slow.next;
        slow.next = null;

        return head;

    }
}
