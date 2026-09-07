package com.dsa.PatternWise.Heap;

import com.dsa.LinkedList.Node;

import java.util.Comparator;
import java.util.PriorityQueue;

import static com.dsa.LinkedList.Utility.convertArrayToLL;
import static com.dsa.LinkedList.Utility.printLL;

// 23. Merge k Sorted Lists

class Pair {
    int value;
    Node node;

    Pair(int value, Node node){
        this.value = value;
        this.node = node;
    }
}

public class MergeKSortedLists {

    public static void main(String[] args) {
        int[] l1 = {1,4,5};
        int[] l2 = {1,3,4};
        int[] l3 = {2,6};

        Node h1 = convertArrayToLL(l1);
        Node h2 = convertArrayToLL(l2);
        Node h3 = convertArrayToLL(l3);


        Node[] ls = new Node[3];
        ls[0] = h1;
        ls[1] = h2;
        ls[2] = h3;

        MergeKSortedLists m = new MergeKSortedLists();

        Node result = m.mergeKLists(ls);
        printLL(result);
    }

    public Node mergeKLists(Node[] lists) {

        PriorityQueue<Pair> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a.value));

        for (Node node : lists) {
            if (node != null){
                pq.offer(new Pair(node.data, node));
            }
        }

        Node res = new Node(-1);
        Node temp = res;

        while (!pq.isEmpty()){
            Pair p = pq.poll();
            Node node = p.node;

            temp.next = node;
            temp = temp.next;

            if (node.next != null){
                pq.offer(new Pair(node.next.data, node.next));
            }
        }

        return res.next;
    }



}
