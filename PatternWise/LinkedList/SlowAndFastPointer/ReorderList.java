package com.dsa.PatternWise.LinkedList.SlowAndFastPointer;

import com.dsa.LinkedList.Node;
import static com.dsa.LinkedList.Utility.convertArrayToLL;

// 143. Reorder List
public class ReorderList {

    public static void main(String[] args) {
        ReorderList r = new ReorderList();

        int[] nums = {1, 2, 3, 4, 5};

        Node head = convertArrayToLL(nums);

        r.reorderList(head);
    }

    public void reorderList(Node head) {
        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        Node curr = slow.next;
        slow.next = null;
        Node reverseHead = rev(curr);
        Node temp = head;

        while (reverseHead != null){
            Node next = temp.next;
            Node revNext = reverseHead.next;

            temp.next = reverseHead;
            reverseHead.next = next;

            temp = next;
            reverseHead = revNext;
        }
    }

    public Node rev(Node head){
        Node temp = head;
        Node prev = null;

        while (temp != null){
            Node next = temp.next;
            temp.next = prev;
            prev = temp;
            temp = next;
        }

        return prev;
    }

}
