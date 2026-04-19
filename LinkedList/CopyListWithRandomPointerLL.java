package com.dsa.LinkedList;

public class CopyListWithRandomPointerLL {
    public static void main(String[] args) {
        int [][] arr = {{7,-1},{13,0},{11,4},{10,2},{1,0}};
    }

    public static ListNode copyRandomList(ListNode head) {
        ListNode temp = head;

        // Insert copy nodes in between
        ListNode inBetweenNode = null;

        while(temp != null){
            ListNode front = temp.next;
            ListNode copyNode = new ListNode(temp.val);

            temp.next = copyNode;
            copyNode.next = front;

            inBetweenNode = copyNode;

            temp = inBetweenNode.next;
        }

        // Connect random pointers in copy nodes.

        temp = head;

        while (temp != null){
            ListNode randomNode = temp.random;
            ListNode copyNode = temp.next;
            if (randomNode != null && randomNode.next != null){
                copyNode.random = randomNode.next;
            } else {
                copyNode.random = null;
            }
            temp = copyNode.next;
        }

        // Connect next pointer.

        ListNode dummyNode = new ListNode(-1);
        ListNode res = dummyNode;

        temp = head;

        while (temp != null){
            ListNode front = temp.next;
            res.next = front;
            temp.next = front.next;

            res = res.next;
            temp = temp.next;

        }

        return dummyNode.next;
    }

}
