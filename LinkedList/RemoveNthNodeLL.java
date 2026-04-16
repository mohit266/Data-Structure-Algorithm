package com.dsa.LinkedList;

import static com.dsa.LinkedList.Utility.convertArrayToLL;
import static com.dsa.LinkedList.Utility.printLL;

public class RemoveNthNodeLL {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        int n = 2;

        Node head = convertArrayToLL(arr);
        Node reverseNode = removeNthFromEnd(head, n);
        printLL(reverseNode);
    }
    public static Node removeNthFromEnd(Node head, int n) {
        if (head == null) return null;

        Node fast = head;
        for (int i = 0; i < n; i++){
            fast = fast.next;
        }

        if (fast == null){
            return head.next;
        }

        Node slow = head;

        while (fast.next != null){
            slow = slow.next;
            fast = fast.next;
        }

        Node delNode = slow.next;
        slow.next = delNode.next;
        delNode.next = null;

        return head;


    }

}
