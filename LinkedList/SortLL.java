package com.dsa.LinkedList;

import static com.dsa.LinkedList.Utility.convertArrayToLL;
import static com.dsa.LinkedList.Utility.printLL;

public class SortLL {
    public static void main(String[] args) {
        int[] arr = {1, 4, 3, 2, 5};

        Node head = convertArrayToLL(arr);
        Node reverseNode = sortList(head);
        printLL(reverseNode);
    }

    public static Node sortList(Node head) {
        if (head == null || head.next == null) {
            return head;
        }

        Node middleHead = getMiddleNode(head);

        Node right = middleHead.next;
        middleHead.next = null;
        Node left = head;
        left = sortList(left);
        right = sortList(right);

        return mergeTwoLL(left, right);
    }

    private static Node mergeTwoLL(Node list1, Node list2) {
        Node dummyNode = new Node(-1);
        Node temp = dummyNode;

        while (list1 != null && list2 !=null){
            if (list1.data < list2.data){
                temp.next = list1;
                temp = list1;
                list1 = list1.next;
            } else {
                temp.next = list2;
                temp = list2;
                list2 = list2.next;
            }
        }

        if (list1 != null){
            temp.next = list1;
        } else {
            temp.next = list2;
        }

        return dummyNode.next;

    }

    public static Node getMiddleNode(Node head){
        Node slow = head;

        // To get one node before middle to handle even length
        Node fast = head.next;

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

}
