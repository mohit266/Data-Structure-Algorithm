package com.dsa.LinkedList;

public class IntersectionInLL {
    public static void main(String[] args) {
    }

    public Node getIntersectionNode(Node headA, Node headB) {
        Node t1 = headA;
        Node t2 = headB;

        while (t1 != t2){
            t1 = t1.next;
            t2 = t2.next;

            if (t1 == t2) return t1;

            if (t1 == null){
                t1 = headB;
            }
            if (t2 == null){
                t2 = headA;
            }
        }
        return t1;
    }
}
