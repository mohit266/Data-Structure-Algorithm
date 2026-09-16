package com.dsa.DailyChallenges;

import com.dsa.LinkedList.Node;

import static com.dsa.LinkedList.Utility.convertArrayToLL;

// 24. Swap Nodes in Pairs
public class SwapPairs {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4};

        SwapPairs s = new SwapPairs();

        Node head = convertArrayToLL(arr);

        Node n =  s.swapPairs(head);
        System.out.println(n);

    }

    public Node swapPairs(Node head) {

        if (head == null || head.next == null){
            return head;
        }

        Node prev = new Node(-1);
        Node temp = prev;

        while(head != null && head.next != null){
            Node currentNode = head;
            Node nextNode = head.next;

            head = nextNode.next;

            currentNode.next = nextNode.next;
            nextNode.next = currentNode;

            temp.next = nextNode;
            temp = currentNode;
        }

        return prev.next;
    }

}
