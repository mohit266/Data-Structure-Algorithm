package com.dsa.LinkedList;

import static com.dsa.LinkedList.Utility.convertArrayToLL;
import static com.dsa.LinkedList.Utility.printLL;

public class PalindromeLL {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 2, 1};
        Node head = convertArrayToLL(arr);
        System.out.println(isPalindrome(head));
        printLL(head);
    }

    public static boolean isPalindrome(Node head) {
        if (head.next == null) return true;
        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        Node reverseNode = reverseList(slow);

        Node firstNode = head;
        Node secondNode = reverseNode;

        while (firstNode != null && secondNode != null){
            if (firstNode.data != secondNode.data){
                reverseList(reverseNode);
                return false;
            }
            firstNode = firstNode.next;
            secondNode = secondNode.next;

        }
        reverseList(reverseNode);
        return true;
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
}
