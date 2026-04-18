package com.dsa.LinkedList;

public class FlatteningLL {
    public static void main(String[] args) {

    }

    public ListNode flattenLinkedList(ListNode head) {
        if (head == null || head.next == null){
            return head;
        }

        ListNode newNode = flattenLinkedList(head.next);
        ListNode mergeNode = mergeTwoLists(head, newNode);

        return mergeNode.child;
    }

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2){
        ListNode dummyNode = new ListNode(-1);
        ListNode res = dummyNode;

        while (l1 != null && l2 != null){
            if (l1.val < l2.val){
                res.child = l1;
                res = l1;
                l1 = l1.child;
            } else {
                res.child = l2;
                res = l2;
                l2 = l2.child;
            }
            res.next = null;
        }

        if (l1 != null){
            res.child = l1;
        } else {
            res.child = l2;
        }
        return dummyNode.child;
    }
}
